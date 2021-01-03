package edu.gdut.togethertime.model.dto;

import edu.gdut.togethertime.model.entity.TempTask;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class TempTaskDTO {
    @ApiModelProperty(value = "用户id", example = "1")
    private Long userId;
    @ApiModelProperty(value = "事项id", example = "123456789")
    private Long taskId;
    @ApiModelProperty(value = "事项名", example = "我要学习")
    private String taskName;
    @ApiModelProperty(value = "开始时间", example = "2020-12-25 10:10:10")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", example = "2020-12-25 10:10:10")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "是否私人：1-私人，2-公开", example = "1")
    private Integer ifPrivate;
    @ApiModelProperty(value = "事项重要等级", example = "1")
    private Integer level;
    @ApiModelProperty(value = "事项状态", example = "1")
    private Integer status;

    public static TempTaskDTO castToTempTaskDTO(TempTask tempTask) {
        TempTaskDTO tempTaskDTO = new TempTaskDTO();
        tempTaskDTO.setUserId(tempTask.getUserId());
        tempTaskDTO.setTaskId(tempTask.getTaskId());
        tempTaskDTO.setTaskName(tempTask.getTaskName());
        tempTaskDTO.setStartTime(tempTask.getStartTime());
        tempTaskDTO.setEndTime(tempTask.getEndTime());
        tempTaskDTO.setLevel(tempTask.getLevel());
        tempTaskDTO.setIfPrivate(tempTask.getIfPrivate());
        tempTaskDTO.setStatus(tempTask.getStatus());
        return tempTaskDTO;
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

    public Integer getIfPrivate() {
        return ifPrivate;
    }

    public void setIfPrivate(Integer ifPrivate) {
        this.ifPrivate = ifPrivate;
    }

    @Override
    public String toString() {
        return "TempTaskDTO{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", ifPrivate=" + ifPrivate +
                ", level=" + level +
                ", status=" + status +
                '}';
    }
}
