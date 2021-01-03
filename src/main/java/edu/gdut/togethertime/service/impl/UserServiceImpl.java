package edu.gdut.togethertime.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.gdut.togethertime.constant.WxConstant;
import edu.gdut.togethertime.exception.ExceptionEnum;
import edu.gdut.togethertime.mapper.UserInfoMapper;
import edu.gdut.togethertime.mapper.UserMapper;
import edu.gdut.togethertime.model.entity.User;
import edu.gdut.togethertime.model.entity.UserInfo;
import edu.gdut.togethertime.model.query.WxProgramLoginQuery;
import edu.gdut.togethertime.service.UserService;
import edu.gdut.togethertime.utils.HttpUtils;
import edu.gdut.togethertime.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User login(WxProgramLoginQuery query) {
        //登录逻辑
        //1.取得wx.login带有的参数iv,encrypted,code
        String encryptedData = query.getEncryptedData();
        String iv = query.getIv();
        String code = query.getCode();

        //2.作为参数请求给wx登录接口
        String url = String.format(WxConstant.LOGIN_URL, WxConstant.APPID, WxConstant.APP_SECRET, code);
//        System.out.println(url);
        String response = HttpUtils.get(url);
        System.out.println(response);
        JSONObject session = (JSONObject) JSONObject.parse(response);

        //因为小程序没有上线，所以此处不做微信官方登录。虽然经测试可以使用，但只有测试人员对应APPID才能使用

//        //3.设置登录态
//        String openid = session.getString("openid");
//        //没有多平台，不用unionId
////        String unionid = session.getString("unionid");
//
//        if (openid == null) {
//            throw ExceptionEnum.exception(ExceptionEnum.PARAM_ERROR);
//        }
//        User user = null;
////        if (unionid != null) user = userMapper.selectUserByUnionId(unionid);
////        if (user == null) {
//            //unionid找不到，用openid找
//            user = userMapper.selectUserByOpenId(openid);
//            if (user == null) {
//                //openid也找不到，注册
//                User newUser = new User();
//                newUser.setUsername(query.getUsername());
////                newUser.setUnionId(unionid);
//                newUser.setOpenId(openid);
//                newUser.setImgUrl(query.getImgUrl());
//                newUser.setLastLoginTime(LocalDateTime.now());
//                userMapper.registUser(newUser);
//                newUser = userMapper.selectUserByOpenId(openid);
//                userInfoMapper.insertUserInfo(newUser.getId());
//                return newUser;
//            } else {
//                //openid找到了
//                user.setLastLoginTime(LocalDateTime.now());
//                user.setUsername(query.getUsername());
//                user.setImgUrl(query.getImgUrl());
//                userMapper.update(user);
//            }
////        } else {
////            //unionid找到了
////            user.setLastLoginTime(LocalDateTime.now());
////            user.setUsername(query.getUsername());
////            user.setImgUrl(query.getImgUrl());
////            userMapper.update(user);
////        }

        User user = new User();
        user.setId(RandomUtils.randomId());
        user.setImgUrl(query.getImgUrl());
        user.setUsername(query.getUsername());
        user.setLastLoginTime(LocalDateTime.now());
        userMapper.registUser(user);
        return user;
    }

    @Override
    public Boolean checkUserIfExists(Long userId) {
        return userMapper.selectUserById(userId) != null;
    }
}
