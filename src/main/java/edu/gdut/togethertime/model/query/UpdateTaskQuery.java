package edu.gdut.togethertime.model.query;

public class UpdateTaskQuery extends BaseQuery {
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
