package com.api.converter.yaml;


import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;


public class YamlHttpMessageConverter extends AbstractJackson2HttpMessageConverter {

  public YamlHttpMessageConverter() {
    super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
  }

  
}