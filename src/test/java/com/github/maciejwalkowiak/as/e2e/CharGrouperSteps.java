package com.github.maciejwalkowiak.as.e2e;

import com.github.maciejwalkowiak.as.Application;
import cucumber.api.java8.En;
import org.fluentlenium.adapter.FluentTest;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = Application.class,
    loader = SpringApplicationContextLoader.class
)
@WebIntegrationTest
public class CharGrouperSteps extends FluentTest implements En {
    private WebDriver webDriver = new FirefoxDriver();

    private HomePage homePage;

    public CharGrouperSteps() {
        homePage = createPage(HomePage.class);

        Given("I load the home page", () -> goTo(homePage));

        And("I enter a (.+) in the input field", homePage::fillUngrouped);

        And("I hit the submit button", homePage::submitForm);

        Then("I should see the (.+) as a result", (String result) -> assertThat(homePage.getResult()).isEqualTo(result));

        After(scenario -> {
            webDriver.close();
        });
    }

    @Override
    public WebDriver getDriver() {
        return webDriver;
    }
}
