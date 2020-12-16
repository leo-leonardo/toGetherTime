package edu.gdut.togethertime.model.query;

public interface BaseQueryCheck {
    String getUnionId();
    Long getUserId();
    String getUsername();
    void setUserId(Long userId);
    void setUnionId(String unionId);
    void setUsername(String username);
}
