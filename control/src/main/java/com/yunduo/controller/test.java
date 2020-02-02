package com.yunduo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class test {
    @PostMapping("test_one")
    public String test_one(int model){
        return "it was ok ";
    }
    @GetMapping("test")
    public String test(MultipartFile file ){
        if(file.isEmpty())
        {
            System.out.println("文件为空~");
        }
        File file1=new File("D://en");
        if(!file1.exists()){
            System.out.println("文件不存在");
//            file1.createNewFile();
        }else{
            System.out.println("文件存在~");
        }
        return "测试成功";

    }
}
