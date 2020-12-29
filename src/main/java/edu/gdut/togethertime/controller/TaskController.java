package edu.gdut.togethertime.controller;

import edu.gdut.togethertime.exception.ExceptionEnum;
import edu.gdut.togethertime.model.dto.TempTaskDTO;
import edu.gdut.togethertime.model.dto.WeeklyTaskDTO;
import edu.gdut.togethertime.model.entity.TaskDTO;
import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.*;
import edu.gdut.togethertime.service.TaskService;
import edu.gdut.togethertime.utils.Result;
import edu.gdut.togethertime.utils.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("task")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @ApiOperation(value = "创建临时事项")
    @ResponseBody
    @PostMapping("create_temp_task")
    public Result<TempTaskDTO> createTempTask(@RequestBody CreateTempTaskQuery query) {
        TempTask tempTask = taskService.createTempTask(query);
        return ResultFactory.success(TempTaskDTO.castToTempTaskDTO(tempTask));
    }

    @ApiOperation(value = "创建周常事项")
    @ResponseBody
    @PostMapping("creat_weekly_task")
    public Result createWeeklyTask(@RequestBody CreateWeeklyTaskQuery query) {
        WeeklyTask weeklyTask = taskService.createWeeklyTask(query);
        return ResultFactory.success(WeeklyTaskDTO.castToWeeklyTaskDTO(weeklyTask));
    }

    @ApiOperation(value = "更新临时事项")
    @ResponseBody
    @PostMapping("update_temp_task")
    public Result<TempTaskDTO> updateTempTask(@RequestBody UpdateTempTaskQuery query) {
        TempTask tempTask = taskService.updateTempTask(query);
        return ResultFactory.success(TempTaskDTO.castToTempTaskDTO(tempTask));
    }

    @ApiOperation(value = "更新周常事项")
    @ResponseBody
    @PostMapping("update_weekly_task")
    public Result<WeeklyTaskDTO> updateWeeklyTask(@RequestBody UpdateWeeklyTaskQuery query) {
        WeeklyTask weeklyTask = taskService.updateWeeklyTask(query);
        return ResultFactory.success(WeeklyTaskDTO.castToWeeklyTaskDTO(weeklyTask));
    }

    @ApiOperation(value = "删除事项")
    @ResponseBody
    @GetMapping("delete_task")
    public Result<Integer> deleteTask(Long taskId) {
        return ResultFactory.success(taskService.deleteTaskByTaskId(taskId));
    }

    @ApiOperation(value = "完成事项")
    @ResponseBody
    @PostMapping("complete_task")
    public Result<TaskDTO> completeTask(@RequestBody UpdateTaskQuery query) {
        if (taskService.getTempTaskByTaskId(query.getTaskId()) == null) {
            if (taskService.getWeeklyTaskByTaskId(query.getTaskId()) == null) {
                throw ExceptionEnum.exception(ExceptionEnum.TASK_NOT_EXIST);
            } else {
                UpdateWeeklyTaskQuery weeklyTaskQuery = new UpdateWeeklyTaskQuery();
                weeklyTaskQuery.setTaskId(query.getTaskId());
                weeklyTaskQuery.setStatus(2);
                return ResultFactory.success(new TaskDTO<>(1, taskService.updateWeeklyTask(weeklyTaskQuery)));
            }
        } else {
            UpdateTempTaskQuery tempTaskQuery = new UpdateTempTaskQuery();
            tempTaskQuery.setTaskId(query.getTaskId());
            tempTaskQuery.setStatus(2);
            return ResultFactory.success(new TaskDTO<>(2, taskService.updateTempTask(tempTaskQuery)));
        }
    }
}
