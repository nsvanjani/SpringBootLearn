package com.practice.boot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HIbernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		System.out.println("************SessionFactory");
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(createDataSource());
		sessionFactoryBean.setPackagesToScan(new String[] {});
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setPackagesToScan("com.practice.boot.entity");
		return sessionFactoryBean;
	}

	private Properties hibernateProperties() {
		Properties props = new Properties();

		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.cache.use_query_cache", "false");
		props.setProperty("hibernate.generate_statistics", "false");
		props.setProperty("hibernate.cache.use_second_level_cache", "false");
		props.setProperty("hibernate.jdbc.fetch_size", "100");
		props.setProperty("hibernate.jdbc.batch_size", "500");
		props.setProperty("hibernate.order_updates", "true");
		props.setProperty("hibernate.order_inserts", "true");
		props.setProperty("hibernate.default_batch_fetch_size", "20");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "none");

		return props;

	}

	@Bean
	public DataSource createDataSource() {
		System.out.println("************Data Source");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_hibernate_dev?createDatabaseIfNotExist=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}
