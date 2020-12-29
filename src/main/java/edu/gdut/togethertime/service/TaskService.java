package edu.gdut.togethertime.service;

import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;
import edu.gdut.togethertime.model.query.UpdateTempTaskQuery;
import edu.gdut.togethertime.model.query.UpdateWeeklyTaskQuery;

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

}
