package edu.gdut.togethertime;

import edu.gdut.togethertime.controller.TaskController;
import edu.gdut.togethertime.controller.UserController;
import edu.gdut.togethertime.model.query.*;
import io.netty.handler.codec.base64.Base64Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@Transactional
public class TestAll {
    @Autowired
    private UserController userController;
    @Autowired
    private TaskController taskController;

    @Test
    void testUser() {
        //第一步登录
        WxProgramLoginQuery query = new WxProgramLoginQuery();
        query.setUsername("Leo");
        query.setImgUrl("https://www.baidu.com");
        query.setCode("test");
        //会报错,并输出微信返回的invalid code
        userController.login(query);
    }

    @Test
    void testTask() {
        //1.新增加事项
        CreateTempTaskQuery tempTaskQuery = new CreateTempTaskQuery();
        tempTaskQuery.setTaskName("testTempTask");
        tempTaskQuery.setLevel(1);
        tempTaskQuery.setStartTime(LocalDateTime.now().plusSeconds(10));
        tempTaskQuery.setEndTime(LocalDateTime.now().plusSeconds(15));
        tempTaskQuery.setIfPrivate(1);
        tempTaskQuery.setUserId(1L);
        taskController.createTempTask(tempTaskQuery);
        //2.新增加事项
        CreateWeeklyTaskQuery weeklyTaskQuery = new CreateWeeklyTaskQuery();
        weeklyTaskQuery.setTaskName("testWeeklyTask");
        weeklyTaskQuery.setLevel(1);
        weeklyTaskQuery.setIfPrivate(1);
        weeklyTaskQuery.setStartDay(1);
        weeklyTaskQuery.setStartTime(LocalTime.now());
        weeklyTaskQuery.setUserId(1L);
        taskController.createWeeklyTask(weeklyTaskQuery);
        //3.获得事项
        GetTaskQuery getTaskQuery = new GetTaskQuery();
        getTaskQuery.setUserId(1L);
        getTaskQuery.setTaskType("ALL");
        System.out.println(taskController.getTask(getTaskQuery));
        getTaskQuery.setTaskType("TEMP");
        System.out.println(taskController.getTask(getTaskQuery));
        getTaskQuery.setTaskType("WEEKLY");
        System.out.println(taskController.getTask(getTaskQuery));
    }
}
