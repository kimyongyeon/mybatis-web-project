package com.tony.mybatiswebproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MybatisWebProjectApplication {

   @Autowired
   UserMapper userMapper;

   @GetMapping("list")
   public List list() {
      return userMapper.findByIdx(1L);
   }

   public static void main(String[] args) {
      SpringApplication.run(MybatisWebProjectApplication.class, args);
   }

}
