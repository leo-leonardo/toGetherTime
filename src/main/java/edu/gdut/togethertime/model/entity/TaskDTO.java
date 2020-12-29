package edu.gdut.togethertime.model.entity;

public class TaskDTO<T> {
    private Integer type;
    private T task;

    public TaskDTO(Integer type, T task) {
        this.type = type;
        this.task = task;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getTask() {
        return task;
    }

    public void setTask(T task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "type=" + type +
                ", task=" + task +
                '}';
    }
}
