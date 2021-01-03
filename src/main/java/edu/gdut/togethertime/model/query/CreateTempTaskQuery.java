package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class CreateTempTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "事项名", example = "我要学习")
    private String taskName;
    @ApiModelProperty(value = "状态：1-还没完成，2-完成了", example = "1")
    private Integer status;
    @ApiModelProperty(value = "重要程度：1-紧急重要，2-紧急不重要，3-重要不紧急，4-不紧急不重要", example = "1")
    private Integer level;
    @ApiModelProperty(value = "是否私人：1-私人，2-公开", example = "1")
    private Integer ifPrivate;
    @ApiModelProperty(value = "开始时间", example = "2020-12-25 10:10:10")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", example = "2020-12-25 12:12:12")
    private LocalDateTime endTime;

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

    public Integer getIfPrivate() {
        return ifPrivate;
    }

    public void setIfPrivate(Integer ifPrivate) {
        this.ifPrivate = ifPrivate;
    }

    @Override
    public String toString() {
        return "CreateTempTaskQuery{" +
                "taskName='" + taskName + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", ifPrivate=" + ifPrivate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
