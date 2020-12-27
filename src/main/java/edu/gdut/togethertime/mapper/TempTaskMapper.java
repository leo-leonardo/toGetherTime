package edu.gdut.togethertime.mapper;

import edu.gdut.togethertime.model.entity.TempTask;

import java.util.List;

public interface TempTaskMapper {
    TempTask selectTempTaskById(Long id);
    TempTask selectTempTaskByTaskId(Long id);
    List<TempTask> selectTempTaskByUserId(Long userId);
    List<TempTask> selectTempTaskByTaskName(String taskName);

    Integer insertTempTask(TempTask task);
    Integer updateTempTask(TempTask task);

    Integer deleteTempTaskByPOJO(TempTask task);
    Integer deleteTempTaskById(Long id);
}
