package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class UpdateTempTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "主键id", example = "1", hidden = true)
    private Long id;
    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Long userId;
    @ApiModelProperty(value = "事项id", example = "1", required = true)
    private Long taskId;
    @ApiModelProperty(value = "事项名", example = "我要休息", required = true)
    private String taskName;
    @ApiModelProperty(value = "事项状态", example = "1", required = true)
    private Integer status;
    @ApiModelProperty(value = "紧急程度", example = "1", required = true)
    private Integer level;
    @ApiModelProperty(value = "开始时间", example = "2000-01-01 00:00:00")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", example = "2000-01-01 23:59:59")
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "UpdateTempTaskQuery{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

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
}
