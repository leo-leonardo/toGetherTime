package edu.gdut.togethertime.mapper;

import edu.gdut.togethertime.model.entity.UserInfo;

public interface UserInfoMapper {
    UserInfo selectUserInfoById(Long id);
    Integer insertUserInfo(Long id);
}
