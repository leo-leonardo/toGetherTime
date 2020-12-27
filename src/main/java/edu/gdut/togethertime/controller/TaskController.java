package edu.gdut.togethertime.controller;

import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.CreateWeeklyTaskQuery;
import edu.gdut.togethertime.utils.Result;
import edu.gdut.togethertime.utils.ResultFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("task")
@RestController
public class TaskController {

    @ResponseBody
    @PostMapping("create_temp_task")
    public Result createTempTask(@RequestBody CreateTempTaskQuery query) {

        return ResultFactory.success();
    }

    @ResponseBody
    @PostMapping("creat_weekly_task")
    public Result createWeeklyTask(@RequestBody CreateWeeklyTaskQuery query) {
        return ResultFactory.success();
    }
}
