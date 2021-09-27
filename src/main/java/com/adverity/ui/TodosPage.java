package com.adverity.ui;

import com.adverity.config.TestConfig;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Component
public class TodosPage {

    @Resource
    private TestConfig testConfig;

    private final SelenideElement root = $(".todoapp");

    @Step
    public TodosPage open() {
        Selenide.open(testConfig.appUrl());
        return this;
    }

    @Step
    public TodosPage fillTaskName(String taskName) {
        root.$(".new-todo").val(taskName);
        return this;
    }

    @Step
    public TodosPage confirmAddingTask() {
        root.$(".new-todo").pressEnter();
        return this;
    }

    @Step
    public TaskItem addTask(String taskName) {
        fillTaskName(taskName);
        confirmAddingTask();
        verifyTaskPresent(taskName);

        return getTask(taskName);
    }

    @Step
    public TaskItem getTask(String taskName) {
        return task(taskName);
    }

    private List<TaskItem> tasks() {
        return root.$$(".todo-list li").stream().map(TaskItem::new).collect(Collectors.toList());
    }

    private TaskItem task(String taskName) {
        return tasks().stream()
                .filter(it -> it.taskName().equals(taskName))
                .findFirst().orElseThrow();
    }

    @Step
    public void verifyTaskPresent(String taskName) {
        root.$$(".todo-list li").find(Condition.text(taskName)).shouldBe(visible);
    }

}
