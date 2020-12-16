package edu.gdut.togethertime.model.query;

public class BaseQuery implements BaseQueryCheck {
    private Long id;
    private Long userId;
    private String unionId;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", userId=" + userId +
                ", unionId='" + unionId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
