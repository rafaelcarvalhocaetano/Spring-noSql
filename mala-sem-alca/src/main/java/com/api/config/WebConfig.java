package com.api.config;

import java.util.List;

import com.api.converter.yaml.YamlHttpMessageConverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {

  private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    // WebMvcConfigurer.super.extendMessageConverters(converters);
    converters.add(new YamlHttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
      .favorPathExtension(false)
      // .favorParameter(true)
      .favorParameter(false)
      // .parameterName("mediaType")
      // .ignoreAcceptHeader(true)
      .ignoreAcceptHeader(false)
      .useRegisteredExtensionsOnly(false)
      .defaultContentType(MediaType.APPLICATION_JSON)
      .mediaType("json", MediaType.APPLICATION_JSON)
      .mediaType("xml", MediaType.APPLICATION_XML)
      .mediaType("x-yaml", MEDIA_TYPE_YML);
  }

  
}