package org.iclass.spring_1demo;

import org.iclass.spring_1demo.old.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Spring1demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring1demoApplication.class, args);
		log.info("순수한 자바 형식의 DemoController 객체 성성");
		DemoController controller = new DemoController();
		log.info("Application main - controller : {} ", controller.getClass().toString());

		// DemoService service = new DemoService();
		// log.info("Application main - service : {} ", service.getClass().toString());
	}

}
