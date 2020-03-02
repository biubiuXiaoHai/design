//package com.yunduo.controller;
//
//import com.yunduo.bean.*;
//import com.yunduo.service.HomeService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("home")
//@Api(description = "个人首页接口")
//public class HomeController {
//    @Autowired
//    HomeService homeService;
//
//    @PostMapping("updUserHead")
////    public updUserHeadRsq updUserHead(HttpServletRequest request, @Param("account") int account){
////        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
////         updUserHeadReq model=new updUserHeadReq();
////           try {
////            byte[] data;
////            data = file.getBytes();
////            model.setAccount(account);
////            model.setPhoto(data);
////            return  homeService.updphone(model);
////           }catch (Exception e) {
////               e.printStackTrace();
////           }
////        return null;
////
////    }
//    public updUserHeadRsp updUserHead(MultipartFile filePart) throws IOException {
//            /**
//             * 可以加注解的形式给简化
//            * */
//        if(filePart.isEmpty()){
//            System.out.println("输入的文件有误！！");
//        }else{
//            updUserHeadReq model=new updUserHeadReq();
//            model.setAccount(10);
//            model.setPhoto(filePart.getBytes());
//            System.out.println("文件上传成功！");
//            return homeService.updphone(model);
//        }
//        System.out.println("上传失败！");
//        return null;
//    }
//
//    @PostMapping("findUserInfo")
//    @ApiOperation("获取用户个人资料")
//    public FindUserRsp findUserInfo (FindUserReq model){
//
//        return null;
//    }
//
//    @PostMapping("findOverView")
//    @ApiOperation("获取左侧的总览信息")
//    public findOverViewRsp findOverView(findOverViewReq model){
//        return null;
//    }
//}
