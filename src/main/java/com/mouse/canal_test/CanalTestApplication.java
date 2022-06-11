package com.mouse.canal_test;

import com.mouse.canal_test.rocketmq.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MessageSource.class})
@SpringBootApplication(scanBasePackages = "com.mouse")
public class CanalTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalTestApplication.class, args);
    }

}
