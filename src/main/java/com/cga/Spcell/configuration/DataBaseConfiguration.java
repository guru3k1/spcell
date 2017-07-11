package com.cga.Spcell.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
		
		@Bean
		public LocalSessionFactoryBean sessionFactory(){
			LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource());
			sessionFactoryBean.setPackagesToScan("com.cga.Spcell.model");
			sessionFactoryBean.setHibernateProperties(hibernateProperties());
			return sessionFactoryBean;
		}
		@Bean
		public DataSource dataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/spcell");
			dataSource.setUsername("spcell");
			dataSource.setPassword("spcell");
			
			return dataSource;
		}
		
		public Properties hibernateProperties(){
			Properties properties = new Properties();
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			properties.put("showsql", "true");
			return properties;
		}
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(){
				HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
				hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());	
			return hibernateTransactionManager;
		}
		

		/*@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	        	@Override
		        public void addCorsMappings(CorsRegistry registry) {
	        	registry.addMapping("http://localhost:8080/**");
		            }
		        };
		}*/
		
}
