package com.laptrinhjavaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// từ version 1 + apply spring data jpa vào mô hình spring boot api
// kết quả: sử dụng version này để làm tiền đề số 2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
