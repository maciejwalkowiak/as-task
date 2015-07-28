package com.github.maciejwalkowiak.as.e2e;

import org.fluentlenium.core.FluentPage;

import java.util.concurrent.TimeUnit;

public class HomePage extends FluentPage {
    private static final String INPUT = "#input";
    private static final String BUTTON = "#button";
    private static final String RESULT = "#result";

    public String getUrl() {
        return "http://localhost:8080/";
    }

    public void fillUngrouped(String value) {
        fill(INPUT).with(value);
    }

    public void submitForm() {
        click(BUTTON);
        await().atMost(5, TimeUnit.SECONDS).until(RESULT).areDisplayed();
    }

    public String getResult() {
        return find(RESULT).getText();
    }
}
