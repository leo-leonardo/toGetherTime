package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

public class BaseQuery implements BaseQueryCheck {
    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Long userId;
    @ApiModelProperty(value = "用户unionId", example = "不用带上")
    private String unionId;
    @ApiModelProperty(value = "用户名，注册和登录时带上", example = "Leo")
    private String username;

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getUnionId() {
        return unionId;
    }

    @Override
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "userId=" + userId +
                ", unionId='" + unionId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
