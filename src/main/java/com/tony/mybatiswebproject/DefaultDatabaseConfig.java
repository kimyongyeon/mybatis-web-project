package com.tony.mybatiswebproject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value={"com.**.mapper"})
class DefaultDatabaseConfig {

   @Autowired
   private ApplicationContext applicationContext;

   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource);
      sqlSessionFactoryBean.setTypeAliasesPackage("com.tony.mybatiswebproject");
      sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/config/mybatis-config.xml"));
      sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/*Mapper.xml"));
      sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
      return sqlSessionFactoryBean.getObject();
   }
}
