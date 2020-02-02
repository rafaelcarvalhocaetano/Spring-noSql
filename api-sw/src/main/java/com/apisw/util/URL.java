package com.apisw.util;

import java.net.URLDecoder;

public class URL {

  public static String decodeParam(String text) {
    try {
      return URLDecoder.decode(text, "UTF-8");  
    } catch (Exception e) {
      return "";
    }
  }
  
}