package edu.gdut.togethertime.controller;

import edu.gdut.togethertime.exception.ExceptionEnum;
import edu.gdut.togethertime.model.dto.TempTaskDTO;
import edu.gdut.togethertime.model.dto.WeeklyTaskDTO;
import edu.gdut.togethertime.model.entity.TaskDTO;
import edu.gdut.togethertime.model.entity.TaskDTOInterface;
import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.entity.WeeklyTask;
import edu.gdut.togethertime.model.query.*;
import edu.gdut.togethertime.service.TaskService;
import edu.gdut.togethertime.service.UserService;
import edu.gdut.togethertime.utils.Result;
import edu.gdut.togethertime.utils.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("task")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户状态")
    @PostMapping("status")
    public Result getTaskByStatus(@RequestBody BaseQuery query) {
        return ResultFactory.success();
    }

    @ApiOperation(value = "获取用户的事项")
    @ResponseBody
    @PostMapping("get_task")
    public Result<List<TaskDTO>> getTask(@RequestBody GetTaskQuery query) {
        if (query.getUserId() == null) {
            throw ExceptionEnum.exception(ExceptionEnum.PARAM_NOT_EXIST);
        }
        if (!userService.checkUserIfExists(query.getUserId())) {
            throw ExceptionEnum.exception(ExceptionEnum.USER_NOT_EXIST);
        }
        List<TaskDTO> taskDTOs = new ArrayList<>();
        //有taskId带上就优先取单个事项
        if (query.getTaskId() != null) {
            TaskDTO taskDTO;
            TaskDTOInterface task;
            if ((task = taskService.getTempTaskByTaskId(query.getTaskId())) != null) {
                taskDTO = new TaskDTO(1, task);
                taskDTOs.add(taskDTO);
            }
            if ((task = taskService.getWeeklyTaskByTaskId(query.getTaskId())) != null) {
                taskDTO = new TaskDTO(2, task);
                taskDTOs.add(taskDTO);
            }
            return ResultFactory.success(taskDTOs);
        }
        //没有taskId根据status取该用户的事项
        switch (query.getTaskType()) {
            case "ALL":
                for (TempTask tempTask : taskService.getTempTaskListByUserId(query.getUserId())) {
                    TaskDTO taskDTO = new TaskDTO(1, tempTask);
                    taskDTOs.add(taskDTO);
                }
                for (WeeklyTask weeklyTask : taskService.getWeeklyTaskListByUserId(query.getUserId())) {
                    TaskDTO taskDTO = new TaskDTO(2, weeklyTask);
                    taskDTOs.add(taskDTO);
                }
                break;
            case "TEMP":
                for (TempTask tempTask : taskService.getTempTaskListByUserId(query.getUserId())) {
                    TaskDTO taskDTO = new TaskDTO(1, tempTask);
                    taskDTOs.add(taskDTO);
                }
                break;
            case "WEEKLY":
                for (WeeklyTask weeklyTask : taskService.getWeeklyTaskListByUserId(query.getUserId())) {
                    TaskDTO taskDTO = new TaskDTO(2, weeklyTask);
                    taskDTOs.add(taskDTO);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + query.getTaskType());
        }
        return ResultFactory.success(taskDTOs);
    }

    @ApiOperation(value = "获取当天事项")
    @PostMapping("get/date")
    public Result getTaskByDate(@RequestBody GetTaskQuery query) {
        return ResultFactory.success(taskService.getTaskByDate(query.getDate(), query.getUserId()));
    }

    @ApiOperation(value = "创建临时事项")
    @ResponseBody
    @PostMapping("create_temp_task")
    public Result<TempTaskDTO> createTempTask(@RequestBody CreateTempTaskQuery query) {
        System.out.println(query);
        TempTask tempTask = taskService.createTempTask(query);
        return ResultFactory.success(TempTaskDTO.castToTempTaskDTO(tempTask));
    }

    @ApiOperation(value = "创建周常事项")
    @ResponseBody
    @PostMapping("creat_weekly_task")
    public Result createWeeklyTask(@RequestBody CreateWeeklyTaskQuery query) {
        WeeklyTask weeklyTask = taskService.createWeeklyTask(query);
        return ResultFactory.success(edu.gdut.togethertime.model.dto.WeeklyTaskDTO.castToWeeklyTaskDTO(weeklyTask));
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
        return ResultFactory.success(edu.gdut.togethertime.model.dto.WeeklyTaskDTO.castToWeeklyTaskDTO(weeklyTask));
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
        //检查事项信息
        TaskDTOInterface taskDTOInterface;
        if ((taskDTOInterface = taskService.getTempTaskByTaskId(query.getTaskId())) == null) {
            if ((taskDTOInterface = taskService.getWeeklyTaskByTaskId(query.getTaskId())) == null) {
                throw ExceptionEnum.exception(ExceptionEnum.TASK_NOT_EXIST);
            } else {
                return ResultFactory.success(taskService.completeTask(taskDTOInterface));
            }
        } else {
            return ResultFactory.success(taskService.completeTask(taskDTOInterface));
        }
    }

    @ApiOperation(value = "获取完成与未完成事项")
    @ResponseBody
    @PostMapping("get/fin_not")
    public Result getCompleteAndNotCompleteTask(@RequestBody BaseQuery query) {
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (TempTask tempTask : taskService.getTempTaskListByUserId(query.getUserId())) {
            taskDTOList.add(new TaskDTO(tempTask.getStatus(), tempTask));
        }
        for (WeeklyTask weeklyTask : taskService.getWeeklyTaskListByUserId(query.getUserId())) {
            taskDTOList.add(new TaskDTO(weeklyTask.getStatus(), weeklyTask));
        }
        return ResultFactory.success(taskDTOList);
    }
}
