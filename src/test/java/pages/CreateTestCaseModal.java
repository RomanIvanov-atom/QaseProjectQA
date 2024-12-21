package pages;

import wrappers.CheckBox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateTestCaseModal {

    private static final String SAVE_BUTTON = "button#save-case";

    public void waitTillOpened() {
        $(SAVE_BUTTON)
                .shouldBe(visible)
                .shouldNotBe(clickable);
    }

    public void createTestCase(String testCaseName, String status, String description, String severity, String priority,
    boolean toBeAutomated, String preConditions, String postConditions) {
        waitTillOpened();
        new Input("Title").write(testCaseName);
        new PickList("Status").select(status);
        new TextArea("Description").write(description);
        new PickList("Severity").select(severity);
        new PickList("Priority").select(priority);
        new CheckBox("To be automated").setChecked(toBeAutomated);
        new TextArea("Pre-conditions").write(preConditions);
        new TextArea("Post-conditions").write(postConditions);
        $(SAVE_BUTTON).click();
    }
}
