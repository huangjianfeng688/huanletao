# 欢乐淘

#### 介绍
校园二手交易平台，系统分为后台管理系统，前台门户子系统。
后台管理系统主要是对平台的用户进行管理和监控，
对发布的二手商品进行审核，对交易进行审核，

前台门户子系统游客即未进行注册成为本平台会员的用户，可以浏览平台发布的商品，搜索商品。
但是只有注册成为本平台的用户才可以与商品主人进行交易，以及发布自己的二手商品。

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


###  **后台管理系统 **
![输入图片说明](https://images.gitee.com/uploads/images/2020/0821/095643_4a12e897_5362924.png "屏幕截图.png")

 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0117/001819_cc11a052_5362924.png "后台管理.png")
 **后台管理，主要对商品进行管理，订单管理，用户管理，广告管理，商品审核等，对平台进行管理。** 

### 定时任务
![输入图片说明](https://images.gitee.com/uploads/images/2020/0925/131504_ecd7e8e0_5362924.png "定时任务.png")

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

#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
