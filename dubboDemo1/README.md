# Dubbo是什么 #

Dubbo是：

- 一款分布式服务框架
- 高性能和透明化的RPC远程服务调用方案
- SOA服务治理方案

每天为2千多个服务提供大于30亿次访问量支持，并被广泛应用于阿里巴巴集团的各成员站点以及别的公司的业务中。

# Dubbo架构 #
![](https://i.imgur.com/mI9QQvw.png)


**Provider**: 暴露服务的服务提供方。 
**Consumer**: 调用远程服务的服务消费方。 
**Registry**: 服务注册与发现的注册中心。 
**Monitor**: 统计服务的调用次数和调用时间的监控中心。

# 调用流程  #
1. 服务容器负责启动，加载，运行服务提供者。 
1. 服务提供者在启动时，向注册中心注册自己提供的服务。 
1. 服务消费者在启动时，向注册中心订阅自己所需的服务。 
1. 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。 
1. 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。 
1. 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心

# Dubbo注册中心 #

对于服务提供方，它需要发布服务，而且由于应用系统的复杂性，服务的数量、类型也不断膨胀； 
对于服务消费方，它最关心如何获取到它所需要的服务，而面对复杂的应用系统，需要管理大量的服务调用。 
而且，对于服务提供方和服务消费方来说，他们还有可能兼具这两种角色，即既需要提供服务，有需要消费服务。

通过将服务统一管理起来，可以有效地优化内部应用对服务发布/使用的流程和管理。服务注册中心可以通过特定协议来完成服务对外的统一。

**Dubbo提供的注册中心有如下几种类型可供选择：**

- Multicast注册中心
- Zookeeper注册中心
- Redis注册中心
- Simple注册中心

# Dubbo优缺点 #


**优点**：

1. 透明化的远程方法调用 
	<br>。像调用本地方法一样调用远程方法；只需简单配置，没有任何API侵入。
1. 软负载均衡及容错机制 
	<br>。可在内网替代nginx lvs等硬件负载均衡器。
1. 服务注册中心自动注册 & 配置管理 
	<br>。不需要写死服务提供者地址，注册中心基于接口名自动查询提供者ip。 
	<br>使用类似zookeeper等分布式协调服务作为服务注册中心，可以将绝大部分项目配置移入zookeeper集群。
1. 服务接口监控与治理 
	<br>。Dubbo-admin与Dubbo-monitor提供了完善的服务接口管理与监控功能，针对不同应用的不同接口，可以进行 多版本，多协议，多注册中心管理。

**缺点**：

只支持JAVA语言


# Dubbo入门Demo #

了解了Dubbo以后，自然要搭建一个简单的Demo实现。本文采用Dubbo与Zookeeper、Spring框架的整合。

主要是以下几个步骤： <br>
1. 安装Zookeeper,启动。<br>
2. 创建MAVEN项目，构建Dubbo+Zookeeper+Spring实现的简单Demo 。<br>
3. 安装Dubbo-admin，实现监控。<br>

## 1 Zookeeper介绍与安装 ##

本Demo中的Dubbo注册中心采用的是Zookeeper。为什么采用Zookeeper呢？

Zookeeper是一个分布式的服务框架，是树型的目录服务的数据存储，能做到集群管理数据 ，这里能很好的作为Dubbo服务的注册中心。

Dubbo能与Zookeeper做到集群部署，当提供者出现断电等异常停机时，Zookeeper注册中心能自动删除提供者信息，当提供者重启时，能自动恢复注册数据，以及订阅请求
具体的安装方法在此不一一叙述，可参考博文： 
[http://blog.csdn.net/tlk20071/article/details/52028945](http://blog.csdn.net/tlk20071/article/details/52028945)


安装完成后，进入到bin目录，并且启动zkServer.cmd，这个脚本中会启动一个java进程： 
(注：需要先启动zookeeper后，后续dubbo demo代码运行才能使用zookeeper注册中心的功能) <br>
![](http://img.blog.csdn.net/20170417185700274?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 2 创建MAVEN项目 ##

项目结构： <br>
主要分三大模块： <br>
**dubbo-api** : 存放公共接口； <br>
**dubbo-consumer** :　调用远程服务； <br>
**dubbo-provider** : 提供远程服务。 <br>
![](http://img.blog.csdn.net/20170417185828900?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

下面将详细叙述代码构建过程。 <br>
1) 首先构建MAVEN项目，导入所需要的jar包依赖。 <br>
需要导入的有spring, dubbo, zookeeper等jar包。 <br>
(详情参看项目代码)<br>

2)创建dubbo-api的MAVEN项目(有独立的pom.xml，用来打包供提供者消费者使用)。 <br>
在项目中定义服务接口：该接口需单独打包，在服务提供方和消费方共享。 <br>
![](http://img.blog.csdn.net/20170417190010620?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

 
    public interface DemoService {
    	List<String> getPermissions(Long id);
    }


3)创建dubbo-provider的MAVEN项目(有独立的pom.xml，用来打包供消费者使用)。 
实现公共接口，此实现对消费者隐藏：




		public class DemoServiceImpl implements DemoService {
		    public List<String> getPermissions(Long id) {
		        List<String> demo = new ArrayList<String>();
		        demo.add(String.format("Permission_%d", id - 1));
		        demo.add(String.format("Permission_%d", id));
		        demo.add(String.format("Permission_%d", id + 1));
		        return demo;
		    }
		}

需加入公共接口所在的依赖 

![](http://img.blog.csdn.net/20170417190208168?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


用Spring配置声明暴露服务

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		   xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
		   xsi:schemaLocation="http://www.springframework.org/schema/beans
		   http://www.springframework.org/schema/beans/spring-beans.xsd
		   http://code.alibabatech.com/schema/dubbo
		   http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
		<!--定义了提供方应用信息，用于计算依赖关系；在 dubbo-admin 或 dubbo-monitor 会显示这个名字，方便辨识-->
		<dubbo:application name="demotest-provider" owner="programmer" organization="dubbox"/>
		<!--使用 zookeeper 注册中心暴露服务，注意要先开启 zookeeper-->
		<dubbo:registry address="zookeeper://localhost:2181"/>
		<!-- 用dubbo协议在20880端口暴露服务 -->
		<dubbo:protocol name="dubbo" port="20880" />
		<!--使用 dubbo 协议实现定义好的 api.PermissionService 接口-->
		<dubbo:service interface="com.alibaba.dubbo.demo.DemoService" ref="demoService" protocol="dubbo" />
		<!--具体实现该接口的 bean-->
		<bean id="demoService" class="com.alibaba.dubbo.demo.impl.DemoServiceImpl"/>
		</beans>


启动远程服务：

		import org.springframework.context.support.ClassPathXmlApplicationContext;
		import java.io.IOException;
		public class Provider {
	        	public static void main(String[] args) throws IOException {
		            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		            System.out.println(context.getDisplayName() + ": here");
		            context.start();
		            System.out.println("服务已经启动...");
		            System.in.read();
		        }
		    }

4)创建dubbo-consumer的MAVEN项目(可以有多个consumer，但是需要配置好)。 
调用所需要的远程服务：

通过Spring配置引用远程服务：

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
		       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		       http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
		    <dubbo:application name="demotest-consumer" owner="programmer" organization="dubbox"/>
		    <!--向 zookeeper 订阅 provider 的地址，由 zookeeper 定时推送-->
		    <dubbo:registry address="zookeeper://localhost:2181"/>
		    <!--使用 dubbo 协议调用定义好的 api.PermissionService 接口-->
		    <dubbo:reference id="permissionService" interface="com.alibaba.dubbo.demo.DemoService"/>
		</beans>

启动Consumer,调用远程服务：

		import com.alibaba.dubbo.demo.DemoService;
		import org.springframework.context.support.ClassPathXmlApplicationContext;
		public class Consumer {
		    public static void main(String[] args) {
		        //测试常规服务
		        ClassPathXmlApplicationContext context =
		                new ClassPathXmlApplicationContext("consumer.xml");
		        context.start();
		        System.out.println("consumer start");
		        DemoService demoService = context.getBean(DemoService.class);
		        System.out.println("consumer");
		        System.out.println(demoService.getPermissions(1L));
		    }
		}

5）运行项目，先确保provider已被运行后再启动consumer模块： 

运行提供者： 

![](http://img.blog.csdn.net/20170417190351294?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

消费者成功调用提供者所提供的远程服务：

![](http://img.blog.csdn.net/20170417190436419?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

当然，这只是一个模拟的项目，实际中有多提供者多消费者情况，比这要复杂的多，当然只有这样才能体现dubbo的特性。

# Dubbo管理控制台介绍 #

管理控制台功能

- 路由规则，
- 动态配置，
- 服务降级 
- 访问控制，
- 权重调整 
- 负载均衡 
- 
![](http://img.blog.csdn.net/20170417190514200?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


下载dubbo-admin，可自行根据网上介绍安装。大致做法就是将dubbo-admin中 的某个文件夹内容替换到tomcat的conf中，再运行tomcat即可。但我在实际操作中发现JDK8无法运行，后来找到一个JDK8可以实现的dubbo-admin版本，文件在项目中。

成功开启输入用户名密码root后，即可进入控制台首页查看消费者提供者情况： 
查看提供者：

![](http://img.blog.csdn.net/20170417190614311?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

查看消费者：

![](http://img.blog.csdn.net/20170417190635248?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbm9hbWFuX3dncw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


很遗憾，官方Dubbo网址早已不维护了，也出现了很多更新的Dubbo，比如当当网的Dubbox，可以自行了解。
