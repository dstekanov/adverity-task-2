package com.adverity.todos;

import com.adverity.BaseTest;
import com.adverity.ui.TaskItem;
import com.adverity.ui.TodosPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Epic("Demo Epic")
public class DemoTest extends BaseTest {

    @Autowired
    private TodosPage todosPage;

    @Story("Demo Story - 1")
    @Test
    public void checkUserCanAddNewTask() {
        String taskName = RandomStringUtils.randomAlphabetic(10);
        todosPage.open()
                .fillTaskName(taskName)
                .confirmAddingTask();

        todosPage.verifyTaskPresent(taskName);
    }

    @Story("Demo Story - 1")
    @Test
    public void checkUserCanCompleteTask() {
        String taskName = RandomStringUtils.randomAlphabetic(10);

        TaskItem task = todosPage.open()
                .addTask(taskName);

        task.complete()
                .verifyCompleted();
    }

    @Story("Demo Story - 2")
    @Test
    public void checkUserCanRemoveTask() {
        String taskName = RandomStringUtils.randomAlphabetic(10);

        TaskItem task = todosPage.open()
                .addTask(taskName);

        task.remove()
                .verifyRemoved();
    }

    @Story("Demo Story - 2")
    @Test
    public void failedTest() {
        String taskName = RandomStringUtils.randomAlphabetic(10);

        TaskItem task = todosPage.open()
                .addTask(taskName);

        // defect here
        task.complete()
                .verifyRemoved();
    }
}
