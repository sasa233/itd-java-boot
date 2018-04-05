package cn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration  // 开启注解扫描(此注解会放在项目的启动类)
@ComponentScan(basePackages={"cn.yd.shop"})  // 配置需要扫描的包路径
@PropertySource(value={"classpath:jdbc.properties","classpath:mvc.properties"})
public class AppRun {
	public static void main(String[] args) {
		SpringApplication.run(AppRun.class,	args);
	}
}
