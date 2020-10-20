# 欢乐淘

#### 介绍
校园二手交易平台，系统分为后台管理系统，前台门户子系统。
后台管理系统主要是对平台的用户进行管理和监控，
对发布的二手商品进行审核，对交易进行审核，

前台门户子系统游客即未进行注册成为本平台会员的用户，可以浏览平台发布的商品，搜索商品。
但是只有注册成为本平台的用户才可以与商品主人进行交易，以及发布自己的二手商品。

为了提高响应速度，提高用户体验，前台系统首页数据量比较多，每一个访问时都会请求大量的数据。
接下来我们的处理方案是引入缓存技术， 将前台首页的数据在项目启动时，就将数据库中的数据放入缓存中。 这样每一次访问时，都是从缓存中取出，
这样提高了响应速度，我技术选型上，我们选择redis。 在数据一致性方面我们也有相应的解决方案。


### 新增功能：
- 邮件短信通知。--> 添加订阅时，通知宝贝主人， 生成订单时，通知买家。
- 定时任务处理。--> 处理一些订单时间超过7天未处理的订单任务。
- 事务处理配置。--> 配置事务处理Service层。
- 日志输出文件。
- 支付宝支付功能。-->沙箱测试环境。
- 后台进行数据可视化。
- 后台新增生成代码模块。

平台开发使用的技术有：
后台：spirng，springmvc，mybaits，
前台：angularjs+bootstrap。
权限控制：shiro
搜索引擎：solr 分布式搜索引擎。
数据库：MySQL
开发环境与工具：IDEA+MAVEN

业务管理员：admin/123456
系统管理员：root/123456

### 项目运行效果图：

###  **后台管理系统 **
![输入图片说明](https://images.gitee.com/uploads/images/2020/1008/183522_f85589b1_5362924.png "屏幕截图.png")
 
系统管理员：主要是涉及系统的管理，权限，用户，定时任务，菜单，邮箱
!![输入图片说明](https://images.gitee.com/uploads/images/2020/1008/183555_56d0b3af_5362924.png "屏幕截图.png")

业务管理员：主要涉及业务方面的管理，商品管理，订单管理，分类管理，广告管理
![输入图片说明](https://images.gitee.com/uploads/images/2020/1008/183720_feddd93c_5362924.png "屏幕截图.png")



### 
 **平台首页，** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0117/001852_1afff768_5362924.png "平台首页.png")
有广告轮播图，收藏最多的商品信息，



 **闲置品详情页，** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0117/001924_42864fa3_5362924.png "闲置品详情页.png")
显示商品的详细信息， 如果没有登录，不得发表评论，收藏和想要，


 **搜索页，** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0117/002350_5203f6d0_5362924.png "搜索页.png")
功能，实现高亮查询，分类查询，关键字查询。

 **个人中心模块设计** 
![输入图片说明](https://images.gitee.com/uploads/images/2020/0220/141142_cf83bfa3_5362924.png "personalinfo.png")

 **发布新商品模块** 
![商品发布模块。](https://images.gitee.com/uploads/images/2020/0220/141225_808773c0_5362924.png "personalrele.png")




项目用到的组件：
  
   1.redis 缓存

   2.solr 搜索服务

   3.MySQL 数据库。


项目部署说明：
   1. 先启动redis 服务器。 下载好压缩包，直接解压运行旧可以了。

   2. 部署solr 服务器。

      2.1  将我提供的solr文件夹放到tomcat的webapp即可。 
      2.2  把solrHOME 文件夹放到D盘下，如果更换solrHome的位置，在solr 中的web.xml 的配置取修改即可。
           <env-entry>
                <env-entry-name>solr/home</env-entry-name>
                        <!-- 这里是solrHome文件夹的位置。-->
                <env-entry-value>{d:/solr_home}</env-entry-value>
                <env-entry-type>java.lang.String</env-entry-type>
           </env-entry>

    3. 创建huanletaodb 数据库，执行huanletao.sql 文件。【默认你已经安装好了数据库】

    4. 修改数据库连接密码和用户名【你自己的】

    5. 用idea 导入项目， 刷新maven 导入jar包

    6. 建议用maven的tomcat插件 启动项目。
       6.1 点击设置配置，添加maven 输入启动命令：tomcat7:run

    【注意】:项目第一次启动，会执行导入MySQL数据都solr索引库中。第二次启动时，去掉util.solrUtils 的 @PostConstruct 注解。