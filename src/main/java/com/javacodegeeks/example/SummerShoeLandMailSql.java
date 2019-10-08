package com.javacodegeeks.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

@SpringBootApplication
public class SummerShoeLandMailSql implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SummerShoeLandMailSql.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		readRecords();
	}
	
	private void readRecords() {
		System.out.println("Reading cars records...");
		System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
		jdbcTemplate.query("SELECT * FROM cars", new RowCallbackHandler() {

			public void processRow(ResultSet rs) throws SQLException {
				System.out.printf("%-30.30s  %-30.30s%n", rs.getString("model"), rs.getString("price"));
			}
			
		});
	}

}
