package com.nanchengyu.nanchengyubi.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author nanchengyu
 */
public interface FileService {
    /**
     * 上传头像到OSS
     *
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
