package edu.gdut.togethertime.service;

import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;

import java.util.List;

public interface TaskService {
    //tempTask
    TempTask createTempTask(CreateTempTaskQuery query);
    List<TempTask> getTempTaskListByUserId(Long userId);



    //weeklyTask
    WeeklyTask createWeeklyTask(CreateWeeklyTaskQuery query);
    List<WeeklyTask> getWeeklyTaskListByUserId(Long userId);

}
