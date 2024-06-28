package com.example.ludwig.libraryP;

import com.example.ludwig.libraryP.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import java.util.Optional;
import java.util.TimeZone;

@SpringBootApplication
//@EnableJdbcAuditing
public class LibraryPApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryPApplication.class, args);
	}
//	@PostConstruct
//	public void init() {
//		// Setting Spring Boot SetTimeZone
//		System.out.println("Post Construct application called!");
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
//	}

}
