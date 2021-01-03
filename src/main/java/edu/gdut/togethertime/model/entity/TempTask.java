package edu.gdut.togethertime.model.entity;

import java.time.LocalDateTime;

public class TempTask implements TaskDTOInterface {
    private Long id;
    private Long userId;
    private Long taskId;
    private String taskName;
    private Integer status;
    private Integer level;
    private Integer ifPrivate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public TempTask() {

    }

    public TempTask(TempTaskBuilder builder) {
        this.userId = builder.userId;
        this.taskId = builder.taskId;
        this.taskName = builder.taskName;
        this.status = builder.status;
        this.level = builder.level;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public static TempTaskBuilder getBuilder() {
        return new TempTaskBuilder();
    }

    public static class TempTaskBuilder {
        private Long userId;
        private Long taskId;
        private String taskName;
        private Integer status;
        private Integer level;
        private Integer ifPrivate;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public TempTaskBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public TempTaskBuilder taskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }
        public TempTaskBuilder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }
        public TempTaskBuilder status(Integer status) {
            this.status = status;
            return this;
        }
        public TempTaskBuilder level(Integer level) {
            this.level = level;
            return this;
        }
        public TempTaskBuilder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }
        public TempTaskBuilder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }
        public TempTaskBuilder ifPrivate(Integer ifPrivate) {
            this.ifPrivate = ifPrivate;
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

    public Integer getIfPrivate() {
        return ifPrivate;
    }

    public void setIfPrivate(Integer ifPrivate) {
        this.ifPrivate = ifPrivate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
        return "TempTask{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
