package edu.gdut.togethertime.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.gdut.togethertime.constant.WxConstant;
import edu.gdut.togethertime.exception.ExceptionEnum;
import edu.gdut.togethertime.mapper.UserMapper;
import edu.gdut.togethertime.model.dto.UserDTO;
import edu.gdut.togethertime.model.entity.User;
import edu.gdut.togethertime.model.query.WxProgramLoginQuery;
import edu.gdut.togethertime.service.LoginService;
import edu.gdut.togethertime.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(WxProgramLoginQuery query) {
        //登录逻辑
        //1.取得wx.login带有的参数iv,encrypted,code
        String encryptedData = query.getEncryptedData();
        String iv = query.getIv();
        String code = query.getCode();

        //2.作为参数请求给wx登录接口
        String url = String.format(WxConstant.LOGIN_URL, WxConstant.APPID, WxConstant.APP_SECRET, code);
        String response = HttpUtils.get(url);
        JSONObject session = (JSONObject) JSONObject.parse(response);

        //3.设置登录态
        String openid = session.getString("openid");
        String unionid = session.getString("unionid");

        assert openid != null && unionid != null;
        User user = userMapper.selectUserByUnionId(unionid);
        if (user == null) {
            //unionid找不到，用openid找
            user = userMapper.selectUserByOpenId(openid);
            if (user == null) {
                //openid也找不到，注册
                User newUser = new User();
                newUser.setUsername(query.getUsername());
                newUser.setUnionId(unionid);
                newUser.setOpenId(openid);
                newUser.setLastLoginTime(LocalDateTime.now());
                userMapper.registUser(newUser);
                newUser = userMapper.selectUserByUnionId(unionid);
                return newUser;
            } else {
                //openid找到了
                user.setLastLoginTime(LocalDateTime.now());
                userMapper.update(user);
            }
        } else {
            //unionid找到了
            user.setLastLoginTime(LocalDateTime.now());
            userMapper.update(user);
        }
        return user;
    }
}
