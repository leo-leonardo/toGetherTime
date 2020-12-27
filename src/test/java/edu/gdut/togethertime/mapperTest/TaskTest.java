package edu.gdut.togethertime.mapperTest;

import edu.gdut.togethertime.mapper.TempTaskMapper;
import edu.gdut.togethertime.mapper.WeeklyTaskMapper;
import edu.gdut.togethertime.model.entity.TempTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//数据库测试事务回滚
@Transactional
public class TaskTest {
    @Autowired
    private TempTaskMapper tempTaskMapper;
    @Autowired
    private WeeklyTaskMapper weeklyTaskMapper;

    @Test
    void testInsertTempTask() {
        //拟造一个临时日程
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusHours(1);
        TempTask tempTask = new TempTask(TempTask.getBuilder()
                .userId(1L)
                .taskId(1L)
                .taskName("test")
                .status(1)
                .level(1)
                .startTime(startTime)
                .endTime(endTime));

        tempTask.setId(1L);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        tempTask.setCreateTime(startTime);
        System.out.println(tempTask);

        Integer result = tempTaskMapper.insertTempTask(tempTask);
        System.out.println(result);

        System.out.println(tempTaskMapper.selectTempTaskByTaskId(1L));

        System.out.println(tempTaskMapper.selectTempTaskByTaskName("test"));
        System.out.println(tempTaskMapper.selectTempTaskByTaskName("t"));
        System.out.println(tempTaskMapper.selectTempTaskByUserId(1L));

        tempTask = tempTaskMapper.selectTempTaskByTaskId(1L);
        tempTask.setTaskName("new test");
        System.out.println(tempTaskMapper.updateTempTask(tempTask));

    }
}
