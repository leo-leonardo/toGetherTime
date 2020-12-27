package edu.gdut.togethertime.model.entity;

import io.swagger.models.auth.In;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class WeeklyTask {
    private Long id;
    private Long userId;
    private Long taskId;
    private String taskName;
    private Integer level;
    private Integer status;
    private Integer startDay;
    private LocalTime startTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public WeeklyTask(WeeklyTaskBuilder builder) {
        this.userId = builder.userId;
        this.taskId = builder.taskId;
        this.taskName = builder.taskName;
        this.level = builder.level;
        this.status = builder.status;
        this.startDay = builder.startDay;
        this.startTime = builder.startTime;
    }

    public static WeeklyTaskBuilder getBuilder() {
        return new WeeklyTaskBuilder();
    }

    public static class WeeklyTaskBuilder {
        private Long userId;
        private Long taskId;
        private String taskName;
        private Integer level;
        private Integer status;
        private Integer startDay;
        private LocalTime startTime;

        public WeeklyTaskBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public WeeklyTaskBuilder taskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }
        public WeeklyTaskBuilder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }
        public WeeklyTaskBuilder level(Integer level) {
            this.level = level;
            return this;
        }
        public WeeklyTaskBuilder status(Integer status) {
            this.status = status;
            return this;
        }
        public WeeklyTaskBuilder startDay(Integer startDay) {
            this.startDay = startDay;
            return this;
        }
        public WeeklyTaskBuilder startTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
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
    public String toString() {
        return "WeeklyTask{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", startDay=" + startDay +
                ", startTime=" + startTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
