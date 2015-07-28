Feature: CharGrouping

    Scenario: char grouping
        When I load the home page
        And I enter a abzuaaissna in the input field
        And I hit the submit button
        Then I should see the a4bins2uz as a result
