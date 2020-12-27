package edu.gdut.togethertime.service.impl;

import edu.gdut.togethertime.mapper.TempTaskMapper;
import edu.gdut.togethertime.mapper.WeeklyTaskMapper;
import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;
import edu.gdut.togethertime.service.TaskService;
import edu.gdut.togethertime.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TempTaskMapper tempTaskMapper;
    @Autowired
    private WeeklyTaskMapper weeklyTaskMapper;

    @Override
    public TempTask createTempTask(CreateTempTaskQuery query) {
        TempTask task = new TempTask(TempTask.getBuilder()
                .userId(query.getUserId())
                .taskName(query.getTaskName())
                .status(query.getStatus())
                .level(query.getLevel())
                .startTime(query.getStartTime())
                .endTime(query.getEndTime())
                .taskId(RandomUtils.randomId()));
        if (checkIfExistsTaskId(task.getTaskId())) {
            tempTaskMapper.insertTempTask(task);
        } else {
            task.setTaskId(RandomUtils.randomId());
            while (checkIfExistsTaskId(task.getTaskId())) {
                task.setTaskId(RandomUtils.randomId());
            }
            tempTaskMapper.insertTempTask(task);
        }
        return tempTaskMapper.selectTempTaskByTaskId(task.getTaskId());
    }

    @Override
    public List<TempTask> getTempTaskListByUserId(Long userId) {
        List<TempTask> tempTasks = tempTaskMapper.selectTempTaskByUserId(userId);
        return tempTasks.isEmpty() ? new ArrayList<>() : tempTasks;
    }

    @Override
    public WeeklyTask createWeeklyTask(CreateWeeklyTaskQuery query) {

        WeeklyTask task = new WeeklyTask(WeeklyTask.getBuilder()
                .userId(query.getUserId())
                .taskName(query.getTaskName())
                .status(query.getStatus())
                .level(query.getLevel())
                .startTime(query.getStartTime())
                .startDay(query.getStartDay())
                .taskId(RandomUtils.randomId()));

        if (checkIfExistsTaskId(task.getTaskId())) {
            weeklyTaskMapper.insertWeeklyTask(task);
        } else {
            task.setTaskId(RandomUtils.randomId());
            while (checkIfExistsTaskId(task.getTaskId())) {
                task.setTaskId(RandomUtils.randomId());
            }
            weeklyTaskMapper.insertWeeklyTask(task);
        }
        return weeklyTaskMapper.selectWeeklyTaskByTaskId(task.getTaskId());
    }

    @Override
    public List<WeeklyTask> getWeeklyTaskListByUserId(Long userId) {
        List<WeeklyTask> weeklyTasks = weeklyTaskMapper.selectWeeklyTaskByUserId(userId);
        return weeklyTasks.isEmpty() ? new ArrayList<>() : weeklyTasks;
    }

    private Boolean checkIfExistsTaskId(Long taskId) {
        return tempTaskMapper.selectTempTaskByTaskId(taskId) == null
                && weeklyTaskMapper.selectWeeklyTaskByTaskId(taskId) == null;
    }
}
