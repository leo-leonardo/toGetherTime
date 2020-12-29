package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalTime;

public class UpdateWeeklyTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "主键id", example = "1", hidden = true)
    private Long id;
    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Long userId;
    @ApiModelProperty(value = "事项id", example = "1", required = true)
    private Long taskId;
    @ApiModelProperty(value = "事项名", example = "我要学习", required = true)
    private String taskName;
    @ApiModelProperty(value = "事项紧急程度", example = "1", required = true)
    private Integer level;
    @ApiModelProperty(value = "事项状态", example = "1", required = true)
    private Integer status;
    @ApiModelProperty(value = "开始星期", example = "1", required = true)
    private Integer startDay;
    @ApiModelProperty(value = "开始时间", example = "10:10:10")
    private LocalTime startTime;

    @Override
    public String toString() {
        return "UpdateWeeklyTaskQuery{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", startDay=" + startDay +
                ", startTime=" + startTime +
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
}
