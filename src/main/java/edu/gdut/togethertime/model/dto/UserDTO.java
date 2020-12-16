package edu.gdut.togethertime.model.dto;

import edu.gdut.togethertime.model.entity.User;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;
    private String username;
    private String unionId;
    private String openId;
    private LocalDateTime createTime;

    public static UserDTO castToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setUnionId(user.getUnionId());
        userDTO.setOpenId(user.getOpenId());
        userDTO.setCreateTime(user.getCreateTime());
        return userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", unionId='" + unionId + '\'' +
                ", openId='" + openId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
