package edu.gdut.togethertime.service;

import edu.gdut.togethertime.model.entity.*;
import edu.gdut.togethertime.model.entity.TaskDTOInterface;
import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;
import edu.gdut.togethertime.model.query.UpdateTempTaskQuery;
import edu.gdut.togethertime.model.query.UpdateWeeklyTaskQuery;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    //tempTask
    TempTask createTempTask(CreateTempTaskQuery query);
    List<TempTask> getTempTaskListByUserId(Long userId);
    TempTask updateTempTask(UpdateTempTaskQuery query);
    TempTask getTempTaskByTaskId(Long taskId);

    //weeklyTask
    WeeklyTask createWeeklyTask(CreateWeeklyTaskQuery query);
    List<WeeklyTask> getWeeklyTaskListByUserId(Long userId);
    WeeklyTask updateWeeklyTask(UpdateWeeklyTaskQuery query);
    WeeklyTask getWeeklyTaskByTaskId(Long taskId);

    //common
    int deleteTaskByTaskId(Long taskId);
    TaskDTO completeTask(TaskDTOInterface taskDTOInterface);
    List<TaskDTO> getAllTask();

    List<TaskDTOInterface> getTaskByDate(LocalDate date, Long userId);

    Integer expireTask();
}
