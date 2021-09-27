package com.adverity.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.checked;

public class TaskItem {

    private final SelenideElement root;

    public TaskItem(SelenideElement element) {
        this.root = element;
    }

    private SelenideElement checkbox() {
        return root.$(".toggle");
    }

    @Step
    public String taskName() {
        return root.$(".edit").getValue();
    }

    @Step
    public TaskItem complete() {
        if (!checkbox().isSelected()) {
            checkbox().click();
        }
        return this;
    }

    @Step
    public TaskItem remove() {
        root.hover();
        root.$(".destroy").click();
        return this;
    }

    @Step
    public void verifyCompleted() {
        checkbox().shouldBe(checked);
    }

    @Step
    public void verifyRemoved() {
        root.shouldBe(Condition.disappear);
    }
}
