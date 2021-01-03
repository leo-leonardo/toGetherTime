package edu.gdut.togethertime.mapper;

import edu.gdut.togethertime.model.entity.WeeklyTask;

import java.time.LocalDate;
import java.util.List;

public interface WeeklyTaskMapper {
    WeeklyTask selectWeeklyTaskById(Long id);
    WeeklyTask selectWeeklyTaskByTaskId(Long taskId);
    List<WeeklyTask> selectWeeklyTaskByUserId(Long userId);
    List<WeeklyTask> selectWeeklyTaskByTaskName(String taskName);

    List<WeeklyTask> selectWeeklyTask(String column, Object value);
    List<WeeklyTask> selectAllWeeklyTask();

    Integer insertWeeklyTask(WeeklyTask task);
    Integer updateWeeklyTask(WeeklyTask task);

    Integer deleteWeeklyTaskByPOJO(WeeklyTask task);
    Integer deleteWeeklyTaskById(Long id);

    List<WeeklyTask> selectWeeklyTaskByDate(LocalDate date, Long userId);
}
