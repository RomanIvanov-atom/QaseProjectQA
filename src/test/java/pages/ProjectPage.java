package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {

    private static final String CREATE_TEST_CASE_BUTTON = "button#create-case-button";
    private static final String SETTINGS_BUTTON = "//*[@title='Settings']/span";
    private static final String ROW_WITH_THE_LAST_TEST_CASE = "(//*[@id='suitecases-container']//*[@draggable='true']/div)[last()]";
    private static final String CURRENT_PROJECT_CODE_TITLE = "//*[@id='application-content']//h1";

    public ProjectPage waitTillOpened() {
        $(CREATE_TEST_CASE_BUTTON).shouldBe(visible);
        return this;
    }

    public ProjectPage checkThatCurrentProjectCodeEqualsSpecificCode(String projectCode) {
        $x(CURRENT_PROJECT_CODE_TITLE).shouldBe(text(projectCode + " repository"));
        return this;
    }

    public CreateTestCaseModal openCreateTestCaseModal() {
        $(CREATE_TEST_CASE_BUTTON).click();
        return new CreateTestCaseModal();
    }

    public ProjectPage checkThatListOfTestCasesContainsSpecificTestCase(String testCaseName) {
        $x(ROW_WITH_THE_LAST_TEST_CASE).shouldHave(text(testCaseName));
        return this;
    }

    public ProjectSettingsPage openProjectSettings() {
        $x(SETTINGS_BUTTON).click();
        return new ProjectSettingsPage();
    }
}
