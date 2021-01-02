package edu.gdut.togethertime.serviceTest;

import edu.gdut.togethertime.model.entity.TempTask;
import edu.gdut.togethertime.model.query.CreateTempTaskQuery;
import edu.gdut.togethertime.model.query.UpdateTempTaskQuery;
import edu.gdut.togethertime.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class TaskDTOInterfaceServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    void testUpdate() {
        //测试数据
        CreateTempTaskQuery query1 = new CreateTempTaskQuery();
        query1.setUserId(1L);
        query1.setTaskName("学习");
        query1.setLevel(1);
        query1.setStatus(1);
        query1.setStartTime(LocalDateTime.now());
        query1.setEndTime(LocalDateTime.now());

        taskService.createTempTask(query1);
        TempTask tempTask = taskService.getTempTaskListByUserId(1L).get(0);
        System.out.println(tempTask);

        UpdateTempTaskQuery query2 = new UpdateTempTaskQuery();
        query2.setTaskName("休息");
        query2.setTaskId(tempTask.getTaskId());
        taskService.updateTempTask(query2);
        System.out.println(taskService.getTempTaskListByUserId(1L));
    }
}
