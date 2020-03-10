package com.yunduo.service.serviceImp;
import com.yunduo.bean.FindMasterShareRsq;
import com.yunduo.bean.ReportShareReq;
import com.yunduo.dao.ShareMapper;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Share;
import com.yunduo.entities.Users;
import com.yunduo.service.ShareService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShareServiceImp implements ShareService {
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    UsersMapper usersMapper;

    @Override
    public Integer delShareInfo(Integer id) {
        return  shareMapper.deleteByPrimaryKey(id);

    }

    /**
     * 发表说说
     * @param model
     * @return
     */
    @Override
    public Integer reportShare(ReportShareReq model) {
        Share share=new Share();
        //设头像
        Users user=usersMapper.selectByPrimaryKey(model.getMaster_id());
        share.setMaster_img(user.getAvatar());
        //设照片
        if(!(model.getPicture1()==null))
        share.setPicture1(setPhoto(model.getPicture1()));
        if(!(model.getPicture2()==null))
        share.setPicture2(setPhoto(model.getPicture2()));
        if(!(model.getPicture3()==null))
        share.setPicture3(setPhoto(model.getPicture3()));
        if(!(model.getPicture4()==null))
        share.setPicture4(setPhoto(model.getPicture4()));
        if(!(model.getPicture5()==null))
        share.setPicture5(setPhoto(model.getPicture5()));
        if(!(model.getPicture6()==null))
        share.setPicture6(setPhoto(model.getPicture6()));
        if(!(model.getPicture7()==null))
        share.setPicture7(setPhoto(model.getPicture7()));
        if(!(model.getPicture8()==null))
        share.setPicture8(setPhoto(model.getPicture8()));
        if(!(model.getPicture9()==null))
        share.setPicture9(setPhoto(model.getPicture9()));
        share.setWords(model.getWords());
//        设账号
        share.setMaster_id(model.getMaster_id());
        //设名字
        share.setMaster_name(user.getName());
        //设置发表日期
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date=new Date();
        String share_time=simpleDateFormat.format(date);
        share.setShare_time(share_time);
        shareMapper.insertSelective(share);
//        System.out.println("发表说说的功能完成，开始返回展示的数据");
//
//        ShareInfoRsp shareInfoRsp=new ShareInfoRsp();
//        Users user=usersMapper.selectByPrimaryKey(model.getMaster_id());
//        Share share1=shareMapper.selectByMasteridAndTime(share.getMaster_id(),share.getShare_time());
//        shareInfoRsp.setId(share1.getId());
//        shareInfoRsp.setShare_time(share1.getShare_time());
//        shareInfoRsp.setPicture1(share1.getPicture1());
//        shareInfoRsp.setPicture2(share1.getPicture2());
//        shareInfoRsp.setPicture3(share1.getPicture3());
//        shareInfoRsp.setPicture4(share1.getPicture4());
//        shareInfoRsp.setPicture5(share1.getPicture5());
//        shareInfoRsp.setPicture6(share1.getPicture6());
//        shareInfoRsp.setPicture7(share1.getPicture7());
//        shareInfoRsp.setPicture8(share1.getPicture8());
//        shareInfoRsp.setPicture9(share1.getPicture9());
//        shareInfoRsp.setWords(share1.getWords());
//        shareInfoRsp.setSaw_time(share1.getSaw_time());
//        //用户信息
//        shareInfoRsp.setAccount(share1.getMaster_id());
//        shareInfoRsp.setAvatar(user.getAvatar());
//        shareInfoRsp.setName(user.getName());
//        return shareInfoRsp;
        return 1;
        //响应1 为成功
    }

    /**
     * 好友个人空间下的点击  “说说”
     * @param master_id
     * @return
     */
    @Override
    public List<FindMasterShareRsq> findMasterShare(Integer master_id) {
        List<Share> share =shareMapper.findMasterShare(master_id);
        List<FindMasterShareRsq> list= CloneUtil.cloneList(share,FindMasterShareRsq.class);
        return list;
    }

    @Override
    public List<Share> findFriendShare(Integer master_id) {
    return   shareMapper.findFriendShare(master_id);

    }

    /**
     * 将照片转换为路径返回函数
     * @param file
     * @return
     */
    public String setPhoto(MultipartFile file){
        if(file.isEmpty()){
            return null;
        }
        String str=file.getOriginalFilename();
        String strlast=str.substring(str.lastIndexOf("."));
        String strname= UUID.randomUUID()+strlast;
        String filepath="D:/temp-rainy/";
        File dest =new File(filepath+strname);
        try{
            file.transferTo(dest);
        } catch (IOException e) {
            System.out.println("传输过程异常");
            e.printStackTrace();
        }
        return "http://127.0.0.1:8090/temp-rainy/"+strname;
    }
}
