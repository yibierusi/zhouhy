/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(64) NOT NULL COMMENT '文章ID',
  `title` varchar(225) DEFAULT NULL COMMENT '文章标题',
  `content` text COMMENT '文章内容',
  `file_name` varchar(225) DEFAULT NULL COMMENT '文章文件名字',
  `sys_user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `reads` int(7) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `comments` int(7) NOT NULL DEFAULT '0' COMMENT '评论数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `source` int(1) DEFAULT '0' COMMENT '来源 0:网站发表 1:本地导入',
  `state` int(1) DEFAULT '0' COMMENT '文章状态 0：未删除  1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('21e71e0eed5e44c7a24777225ad3806a', 'hexo个人博客搭建（一）', '---\ntitle: hexo个人博客搭建（一）\ndate: 2018-07-25 15:10:53\ntags: hexo\n---\n## 前言 ##\n大学的时候就有写技术博客的习惯，那时在CSDN。毕业后比较忙，没时间去审词酌句写一篇完整的博客，大部分心得体会都写在有道云笔记中。但记笔记的效果是完全不能跟写博客相比的。一直想写一个自己的个人博客项目，但是没找到满意的前段模板也不想写大量的CSS，再加上备案也麻烦，一直搁浅到现在。无意间发现Hexo这个优秀的静态博客框架，所以写个博客记录一下，也给想搭建Hexo博客的朋友多一点参考。\n## 正文 ##\n### 环境 ###\n操作系统：Windwos 10\n\n需要安装的软件：Node.js。用来创建hexo博客框架的，我当前安装版本为node-v5.6.0-x64。\n\nNode.js的安装配置教程参照：https://www.runoob.com/nodejs/nodejs-install-setup.html\n\n### 安装Hexo ###\n在CMD下，利用 npm 命令即可安装。\n\n输入安装hexo命令：\n\n    npm install -g hexo\n或者\n\n    npm install hexo-cli -g\n\n安装完成后，在你想要搭建的路径下（如D:\\hexo），执行以下指令(在D:\\hexo下调用CMD，或者CMD下cd到D:\\hexo)，Hexo 即会自动在目标文件夹建立网站所需要的所有文件\n![](https://i.imgur.com/lhHV8Qh.png)\n\n    hexo init\n\n安装所需依赖包：\n\n    npm install\n\n安装后之后执行以下命令，#后为注释，不用输入\n\n    hexo g #用于生成静态文件\n    hexo s #用于启动服务器，主要用来本地预览\n\n\n此时访问路径http://localhost:4000 ，就可以看到一个搭建完成的hexo博客了，当前博客为本地预览版，外网不能访问。\n\n\n### Hexo常用的命令 ###\n介绍几个hexo常用的命令,通过`hexo n`生成md（生成的md文件位置D:\\hexo\\source\\_posts\\）。\n\n然后通过Markdown编辑器（这里推荐Markdownpad2编辑器）可以对博客进行编写，编写之后通过`hexo g`命令生成静态文件。\n\n执行`hexo s`用于启动服务器，主要用来本地预览。\n\n预览没问题之后通过`hexo d `将本地文件发布到你的github或者coding上。\n\n    hexo g #完整命令为hexo generate,用于生成静态文件\n    hexo s #完整命令为hexo server,用于启动服务器，主要用来本地预览\n    hexo d #完整命令为hexo deploy,用于将本地文件发布到github或者coding上\n    hexo n #完整命令为hexo new,用于新建一篇文章\n\n### hexo文目录 ###\n_**config.yml**:网站的 配置 信息，您可以在此配置大部分的参数。\n\n**package.json**:应用程序的信息。\n\n**scaffolds**:模版文件夹。当您新建文章时，Hexo会根据scaffold 来建立文件。\n\n**source**:资源文件夹是存放用户资源的地方。除posts文件夹之外，开头命名为(下划线)的文件/文件夹和隐藏的文件将会被忽略。Markdown和HTML文件会被解析并放到public文件夹，而其他文件会被拷贝过去。\n\n**themes**:主题 文件夹。Hexo会根据主题来生成静态页面。\n\n### hexo的_config.yml配置 ###\n\n    # Hexo Configuration\n    # Docs: https://hexo.io/docs/configuration.html\n    # Source: https://github.com/hexojs/hexo/\n\n	# Site  网站\n	title: zhouhy                                                              #网站标题\n	subtitle: 勤学如春起之苗，不见其增，日有所长；辍学如磨刀之石，不见其损，日有所亏。  #网站副标题\n	description: description                                                   #网站描述\n	keywords:\n	author: zhouhy                                                             #名字\n	language: zh_CN                                                            #网站使用的语言\n	timezone:                                                                  #网站时区。Hexo 默认使用您电脑的时区\n\n	# URL 网址\n	## 如果您的网站存放在子目录中，例如 http://yoursite.com/blog，则请将您的 url 设为 http://yoursite.com/blog 并把 root 设为 /blog/。\n	url: http://zhouhy.top\n	root: /\n	permalink: :year/:month/:day/:title/\n	permalink_defaults:\n	\n	# Directory 目录配置\n	source_dir: source	 	 #源文件夹，这个文件夹用来存放内容。\n	public_dir: public	     #公共文件夹，这个文件夹用于存放生成的站点文件。\n	tag_dir: tags		 	 #标签文件夹\n	archive_dir: archives	 #归档文件夹\n	category_dir: categories #分类文件夹\n	code_dir: downloads/code #nclude code 文件夹\n	i18n_dir: :lang		 	 #国际化（i18n）文件夹\n	skip_render:		 	 #跳过指定文件的渲染，您可使用 glob 表达式来匹配路径。\n	\n	# Writing 文章\n	new_post_name: :title.md # 新建文章默认文件名\n	default_layout: post     # 默认布局\n	titlecase: false 		 # Transform title into titlecase\n	external_link: true 	 # 在新标签中打开一个外部链接，默认为true\n	filename_case: 0    	 #转换文件名，1代表小写；2代表大写；默认为0，意思就是创建文章的时候，是否自动帮你转换文件名，默认就行，意义不大。\n	render_drafts: false  	 #是否渲染_drafts目录下的文章，默认为false\n	post_asset_folder: false #启动 Asset 文件夹\n	relative_link: false	 #把链接改为与根目录的相对位址，默认false\n	future: true			 #显示未来的文章，默认false\n	highlight:				 #代码块的设置\n	  enable: true\n	  line_number: true\n	  auto_detect: false\n	  tab_replace:\n	  \n	# Category & Tag 分类和标签的设置\n	default_category: uncategorized		#默认分类\n	category_map:						#分类别名\n	tag_map:							#标签别名\n	\n	# Date / Time format\n	## Hexo uses Moment.js to parse and display date\n	## You can customize the date format as defined in\n	## http://momentjs.com/docs/#/displaying/format/\n	date_format: YYYY-MM-DD\n	time_format: HH:mm:ss\n	  \n	# Home page setting\n	# path: Root path for your blogs index page. (default = \'\')\n	# per_page: Posts displayed per page. (0 = disable pagination)\n	# order_by: Posts order. (Order by date descending by default)\n	index_generator:\n	  path: \'\'\n	  per_page: 10      \n	  order_by: -date\n	  \n	# Pagination\n	## Set per_page to 0 to disable pagination\n	per_page: 10            #每页显示的文章量 (0 = 关闭分页功能)\n	pagination_dir: page    #分页目录\n	\n	# Extensions\n	## Plugins: https://hexo.io/plugins/\n	## Themes: https://hexo.io/themes/\n	theme: landscape        #主题（皮肤）\n	\n	# Deployment\n	## Docs: https://hexo.io/docs/deployment.html\n	deploy:\n	  type: git\n	  repo: \n	        #github: git@github.com:yibierusi/zhou.github.io.git,master\n	        coding: git@git.coding.net:zhouhy1205/blog.git,master\n \n                    \n                                   ', '1536302118626.md', '1', '11', '0', '2018-09-07 14:35:19', '2018-09-07 14:39:18', '0', '0');
INSERT INTO `blog` VALUES ('812008af2c8245bcbcbf1a8e5fa774ef', 'markdownpad2 下载与破解', '# markdownpad2 下载与破解\n## 前言 ##\nMarkdown是一种可以使用普通文本编辑器编写的标记语言，通过简单的标记语法，它可以使普通文本内容具有一定的格式。Markdown的语法简洁明了、学习容易，而且功能比纯文本更强，因此有很多人用它写博客。Markdownpad2也是我一直在用并且强烈推荐的一款markdown编辑器。\n\n## 正文 ##\n### 第一步 下载解压 ###\n首先先下载markdownpad2 这里是免安装版的。\n\n下载地址：https://pan.baidu.com/s/1A6lSazni7Q0vCuNfQbpe9w \n\n密码：ttqo\n\n### 第二步 生成激活码 ###\n\n下载完解压之后可以看到一个exe文件和一个文件夹，进入文件夹找到KG.exe 执行然后点击Generate生成激活码\n\n![](https://i.imgur.com/ivhtaMt.png)\n\n### 第三步 激活markdownpad2 ###\n\n然后打开MarkdownPad2.exe 会提示激活，选择输入激活码激活。然后说上一步生成的邮件和激活码，点击激活就OK了。\n![](https://i.imgur.com/Dropvjg.png)\n\n如果已经可以正常使用了就不用往以下看了。\n\n\n\nmarkdownpad2在win10和win8上， markdown还会发生如下图所见的这个问题。\n\n![](https://i.imgur.com/7EeO9et.png)\n\n遇到这个问题可以安装第二步解压出来的那个exe文件\n\n![](https://i.imgur.com/anDo9w2.png)\n\n', '1536302464047.md', '1', '23', '0', '2018-09-07 14:41:04', '2018-09-27 14:41:46', '0', '0');
