🥷作者：南城余<br />
📕公众号：南城余<br />
本期公众号网址：<br />
https://mp.weixin.qq.com/s/FlzCd4PqOReqxszU6Nfw_g
-----------------------------
相关笔记链接🔗<br />
南城余：https://www.yuque.com/g/nanchengcyu/dubfny/ibwmnan5bo9uf51x/collaborator/join?token=wkxCKWCK5Lt3BlsI&source=doc_collaborator# 《TechMindWave》<br />
知识星球：[https://bcdh.yuque.com/staff-wpxfif/resource/oywzglpnxegf579a](https://bcdh.yuque.com/staff-wpxfif/resource/oywzglpnxegf579a)<br />猫十二：[https://www.yuque.com/kcsshier/zpovmy/frhxvidgief5r5df?singleDoc](https://www.yuque.com/kcsshier/zpovmy/frhxvidgief5r5df?singleDoc)
# 上传前后端代码教程
相关链接🔗：<br />[https://zhuanlan.zhihu.com/p/193140870](https://zhuanlan.zhihu.com/p/193140870)<br />前端代码：<br />[https://github.com/nanchengcyu/TechMindWave-frontend](https://github.com/nanchengcyu/TechMindWave-frontend)<br />后端代码：<br />[https://github.com/nanchengcyu/TechMindWave-backend](https://github.com/nanchengcyu/TechMindWave-backend)

## 1）在GitHub上创建仓库
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692242894607-117b277f-4f70-467c-9ba8-a759e8787307.png#averageHue=%23625347&clientId=ud9dbfae2-3dbc-4&from=paste&height=687&id=u00be1bb2&originHeight=859&originWidth=1886&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=460970&status=done&style=none&taskId=udea4faed-af99-45ba-b531-c57af2f2253&title=&width=1508.8)


![创建成功后，你可能用到的命令](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692243009840-75d03b0d-a569-4da8-879b-3a40e8fbff95.png#averageHue=%23e8ebc2&clientId=ud9dbfae2-3dbc-4&from=paste&height=666&id=u166f50d0&originHeight=833&originWidth=1793&originalType=binary&ratio=1.25&rotation=0&showTitle=true&size=118343&status=done&style=none&taskId=u9a180c5e-6386-4b23-989c-2c28ceaf257&title=%E5%88%9B%E5%BB%BA%E6%88%90%E5%8A%9F%E5%90%8E%EF%BC%8C%E4%BD%A0%E5%8F%AF%E8%83%BD%E7%94%A8%E5%88%B0%E7%9A%84%E5%91%BD%E4%BB%A4&width=1434.4 "创建成功后，你可能用到的命令")
## 2）建立本地仓库
![进入git命令台](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692243278870-bf82f194-3176-41b5-aab8-444ab462455e.png#averageHue=%23f3f2f1&clientId=ud9dbfae2-3dbc-4&from=paste&height=744&id=u2f110eff&originHeight=930&originWidth=871&originalType=binary&ratio=1.25&rotation=0&showTitle=true&size=134274&status=done&style=none&taskId=u24a3f8a8-9c04-44ea-ba57-a17909e7219&title=%E8%BF%9B%E5%85%A5git%E5%91%BD%E4%BB%A4%E5%8F%B0&width=696.8 "进入git命令台")<br />![输入git init,初始化项目](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692243317002-234e8e5f-c735-4183-8892-8ca7c94eaa9d.png#averageHue=%230a0a0a&clientId=ud9dbfae2-3dbc-4&from=paste&height=368&id=ua2b7a030&originHeight=460&originWidth=736&originalType=binary&ratio=1.25&rotation=0&showTitle=true&size=22981&status=done&style=none&taskId=ub5da484f-0a3d-43dc-b2ed-12a34e18cae&title=%E8%BE%93%E5%85%A5git%20init%2C%E5%88%9D%E5%A7%8B%E5%8C%96%E9%A1%B9%E7%9B%AE&width=588.8 "输入git init,初始化项目")
## 3） 将所有文件添加到仓库中
```powershell
 git add  .
```
## 4）修改文件描述
```powershell
git commit -m "first commit"
```
## 5）关联github仓库
```powershell
git branch -M main
git remote add origin git@github.com:nanchengcyu/TechMindWave-frontend.git
```
## 6）上传本地代码
```powershell
git push -u origin main
```
# 项目背景
## 什么是 BI？
<br />即商业智能：数据可视化、报表可视化系统<br />主流 BI 平台：帆软 BI、小马 BI、微软 Power BI

![](https://cdn.nlark.com/yuque/0/2023/jpeg/398476/1682597396124-26fe5038-281f-4841-b200-85a807df7144.jpeg?x-oss-process=image%2Fresize%2Cw_853%2Climit_0%2Finterlace%2C1#averageHue=%2315254f&from=url&id=NFrWp&originHeight=500&originWidth=853&originalType=binary&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&title=)<br />传统 BI 平台：<br />[https://chartcube.alipay.com/](https://chartcube.alipay.com/)<br />1需要人工上传数据<br />2需要人工拖选分析要用到的数据行和列（数据分析师）<br />3需要人工选择图表类型（数据分析师）<br />4生成图表并保存配置

智能 BI 平台：<br />区别于传统的 BI，用户（数据分析者）只需要导入最最最原始的数据集，输入想要进行分析的目标（比如帮我分析一下网站的增长趋势），就能利用 AI 自动生成一个符合要求的图表以及结论。

优点：让不会数据分析的同学也能通过输入目标快速完成数据分析，大幅节约人力成本。<br />会用到 AI 接口

## 需求分析
<br />1智能分析：用户输入目标和原始数据（图表类型），可以自动生成图表和分析结论<br />2图表管理<br />3图表生成的异步化（消息队列）<br />4对接 AI 能力
## <br />架构图
<br />基础流程：<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692241892649-b6c8a9cf-b3d3-4d47-b4c1-f7c5301a16bd.png#averageHue=%23fdfdfd&clientId=ud9dbfae2-3dbc-4&from=paste&height=482&id=u70fcfabc&originHeight=603&originWidth=1085&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=33979&status=done&style=none&taskId=u369360d3-cfc2-43dd-ad5a-96f97413e88&title=&width=868)<br />优化流程（异步化）：
## ![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692241866453-27166d81-a6c1-4684-9e66-9d3dcd32aecc.png#averageHue=%23fdfdfd&clientId=ud9dbfae2-3dbc-4&from=paste&height=526&id=u7bf04a27&originHeight=658&originWidth=1215&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42915&status=done&style=none&taskId=u5c729c78-3570-4732-89da-427dfa12436&title=&width=972)<br /><br /><br />

## 技术栈
<br />前端<br />1.React<br />2.Umi<br />3.Ant Design Pro<br />4.可视化开发库：**Echarts** √ 、HighChairts + AntV<br />5.umi openapi 代码生成：自动生成后端调用代码<br />6.EChart 图表生成

后端<br />1.Spring Boot：万用模板<br />2.MySQL数据库<br />3.Redis：Redissson限流控制<br />4.MyBatis Plus 数据库访问结构<br />5.消息队列：RabbitMQ<br />6.AI能力：Open AI接口开发<br />7.Excel上传和数据的解析：Easy Excel<br />8.Swagger + Knife4j 项目文档<br />9.Hutool 工具库

 
# 平台功能介绍

1. 用户登录，注册。
2. 智能图表分析（同步）。调用AI根据用户上传csv文件生成对应的 JSON 数据，并使用 ECharts图表 将分析结果可视化展示。
3. 智能图表分析（异步）。使用了线程池异步生成图表，最后将线程池改造成使用 RabbitMQ消息队列 保证消息的可靠性，实现消息重试机制。
4. 智能文本分析（异步）。使用了线程池异步生成markdown文本，最后将线程池改造成使用 RabbitMQ消息队列 保证消息的可靠性，实现消息重试机制。
5. 智能问题分析（异步）。使用了线程池异步生成问题解决答案，最后将线程池改造成使用 RabbitMQ消息队列 保证消息的可靠性，实现消息重试机制。
6. 个人管理图表/文本/问题，增删改查。
7. 个人信息管理，头像，名字，账号等的修改。
8. 管理员管理，支持图表/文本/问题增删改查，新增用户，修改用户，删除用户，查看用户，增删改查等。
9. 用户限流。本项目使用到令牌桶限流算法，使用Redisson实现简单且高效分布式限流，限制用户每秒只能调用一次数据分析接口，防止用户恶意占用系统资源
10. 调用AI进行数据分析，并控制AI的输出。
11. 由于AIGC的输入 Token 限制，使用 Easy Excel 解析用户上传的 XLSX 表格数据文件并压缩为CSV，实测提高了20%的单次输入数据量、并节约了成本。
12. 后端自定义 Prompt 预设模板并封装用户输入的数据和分析诉求，通过对接 AIGC 接口生成可视化图表 JSON 配置和分析结论，返回给前端渲染。
# 平台相关页面截图展示
![首页页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692149977291-aaddfb68-5c56-4727-a754-079a18dc7b11.png#averageHue=%23dbdbdb&clientId=u89865a8c-93b4-4&from=paste&height=812&id=u8603ce48&originHeight=913&originWidth=1912&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=218891&status=done&style=none&taskId=u20e08e6a-b527-46e7-93db-8884bddc2a2&title=%E9%A6%96%E9%A1%B5%E9%A1%B5%E9%9D%A2&width=1699.5555555555557 "首页页面")<br />![图表分析页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692149995220-cb2d66d2-3d6f-4846-b2ea-6747c5fa5ded.png#averageHue=%23f7f7f7&clientId=u89865a8c-93b4-4&from=paste&height=828&id=u867fe001&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=131008&status=done&style=none&taskId=u29b93d2b-9a2c-45cf-8132-76abff25fab&title=%E5%9B%BE%E8%A1%A8%E5%88%86%E6%9E%90%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "图表分析页面")![文本分析页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692150009512-4c214b8e-f755-4c5f-99bf-83bad8da5e2f.png#averageHue=%23f7f7f7&clientId=u89865a8c-93b4-4&from=paste&height=828&id=u12a7dc48&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=101927&status=done&style=none&taskId=u1c9290f9-baaf-4793-b0ff-61d10b4464d&title=%E6%96%87%E6%9C%AC%E5%88%86%E6%9E%90%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "文本分析页面")![图表管理页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692150023359-89607aee-97d7-47e6-9b18-1dec8177296c.png#averageHue=%23f9f8f8&clientId=u89865a8c-93b4-4&from=paste&height=828&id=u3f497eea&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=159398&status=done&style=none&taskId=uc8bb85ee-f4f7-445d-85a9-bd96fa59c25&title=%E5%9B%BE%E8%A1%A8%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "图表管理页面")![个人信息页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692150045086-3470749e-e4ee-4358-8f3d-9212627a1f08.png#averageHue=%23f2f1f1&clientId=u89865a8c-93b4-4&from=paste&height=828&id=u401bcac6&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=244737&status=done&style=none&taskId=u9c77c757-3d30-4bd0-81fa-af32246d0e4&title=%E4%B8%AA%E4%BA%BA%E4%BF%A1%E6%81%AF%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "个人信息页面")![管理员页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692150061730-2d507095-9016-4a6a-920e-2a997d2a3a2e.png#averageHue=%23f9f9f9&clientId=u89865a8c-93b4-4&from=paste&height=828&id=ud8d5792f&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=140345&status=done&style=none&taskId=ua6cc4a1d-6e1b-4eef-9c98-de72f9c56bf&title=%E7%AE%A1%E7%90%86%E5%91%98%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "管理员页面")![对话管理页面](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692150093763-6aea386c-9050-46d3-ae99-5a920f1e3e0d.png#averageHue=%23f8f8f8&clientId=u89865a8c-93b4-4&from=paste&height=828&id=u246a3c6d&originHeight=932&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=true&size=157872&status=done&style=none&taskId=ue5a5807a-2ba4-4ae6-9423-32f4cce6703&title=%E5%AF%B9%E8%AF%9D%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2&width=1706.6666666666667 "对话管理页面")
# 网站名字
改名了，这是之前版本的名字<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1690613665566-98db09d9-582a-4f6a-b227-3915cc1db191.png#averageHue=%23eceef1&clientId=u5ec0ec5b-68b6-4&from=paste&height=620&id=u47647def&originHeight=775&originWidth=1073&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=123101&status=done&style=none&taskId=ubf95fd04-e8af-4234-8a29-a5d4ebba3e5&title=&width=858.4)
## 我的选择
**WiseGraphs**：将"Wise"（意为智慧）和"Graphs"（意为图表）结合，强调图表的智能化。<br />副标题：智能可视化，数据一目了然
# 前后端相关网站链接
RabbitMQ网站地址：<br />[http://localhost:15672/#/](http://localhost:15672/#/)<br />ant-design 官网镜像地址:<br />[http://ant-design.gitee.io/index-cn](http://ant-design.gitee.io/index-cn)<br />ant-design-pro镜像地址：<br />[http://ant-design-pro.gitee.io/index-cn](http://ant-design-pro.gitee.io/index-cn)<br />antd-mobile镜像地址：<br />[https://antd-mobile.gitee.io/index-cn](https://antd-mobile.gitee.io/index-cn)
# 前端项目初始化
Install node_modules:
:::tips
`npm install `
:::
OR
:::tips
`yarn`
:::
启动项目
:::tips
`npm start`
:::
构建项目
:::tips
`npm run dev`
:::
## 前端初始化问题解决
1.依赖缺失解决（主要更改包名后的报错解决方法）<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691917628292-9bf072fb-1806-44af-9f7c-85903ca2e8f4.png#averageHue=%23937752&clientId=ua6d5c7fc-89ab-4&from=paste&height=163&id=ue8eb4cd3&originHeight=183&originWidth=1749&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=44172&status=done&style=none&taskId=u04ec668e-430b-4c3f-a4e9-2ba0a207334&title=&width=1554.6666666666667)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691917025026-1d918f22-7772-48ea-821c-abee9a711568.png#averageHue=%23e1e3e6&clientId=ua6d5c7fc-89ab-4&from=paste&height=681&id=u644716ad&originHeight=766&originWidth=968&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=94608&status=done&style=none&taskId=u8947f2c7-5f78-4095-a261-b5b962b7309&title=&width=860.4444444444445)


# 后端项目初始化

1. 下载/拉取本项目到本地
2. 通过 IDEA 代码编辑器进行打开项目，等待依赖的下载
3. 修改配置文件 application.yaml 的信息，比如数据库、Redis、RabbitMQ等
4. 修改信息完成后，通过 NanchengyuApplication 程序进行运行项目
5.  队列生成

![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692096499289-f59f2110-6354-455d-9e96-232a1bf2dd9e.png#averageHue=%2388a084&clientId=u795be8c6-ed62-4&from=paste&height=915&id=u68481ad9&originHeight=1029&originWidth=1920&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=265122&status=done&style=none&taskId=ue8f7d28c-115f-4cee-b998-218a064116a&title=&width=1706.6666666666667)
# 部署项目
## 部署方式
1）原生态部署方法，各种环境利用Linux指令安装（下面所有环境安装方法，MySQL、redis等）<br />2）docker容器打包方法，将所有的环境打包在docker容器中，包括前后端项目<br />3）利用第三方网站部署，如宝塔。
### 阿里云服务器重置以及安装宝塔
链接：<br />[https://blog.csdn.net/qq_44891617/article/details/123723766](https://blog.csdn.net/qq_44891617/article/details/123723766)
### 宝塔部署参考链接：
[https://www.cnblogs.com/galo/p/17539631.html](https://www.cnblogs.com/galo/p/17539631.html)<br />**宝塔 运行jar目录参考**<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692457928169-717784eb-9d00-47ae-bab3-efdcd581dbed.png#averageHue=%23f7f6f5&clientId=ude611ee3-77db-4&from=paste&height=161&id=YxGQo&originHeight=181&originWidth=781&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=21223&status=done&style=none&taskId=u1745e929-fc45-403b-8209-7f44e13d019&title=&width=694.2222222222222)<br />---------------------------------------------------<br />下面所有方法都为1）的部署方法-原生安装方法
## 前端
## 前端打包
webstrom<br />npm run build 
## 前端环境
nginx
## 前端环境安装
### nginx下载安装
```powershell
1）利用centosyum下载
yum 
or 利用官网链接下载 
curl -o  [filename] [curl] 
2)解压安装
tar -zxvf nginx-1.24.0.tar.gz  
3)相关依赖安装
yum install pcre pcre-devel -y
yum install openssl openssl-devel -y
./configure --with-http_ssl_module--with-http_v2_module--with-stream
4）编译安装
make
make install
5）编译配置环境
ls /usr/local/nginx/sbin/nginx
vim /etc/profile
（shift+g）快速跳到编译文件最后一行
在最后一行添加：
export PATH=$PATH:/usr/local/nginx/sbin	
6）启动nginx
source /etc/profile 刷新配置文件
nginx
6）查看端口启动情况
netstat -ntlp 
```
## 后端
## 后端打包
后端多环境运行配置<br />在企业项目运行时，一般会经历开发-测试等多个环节，因此需要一套代码多个环境，项目上线打包的时候只需要修改application.yml配置即可，详情可看下图<br />相关链接：<br />[**https://zhuanlan.zhihu.com/p/148823337**](https://zhuanlan.zhihu.com/p/148823337)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692377630377-213afc21-1056-4e57-aef0-7599d7577b3b.png#averageHue=%232c2b2b&clientId=u14a0d5fa-cf67-4&from=paste&height=684&id=T8nnL&originHeight=770&originWidth=1245&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=91115&status=done&style=none&taskId=ube7e21aa-41d6-4657-8611-7df72a9f873&title=&width=1106.6666666666667)

参考链接：<br />[https://www.cnblogs.com/galo/p/17539631.html](https://www.cnblogs.com/galo/p/17539631.html)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692438395721-3446362b-67fe-4f89-ae0d-5940d384cdd4.png#averageHue=%23657d78&clientId=u86e02222-a162-4&from=paste&height=625&id=lm7vN&originHeight=703&originWidth=870&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=83708&status=done&style=none&taskId=ufab0a62f-22ae-4fa6-926c-9e56bd96ed3&title=&width=773.3333333333334)
## 后端环境
Java maven MySQL  Redis RabbitMQ  Java版本<br />**推到重来，建议全部安装利用podman/docker安装**
## 后端环境安装
### Java maven安装
```powershell
yum install -y java-1.8.0-openjdk*
curl -o apache-maven-3.8.5-bin.tar.gz https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz
tar -zxvf apache-maven-3.8.5-bin.tar.gz 
git clone xxx 下载代码
打包构建，跳过测试
mvn package -DskipTests
java -jar ./user-center-backend-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

### MySQL安装
参考网站链接：<br />[https://blog.csdn.net/wangpaiblog/article/details/120259448](https://blog.csdn.net/wangpaiblog/article/details/120259448)<br />MySQL镜像网：<br />[https://mirrors.aliyun.com/mysql/MySQL-8.0/?spm=a2c6h.25603864.0.0.6a2f712bwfBnNT](https://mirrors.aliyun.com/mysql/MySQL-8.0/?spm=a2c6h.25603864.0.0.6a2f712bwfBnNT)
### RabbitMQ安装
参考网站 <br />[https://blog.csdn.net/qq_45173404/article/details/116429302](https://blog.csdn.net/qq_45173404/article/details/116429302)<br />下载网站<br />[https://www.rabbitmq.com/download.html](https://www.rabbitmq.com/download.html)<br />问题解决方案<br />**rabbitmq用户管理(Not management user问题解决)**<br />参考链接：[https://blog.csdn.net/qq_24095055/article/details/97001679](https://blog.csdn.net/qq_24095055/article/details/97001679)<br />建议最后执行<br />rabbitmqctl set_user_tags 用户名 administrator<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692372479306-aff75300-ba68-4bf0-9cf2-c41eb805c748.png#averageHue=%23b7cecc&clientId=u14a0d5fa-cf67-4&from=paste&height=281&id=u6ca8902e&originHeight=316&originWidth=1011&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=38973&status=done&style=none&taskId=uc49a6852-1305-4e1f-b230-cb552ad79ae&title=&width=898.6666666666666)
### redis安装
参考网站链接：<br />[https://blog.csdn.net/m0_37959155/article/details/108897863](https://blog.csdn.net/m0_37959155/article/details/108897863)<br />[https://blog.csdn.net/u012723183/article/details/105970244](https://blog.csdn.net/u012723183/article/details/105970244)（阿里云推荐）<br />**推到重来，建议全部安装利用podman/docker安装**<br />![618b254bedf292b6d07e69a38d3a7ca.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692437542896-3defd52a-a3b5-44b4-8a54-de70760606d9.png#averageHue=%23313131&clientId=u86e02222-a162-4&from=paste&height=734&id=u606014a0&originHeight=826&originWidth=862&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=62442&status=done&style=none&taskId=ubb4cfc40-f754-42bc-849f-513dbdc5e90&title=&width=766.2222222222222)

# 问题复盘
在项目中，遇到的相关问题解决方案记录。
## 报错解决方案
1.推荐先去问ChatGPT,可以解决百分之80的问题（建立在你的表述无误的情况下） <br />2.浏览器搜索方法（推荐顺序谷歌>百度）<br />3.开源项目可以去GitHub解决

## 1）动态SQL获取   视频时间1.43.30
## 2）前端我的图表显示不出来 回放 第四期
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1690713354643-966bc815-7bcb-4f38-9b4c-a733e61c8d8b.png#averageHue=%23c4cbd1&clientId=u05f3b7cf-d77b-4&from=paste&height=419&id=u02d076fe&originHeight=524&originWidth=1696&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=72535&status=done&style=none&taskId=u68cda9b4-d751-40a2-b58b-72a39892e3d&title=&width=1356.8)<br />后端原因没有解决好
## 3）异步页面处理
视频在第五期 2.2.30
## 4）mq队列
视频第七期 2.31.08<br />对应包 bizmq
## 5）修改接口
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691232610160-0f656156-22c6-4760-9c4f-75752945f000.png#averageHue=%23594f45&clientId=u716d0446-041d-4&from=paste&height=328&id=u40e38600&originHeight=369&originWidth=553&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=37118&status=done&style=none&taskId=u2f23b935-5315-4cab-9f50-eaf9730d87b&title=&width=491.55555555555554)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691232590599-911b7692-6d05-4a3e-bf77-82265e2750ca.png#averageHue=%23f0efef&clientId=u716d0446-041d-4&from=paste&height=108&id=ucd2e162f&originHeight=121&originWidth=300&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=9254&status=done&style=none&taskId=u7a7e56be-4ec4-4823-9af0-8e0de258950&title=&width=266.6666666666667)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691232645352-f5611bf6-d5cb-47a8-b6c4-727c19be77ca.png#averageHue=%232d2b2b&clientId=u716d0446-041d-4&from=paste&height=554&id=u9e6ca7f4&originHeight=623&originWidth=1161&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=79517&status=done&style=none&taskId=u818cd5a0-70f9-467e-9499-d5e03f9044e&title=&width=1032)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691232623633-48804555-b0a7-456c-aa25-b3905434f160.png#averageHue=%232c404d&clientId=u716d0446-041d-4&from=paste&height=787&id=uc7620107&originHeight=885&originWidth=408&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=47029&status=done&style=none&taskId=ud15b0d7b-ca53-4ce1-bb77-07d73ab4f14&title=&width=362.6666666666667)
## 6)更改前端代码openapi接口
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691237804642-4951f5df-2c2b-41fa-91b4-1ebadeb3ef3b.png#averageHue=%2361654e&clientId=u716d0446-041d-4&from=paste&height=888&id=u0549b6c1&originHeight=999&originWidth=1899&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=215380&status=done&style=none&taskId=ub6140519-56a6-4599-8805-3014b4afdff&title=&width=1688)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691239197929-1c8842bc-a7d2-4b15-aab9-de49e6313d89.png#averageHue=%2358634f&clientId=u716d0446-041d-4&from=paste&height=907&id=u60e24e18&originHeight=1020&originWidth=1915&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=215597&status=done&style=none&taskId=u36768fd6-9f44-404d-8135-339cd8a4c94&title=&width=1702.2222222222222)
## 7）Redis高版本下载
[https://blog.csdn.net/dwh19992018/article/details/129750566](https://blog.csdn.net/dwh19992018/article/details/129750566)
## 8)更改前端图标
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691252258841-f8ec971c-d9ef-4127-8cff-809a16a95ed4.png#averageHue=%23f7f7f7&clientId=ud04c1ece-40ff-4&from=paste&height=794&id=ud5eec215&originHeight=893&originWidth=1909&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=108314&status=done&style=none&taskId=u7931cb32-7099-43ee-a30a-ade0e3d751e&title=&width=1696.888888888889)<br />app.tsx文件<br />![7bc44ed97fd7e28328e556dfcb98b1e.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691252270286-6a37c8a3-3e52-4478-b27f-3eaae4a29879.png#averageHue=%23212428&clientId=ud04c1ece-40ff-4&from=paste&height=996&id=u5e32deeb&originHeight=1121&originWidth=1899&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=135991&status=done&style=none&taskId=ue98478ff-f248-4d4e-bed5-0770eb73ad0&title=&width=1688)<br />defaultSetting文件<br />![71f3180eb1f457db6a0293fb83ff74f.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691252279137-4cedd23f-5381-4b95-a07d-7a80f5d4bc44.png#averageHue=%231e2023&clientId=ud04c1ece-40ff-4&from=paste&height=586&id=u0ad743a3&originHeight=659&originWidth=861&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=49295&status=done&style=none&taskId=ucd580101-8b5a-4af8-8bd0-e129211f775&title=&width=765.3333333333334)
## 9）引入mybaits-plus √
用户中心第一期 项目视频 1.58.42
## 10）引入junit -单元测试库 √
用户中心第一期 视频 2.15.29
## 11)注册 id
用户中心终 视频 0.53.00<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691774273336-9141c49b-2cf7-426e-a5c9-78c58781021a.png#averageHue=%2388764b&clientId=u9bd17614-e208-4&from=paste&height=563&id=u2226a9cc&originHeight=633&originWidth=1251&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=100697&status=done&style=none&taskId=u957686fc-b4a3-498c-8a1b-46152564c9b&title=&width=1112)
## 12）mq队列
BI第七期 1.52.0
## 13）运行npm install 时，卡在sill install loadAllDepsIntoIdealTree不动
相关链接[https://blog.csdn.net/zjq_1234/article/details/88946863](https://blog.csdn.net/zjq_1234/article/details/88946863)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691938376220-bd8ec668-0e6f-4fe3-af4d-d3a30ed40c0d.png#averageHue=%23fcfcfb&clientId=ubb73a03f-1eed-4&from=paste&height=683&id=ua4446a38&originHeight=768&originWidth=1301&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=117487&status=done&style=none&taskId=u198135df-b604-4434-bf3e-da761900c75&title=&width=1156.4444444444443)

1. npm install一直停留在fetchMetadata: sill mapToRegistry uri http://registry.npmjs.org/whatwg-fetch可以使用如下命令设置为淘宝的镜像源：

npm config set registry [https://registry.npm.taobao.org](https://registry.npm.taobao.org)<br />2. 使用如下命令检验是否成功：<br />npm config get registry<br />输出淘宝镜像路径

3. 继续运行 npm install ,安装过程畅通无阻
## 14）erro报错
![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1692067729129-21490ebe-1aea-4fab-81c8-16d8c555bab8.png#averageHue=%239f9272&clientId=ubc867c54-32ab-4&from=paste&height=228&id=UWx8k&originHeight=256&originWidth=1627&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=117632&status=done&style=none&taskId=u67e178e8-d326-478b-8b2d-877590ec7c0&title=&width=1446.2222222222222)<br />这个报错是由于在RabbitMQ中的队列参数不匹配导致的。错误信息中提到了问题所在：

```
inequivalent arg 'x-dead-letter-exchange' for queue 'ai_question_queue' in vhost '/': received none but current is the value 'ai-dlx-exchange' of type 'longstr'
```

**这个错误表示在队列 **`**ai_question_queue**`** 的参数 **`**x-dead-letter-exchange**`** 不匹配，当前值是 **`**'ai-dlx-exchange'**`**，但接收到的值是 **`**none**`**。这可能是因为队列在声明的时候参数设置不一致导致的。**

**要解决这个问题，你需要确保你的队列声明参数与之前定义的参数一致。具体来说，检查队列 **`**ai_question_queue**`** 的声明，并确保在声明时设置了正确的 **`**x-dead-letter-exchange**`** 参数。**

**如果你使用代码声明队列，可以类似以下方式来设置参数：**

```java
Map<String, Object> args = new HashMap<>();
args.put("x-dead-letter-exchange", "ai-dlx-exchange"); // 设置正确的死信交换机
Queue queue = new Queue("ai_question_queue", true, false, false, args);
```

**如果你在 RabbitMQ 的管理界面中手动创建队列，确保在队列的参数设置中包含了正确的 **`**x-dead-letter-exchange**`** 值。**

**总之，解决这个问题的关键是确保队列参数的一致性，特别是 **`**x-dead-letter-exchange**`** 参数的设置。**
## 15）查询电脑端口占用情况命令
```powershell
netsh interface ipv4 show excludedportrange protocol=tcp
```

## 16）页面颜色
```
<div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
  <div style={{ background: '#007BFF', padding: '5px 10px', borderRadius: '4px', display: 'inline-block' }}>
    <Divider style={{ fontSize: '20px', fontWeight: 'bold', color: 'white', margin: 0 }}>分析结论</Divider>
  </div>
</div>
```
我的选择#007BFF<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/38420467/1691923561414-60df65e5-5f19-4aaa-a23a-3f56f50d9b3a.png#averageHue=%23306a3d&clientId=u5b821678-e0bc-4&from=paste&height=570&id=RQhvI&originHeight=641&originWidth=1166&originalType=binary&ratio=1.125&rotation=0&showTitle=false&size=59115&status=done&style=none&taskId=u37e6f9a2-10d4-4b16-b016-44e414029ba&title=&width=1036.4444444444443)
```css
/* 背景色为淡蓝色 */
body {
  background-color: #E6F7FF;
}

/* 正文文本颜色为深灰色 */
body {
  color: #333;
}

/* 链接颜色为浅蓝色，悬停时变为深蓝色 */
a {
  color: #007BFF;
}
a:hover {
  color: #0056b3;
}

/* 按钮背景色为浅绿色，文本颜色为白色 */
.button {
  background-color: #A7E1B1;
  color: white;
}

/* 提示框背景色为淡黄色，文本颜色为深灰色 */
.tooltip {
  background-color: #FFF3D9;
  color: #333;
}


```
## 17)宝塔部署vue项目刷新404解决方案
解决方案链接：<br />[https://blog.csdn.net/Mrzhao5788/article/details/120279306](https://blog.csdn.net/Mrzhao5788/article/details/120279306)
## 18）linux解压时报错： gzip: stdin: not in gzip format tar: Child returned status 1 tar: Error exit delayed
参考链接：<br />[https://blog.csdn.net/hjing123/article/details/88862650](https://blog.csdn.net/hjing123/article/details/88862650)
```powershell
去掉 z
#tar -vxf [解压文件名】
```
# idea快捷操作小技巧
在idea中如何进行单词的全局替换<br />先按ctrl+f再按ctrl+r<br />全局替换 crtl+shift+r<br />在idea中创建测试类快捷键 ctrl+shift+t  --> create new test<br />windows区域截图快捷键 win 键+ shift + s键 
# 
