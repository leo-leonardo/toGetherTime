package edu.gdut.togethertime.model.dto;

import edu.gdut.togethertime.model.entity.WeeklyTask;
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
    @ApiModelProperty(value = "事项状态", example = "1")
    private Integer status;
    @ApiModelProperty(value = "紧急程度", example = "1")
    private Integer level;

    public static WeeklyTaskDTO castToWeeklyTaskDTO(WeeklyTask weeklyTask) {
        WeeklyTaskDTO weeklyTaskDTO = new WeeklyTaskDTO();
        weeklyTaskDTO.setUserId(weeklyTask.getUserId());
        weeklyTaskDTO.setTaskId(weeklyTask.getTaskId());
        weeklyTaskDTO.setTaskName(weeklyTask.getTaskName());
        weeklyTaskDTO.setDayOfWeek(weeklyTask.getStartDay());
        weeklyTaskDTO.setTime(weeklyTask.getStartTime());
        weeklyTaskDTO.setStatus(weeklyTask.getStatus());
        weeklyTaskDTO.setLevel(weeklyTask.getLevel());
        return weeklyTaskDTO;
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

    @Override
    public String toString() {
        return "WeeklyTask{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                ", status=" + status +
                ", level=" + level +
                '}';
    }
}
