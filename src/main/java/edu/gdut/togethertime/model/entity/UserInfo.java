package edu.gdut.togethertime.model.entity;

import java.time.LocalDateTime;

public class UserInfo {
    private Long id;
    private String level;
    private Integer completeTimes;
    private Float attentTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getCompleteTimes() {
        return completeTimes;
    }

    public void setCompleteTimes(Integer completeTimes) {
        this.completeTimes = completeTimes;
    }

    public Float getAttentTime() {
        return attentTime;
    }

    public void setAttentTime(Float attentTime) {
        this.attentTime = attentTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String  toString() {
        return "UserInfo{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", completeTimes=" + completeTimes +
                ", attentTime=" + attentTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
