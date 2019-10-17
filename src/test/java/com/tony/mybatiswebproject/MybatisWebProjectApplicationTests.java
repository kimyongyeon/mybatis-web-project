package com.tony.mybatiswebproject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MybatisWebProjectApplicationTests {

   @Autowired
   UserMapper mapper;

   @Test
   void contextLoads() {

      User user = new User();
      user.setIdx(1L);
      mapper.insert(1L, "tony", "spark");
      List list = mapper.findByIdx(1L);
      log.info("list: " + list.toString());
   }

}
