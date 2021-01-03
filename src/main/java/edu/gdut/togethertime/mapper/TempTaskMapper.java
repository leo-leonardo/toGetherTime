package edu.gdut.togethertime.mapper;

import edu.gdut.togethertime.model.entity.TempTask;

import java.time.LocalDate;
import java.util.List;

public interface TempTaskMapper {
    TempTask selectTempTaskById(Long id);
    TempTask selectTempTaskByTaskId(Long id);
    List<TempTask> selectTempTaskByUserId(Long userId);
    List<TempTask> selectTempTaskByTaskName(String taskName);

    List<TempTask> selectTempTask(String column, Object value);
    List<TempTask> selectAllTempTask();

    Integer insertTempTask(TempTask task);
    Integer updateTempTask(TempTask task);

    Integer deleteTempTaskByPOJO(TempTask task);
    Integer deleteTempTaskById(Long id);

    List<TempTask> selectTempTaskByDate(LocalDate date, Long userId);
}
