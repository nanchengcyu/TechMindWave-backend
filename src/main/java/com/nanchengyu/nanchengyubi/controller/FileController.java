package com.nanchengyu.nanchengyubi.controller;

import cn.hutool.core.io.FileUtil;
import com.nanchengyu.nanchengyubi.common.AuthAccess;
import com.nanchengyu.nanchengyubi.common.BaseResponse;
import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.common.ResultUtils;
import com.nanchengyu.nanchengyubi.exception.BusinessException;
import com.nanchengyu.nanchengyubi.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author nanchengyu
 * 文件上传接口
 */
@Api(tags = "文件管理")
@RestController
@RequestMapping("/oss")
//@CrossOrigin(origins = "http://bi.kongshier.top", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:800", allowCredentials = "true")
//@CrossOrigin(origins = "https://techmindwave.nanchengyu.cn", allowCredentials = "true")

//@CrossOrigin(origins = {"https://techmindwave.nanchengyu.cn", "http://localhost:800"}, allowCredentials = "true")
//@CrossOrigin(origins = {"https://techmindwave.nanchengyu.cn", "http://localhost:800","http://106.14.202.122:800","https://106.14.202.122:80","https://106.14.202.122:443"}, allowCredentials = "true")
public class FileController {

    @Resource
    private FileService ossService;
    @Value("${ip:localhost}")
    String ip;

    @Value("${server.port}")
    String port;
    private static final String ROOT_PATH =  System.getProperty("user.dir") + File.separator + "files";  // D:\B站\小白做毕设2024\代码\小白做毕设2024\files

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
//    @ApiOperation(value = "文件上传")
//    @PostMapping("/upload")
//    public BaseResponse<String> uploadOssFile(@RequestPart("file") MultipartFile file) {
//        //获取上传的文件
//        if (file.isEmpty()) {
//            throw new BusinessException(ErrorCode.NULL_ERROR, "上传文件为空");
//        }
//        //返回上传到oss的路径
//        String url = ossService.uploadFileAvatar(file);
//        //返回r对象
//        return ResultUtils.success(url);
//    }

    /**
     * 上传到本地 不再上传到oss
     * @param file
     * @return
     * @throws IOException
     */

    @PostMapping("/upload")
    public BaseResponse upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();  // 文件的原始名称
        // aaa.png
        String mainName = FileUtil.mainName(originalFilename);  // aaa
        String extName = FileUtil.extName(originalFilename);// png
        if (!FileUtil.exist(ROOT_PATH)) {
            FileUtil.mkdir(ROOT_PATH);  // 如果当前文件的父级目录不存在，就创建
        }
        if (FileUtil.exist(ROOT_PATH + File.separator + originalFilename)) {  // 如果当前上传的文件已经存在了，那么这个时候我就要重名一个文件名称
            originalFilename = System.currentTimeMillis() + "_" + mainName + "." + extName;
        }
        File saveFile = new File(ROOT_PATH + File.separator + originalFilename);
        file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去
        String url = "http://" + ip + ":" + port + "/api/oss/download/" + originalFilename;
        return ResultUtils.success(url);  //返回文件的链接，这个链接就是文件的下载地址，这个下载地址就是我的后台提供出来的
    }

    @AuthAccess
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
//        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 附件下载
        response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 预览
        String filePath = ROOT_PATH  + File.separator + fileName;
        if (!FileUtil.exist(filePath)) {
            return;
        }
        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);  // 数组是一个字节数组，也就是文件的字节流数组
        outputStream.flush();
        outputStream.close();
    }

}
