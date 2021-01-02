package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalTime;

public class CreateWeeklyTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "事项名", example = "我要学习")
    private String taskName;
    @ApiModelProperty(value = "状态：1-还没完成，2-完成了", example = "1")
    private Integer status;
    @ApiModelProperty(value = "重要程度：1-紧急重要，2-紧急不重要，3-重要不紧急，4-不紧急不重要", example = "1")
    private Integer level;
    @ApiModelProperty(value = "星期", example = "1", allowableValues = "{1,2,3,4,5,6,7}")
    private Integer startDay;
    @ApiModelProperty(value = "时间", example = "10:10:10")
    private LocalTime startTime;


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

    @Override
    public String toString() {
        return "CreateWeeklyTaskQuery{" +
                "taskName='" + taskName + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", startDay=" + startDay +
                ", startTime=" + startTime +
                '}';
    }
}
