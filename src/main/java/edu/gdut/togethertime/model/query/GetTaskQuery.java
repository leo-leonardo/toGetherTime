package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

public class GetTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "需获取的事项类型:ALL-全部，TEMP-临时事项，WEEKLY-周常事项", example = "ALL")
    private String taskType;
    @ApiModelProperty(value = "如果有该字段，则获取指定事项的信息；否则根据taskStatus获取事项列表", example = "1")
    private Long taskId;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "GetTaskQuery{" +
                "taskStatus='" + taskType + '\'' +
                ", taskId=" + taskId +
                '}';
    }
}
