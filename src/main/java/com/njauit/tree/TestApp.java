package com.njauit.tree;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/4/1618:03
 */
public class TestApp {

  public static void main(String[] args) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String format = dateFormat.format(date);
    System.out.println(format);
  }
}
