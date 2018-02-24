package springmvc.java.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;


@EnableTransactionManagement
@Configuration
public class ApplicationContext<DatabasePopulator> {
	
	@Autowired
	private Environment environment;
	

	
	@Bean
	public DataSource dataSource() throws SQLException {
		System.out.println("database");
		OracleDataSource builder = new OracleDataSource();
		 builder.setURL(environment.getProperty("jdbc.url"));
		 builder.setUser(environment.getProperty("jdbc.username")); 
		 builder.setPassword(environment.getProperty("jdbc.password"));
		 
		
		return builder;
	}
	
	
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		
		
		
		return jpaTransactionManager;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter jpaVendorAdapter= new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.ORACLE);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("springmvc.java.domain"); //hera are models of user and log_post
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		entityManagerFactory.setJpaProperties(jpaProperties);
		return entityManagerFactory;
	}
	
	
	
}
