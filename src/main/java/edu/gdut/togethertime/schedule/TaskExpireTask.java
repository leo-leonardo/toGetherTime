package edu.gdut.togethertime.schedule;

import edu.gdut.togethertime.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class TaskExpireTask {
    @Autowired
    private TaskService taskService;

    @Scheduled(cron = "0 * * * * * ?")
    public void updateTaskStatus() {
        taskService.expireTask();
    }
}
