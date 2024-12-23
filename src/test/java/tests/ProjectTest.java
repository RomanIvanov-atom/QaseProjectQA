package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {

    private final String testProjectName = "Test project name";
    private final String testCode = "testCode12";
    private final String testCaseName = "Test case title 123!@#";

    @Test
    public void createProjectAndTestCaseTest() {
        loginPage.openPage()
                .login(login, password)
                .waitTillOpened()
                .clickCreateProject()
                .fillCreateProjectFieldsAndSubmit(testProjectName, testCode)
                .waitTillOpened()
                .checkThatCurrentProjectCodeEqualsSpecificCode(testCode)
                .openCreateTestCaseModal()
                .waitTillOpened()
                .createTestCase(testCaseName, "Draft", "Test case description", "Critical", "High",
                        true, "Test case preconditions...", "Test case postconditions...")
                .waitTillOpened()
                .checkThatListOfTestCasesContainsSpecificTestCase(testCaseName)
                .openProjectSettings()
                .waitTillOpened()
                .deleteCurrentProject();
    }
}
