package net.lwenstrom.studentWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * curl --header "content-type: application/soap+xml;charset=utf-8" -d @request.xml http://localhost:6666/ws
 */
@SpringBootApplication
public class StudentWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentWebServiceApplication.class, args);
	}

}
