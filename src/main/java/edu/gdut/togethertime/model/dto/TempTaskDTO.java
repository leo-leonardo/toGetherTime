package edu.gdut.togethertime.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class TempTaskDTO {
    @ApiModelProperty(value = "用户id", example = "1")
    private Long userId;
    @ApiModelProperty(value = "事项id", example = "123456789")
    private Long taskId;
    @ApiModelProperty(value = "事项名", example = "我要学习")
    private String taskName;
    @ApiModelProperty(value = "时间", example = "2020-12-25 10:10:10")
    private LocalDateTime time;
    @ApiModelProperty(value = "事项重要等级", example = "1")
    private Integer level;
    @ApiModelProperty(value = "事项状态", example = "1")
    private Integer status;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "TempTaskDTO{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", time=" + time +
                ", level=" + level +
                ", status=" + status +
                '}';
    }
}
