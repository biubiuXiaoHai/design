package com.yunduo.service.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class t {
    public static void main(String[] args) {
    Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年mm月dd日 hh时MM分ss秒");
        String time=simpleDateFormat.format(date);
        System.out.println(time);
    }
}
