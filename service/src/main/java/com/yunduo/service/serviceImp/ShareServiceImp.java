package com.yunduo.service.serviceImp;

import com.yunduo.bean.FindAllFriendShareRsp;
import com.yunduo.bean.ReportShareReq;
import com.yunduo.bean.ShareInfoRsp;
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
import java.util.logging.SimpleFormatter;

@Service
public class ShareServiceImp implements ShareService {
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    UsersMapper usersMapper;
    /**
     * 发表说说
     * @param model
     * @return
     */
    @Override
    public ShareInfoRsp reportShare(ReportShareReq model) {
        Share share=new Share();
        share.setPicture1(setPhoto(model.getPicture1()));
        share.setPicture2(setPhoto(model.getPicture2()));
        share.setPicture3(setPhoto(model.getPicture3()));
        share.setPicture4(setPhoto(model.getPicture4()));
        share.setPicture5(setPhoto(model.getPicture5()));
        share.setPicture6(setPhoto(model.getPicture6()));
        share.setPicture7(setPhoto(model.getPicture7()));
        share.setPicture8(setPhoto(model.getPicture8()));
        share.setPicture9(setPhoto(model.getPicture9()));
        share.setWords(model.getWords());
        share.setMaster_id(model.getMaster_id());
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String share_time=simpleDateFormat.format(date);
        share.setShare_time(share_time);
        shareMapper.insertSelective(share);
        System.out.println("发表说说的功能完成，开始返回展示的数据");

        ShareInfoRsp shareInfoRsp=new ShareInfoRsp();
        Users user=usersMapper.selectByPrimaryKey(model.getMaster_id());
        Share share1=shareMapper.selectByMasteridAndTime(share.getMaster_id(),share.getShare_time());
        shareInfoRsp.setId(share1.getId());
        shareInfoRsp.setShare_time(share1.getShare_time());
        shareInfoRsp.setPicture1(share1.getPicture1());
        shareInfoRsp.setPicture2(share1.getPicture2());
        shareInfoRsp.setPicture3(share1.getPicture3());
        shareInfoRsp.setPicture4(share1.getPicture4());
        shareInfoRsp.setPicture5(share1.getPicture5());
        shareInfoRsp.setPicture6(share1.getPicture6());
        shareInfoRsp.setPicture7(share1.getPicture7());
        shareInfoRsp.setPicture8(share1.getPicture8());
        shareInfoRsp.setPicture9(share1.getPicture9());
        shareInfoRsp.setWords(share1.getWords());
        shareInfoRsp.setSaw_time(share1.getSaw_time());
        //用户信息
        shareInfoRsp.setAccount(share1.getMaster_id());
        shareInfoRsp.setAvatar(user.getAvatar());
        shareInfoRsp.setName(user.getName());
        return shareInfoRsp;
    }

    /**
     * 好友个人空间下的点击  “说说”
     * @param master_id
     * @return
     */
    @Override
    public List<FindAllFriendShareRsp> findAllFriendShare(Integer master_id) {
        List<Share> share =shareMapper.findAllFriendShare(master_id);
        List<FindAllFriendShareRsp> list= CloneUtil.cloneList(share,FindAllFriendShareRsp.class);
        return list;
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
