package org.example.spring_jdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "org.example.spring_jdbc")
public class SpringConfig {

	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setPassword("root");
		dataSource.setMaxPoolSize(20);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxIdleTime(30000);
		return dataSource;
	}

}
