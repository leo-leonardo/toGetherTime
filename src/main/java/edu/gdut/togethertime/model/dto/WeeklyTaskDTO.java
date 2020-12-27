package edu.gdut.togethertime.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalTime;

public class WeeklyTaskDTO {
    @ApiModelProperty(value = "用户id", example = "1")
    private Long userId;
    @ApiModelProperty(value = "事项id", example = "1234567890")
    private Long taskId;
    @ApiModelProperty(value = "事项名", example = "我要学习")
    private String taskName;
    @ApiModelProperty(value = "星期", example = "1", allowableValues = "{1,2,3,4,5,6,7}")
    private Integer dayOfWeek;
    @ApiModelProperty(value = "时间", example = "10:10:10")
    private LocalTime time;

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

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeeklyTaskDTO{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                '}';
    }
}
