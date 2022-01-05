package com.project.onlinemarketplaceservice.config;

import com.project.onlinemarketplaceservice.resolver.LoginUserInfoArgumentResolver;
import com.project.onlinemarketplaceservice.interceptor.LoginInterceptor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{

  private final LoginInterceptor loginInterceptor;
  private final LoginUserInfoArgumentResolver loginUserInfoArgumentResolver;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginInterceptor);
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(loginUserInfoArgumentResolver);
  }
}
