package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

public class BaseQuery implements BaseQueryCheck {
    private Long userId;
    private String unionId;
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
