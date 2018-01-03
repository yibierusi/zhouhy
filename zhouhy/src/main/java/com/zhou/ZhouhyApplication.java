package com.zhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZhouhyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhouhyApplication.class, args);
	}

//	@Autowired
//	private Environment env;
//	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
//	@Bean(destroyMethod =  "close")
//	public DataSource dataSource() {
//		String str = "spring.datasource.";
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl(env.getProperty(str+"url"));
//		dataSource.setUsername(env.getProperty(str+"username"));//用户名
//		dataSource.setPassword(env.getProperty(str+"password"));//密码
//		dataSource.setDriverClassName(env.getProperty(str+"driver-class-name"));
//		dataSource.setInitialSize(Integer.parseInt(env.getProperty(str+"initialSize")));//初始化时建立物理连接的个数
//		dataSource.setMaxActive(Integer.parseInt(env.getProperty(str+"maxActive")));//最大连接池数量
//		dataSource.setMinIdle(Integer.parseInt(env.getProperty(str+"minIdle")));//最小连接池数量
//		dataSource.setMaxWait(Integer.parseInt(env.getProperty(str+"maxWait")));//获取连接时最大等待时间，单位毫秒。
//		dataSource.setValidationQuery(env.getProperty(str+"validationQuery"));//用来检测连接是否有效的sql
//		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
//		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
//		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
//		return dataSource;
//	}

}
