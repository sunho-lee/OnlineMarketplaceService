package com.project.onlinemarketplaceservice.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.project.onlinemarketplaceservice.mapper")
public class MyBatisConfig {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "proxyDataSource" )
                                             DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.project.onlinemarketplaceservice.dto");
    sqlSessionFactoryBean.setMapperLocations (
        applicationContext.getResources("classpath:/mappers/**/*.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
