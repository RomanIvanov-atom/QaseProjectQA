package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {

    private static final String CREATE_TEST_CASE_BUTTON = "button#create-case-button";
    private static final String SETTINGS_BUTTON = "//*[@title='Settings']/span";
    private static final String ROW_WITH_THE_LAST_TEST_CASE = "(//*[@id='suitecases-container']//*[@draggable='true']/div)[last()]";
    private static final String CURRENT_PROJECT_CODE_TITLE = "//*[@id='application-content']//h1";

    public void waitTillOpened() {
        $(CREATE_TEST_CASE_BUTTON).shouldBe(visible);
    }

    public void checkThatCurrentProjectCodeEqualsSpecificCode(String projectCode) {
        $x(CURRENT_PROJECT_CODE_TITLE).shouldBe(text(projectCode + " repository"));
    }

    public void openCreateTestCaseModal() {
        $(CREATE_TEST_CASE_BUTTON).click();
    }

    public void checkThatListOfTestCasesContainsSpecificTestCase(String testCaseName) {
        $x(ROW_WITH_THE_LAST_TEST_CASE).shouldHave(text(testCaseName));
    }

    public void openProjectSettings() {
        $x(SETTINGS_BUTTON).click();
    }
}
