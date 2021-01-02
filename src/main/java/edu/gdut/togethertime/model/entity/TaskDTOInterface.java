package edu.gdut.togethertime.model.entity;

public interface TaskDTOInterface {
    Long getUserId();
    Long getTaskId();
    String getTaskName();
    Integer getStatus();
    Integer getLevel();
    void setTaskName(String taskName);
    void setStatus(Integer status);
    void setLevel(Integer level);

}
