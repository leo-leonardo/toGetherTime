package edu.gdut.togethertime.service.impl;

import edu.gdut.togethertime.mapper.TempTaskMapper;
import edu.gdut.togethertime.mapper.WeeklyTaskMapper;
import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;
import edu.gdut.togethertime.model.query.UpdateTempTaskQuery;
import edu.gdut.togethertime.model.query.UpdateWeeklyTaskQuery;
import edu.gdut.togethertime.service.TaskService;
import edu.gdut.togethertime.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        return tempTaskMapper.selectTempTaskByTaskId(taskId) != null
                || weeklyTaskMapper.selectWeeklyTaskByTaskId(taskId) != null;
    }

    @Override
    public TempTask updateTempTask(UpdateTempTaskQuery query) {
        if (checkIfExistsTaskId(query.getTaskId())) {
            TempTask tempTask = tempTaskMapper.selectTempTaskByTaskId(query.getTaskId());
            updateField(query, tempTask);
            tempTaskMapper.updateTempTask(tempTask);
            return tempTask;
        } else return null;
    }

    private String getter(String name) {
        return "get" + firstUpper(name);
    }

    private String setter(String name) {
        return "set" + firstUpper(name);
    }

    private String firstUpper(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    @Override
    public WeeklyTask updateWeeklyTask(UpdateWeeklyTaskQuery query) {
        if (checkIfExistsTaskId(query.getTaskId())) {
            WeeklyTask weeklyTask = weeklyTaskMapper.selectWeeklyTaskByTaskId(query.getTaskId());
            updateField(query, weeklyTask);
            weeklyTaskMapper.updateWeeklyTask(weeklyTask);
            return weeklyTask;
        } else return null;
    }

    private <T1, T2> T2 updateField(T1 query, T2 task) {
        //将query的字段传给Task,保证字段名和方法名相同
        for (Field declaredField : query.getClass().getDeclaredFields()) {
            try {
                Method setter = task.getClass().getDeclaredMethod(setter(declaredField.getName()), declaredField.getType());
                Method getter = query.getClass().getDeclaredMethod(getter(declaredField.getName()));
                setter.setAccessible(true);
                getter.setAccessible(true);
                Object invoke = getter.invoke(query);
                if (invoke == null) continue;
                setter.invoke(task, invoke);
                setter.setAccessible(false);
                getter.setAccessible(false);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return task;
    }

    @Override
    public int deleteTaskByTaskId(Long taskId) {
        if (checkIfExistsTaskId(taskId)) {
            TempTask tempTask;
            if ((tempTask = tempTaskMapper.selectTempTaskByTaskId(taskId)) != null) {
                return tempTaskMapper.deleteTempTaskByPOJO(tempTask);
            } else {
                return weeklyTaskMapper.deleteWeeklyTaskByPOJO(weeklyTaskMapper.selectWeeklyTaskByTaskId(taskId));
            }
        } else return 0;
    }

    @Override
    public TempTask getTempTaskByTaskId(Long taskId) {
        return tempTaskMapper.selectTempTaskByTaskId(taskId);
    }

    @Override
    public WeeklyTask getWeeklyTaskByTaskId(Long taskId) {
        return weeklyTaskMapper.selectWeeklyTaskByTaskId(taskId);
    }
}
