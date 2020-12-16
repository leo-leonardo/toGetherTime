package edu.gdut.togethertime.service;

import edu.gdut.togethertime.model.entity.User;
import edu.gdut.togethertime.model.query.WxProgramLoginQuery;

public interface LoginService {
    //1.登录业务,返回用户信息
    User login(WxProgramLoginQuery query);

}
