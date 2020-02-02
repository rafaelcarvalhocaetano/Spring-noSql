package com.apisw.util;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

  public static String decodeParam(String text) {
    try {
      return URLDecoder.decode(text, "UTF-8");  
    } catch (Exception e) {
      return "";
    }
  }

  public static Date convertDate(String textDate, Date defaultValue) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    try {
      return dateFormat.parse(textDate);
    } catch (Exception e) {
      return defaultValue;
    }
  }
  
}