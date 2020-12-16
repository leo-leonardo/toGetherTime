package edu.gdut.togethertime.mapper;

import edu.gdut.togethertime.model.dto.UserDTO;
import edu.gdut.togethertime.model.entity.User;

public interface UserMapper {
    User selectLoginUser(String column, String value);

    User selectUserById(Long id);
    User selectUserByUnionId(String unionId);
    User selectUserByOpenId(String openId);

    Integer deleteUserByUnionId(String unionId);

    Integer registUser(User user);
    Integer update(User user);
}
