package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

public class UpdateTaskQuery extends BaseQuery {
    @ApiModelProperty(value = "待更新的事项id", example = "15164845761")
    private Long taskId;

    @Override
    public String toString() {
        return "UpdateTaskQuery{" +
                "taskId=" + taskId +
                '}';
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
