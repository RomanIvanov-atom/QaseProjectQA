package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {

    private final String testProjectName = "Test project name";
    private final String testCode = "testCode12";
    private final String testCaseName = "Test case title 123!@#";

    @Test
    public void createProjectAndTestCaseTest() {
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.waitTillOpened();

        projectsPage.clickCreateProject();
        projectsPage.fillCreateProjectFieldsAndSubmit(testProjectName, testCode);
        projectPage.waitTillOpened();
        projectPage.checkThatCurrentProjectCodeEqualsSpecificCode(testCode);
        projectPage.openCreateTestCaseModal();
        createTestCaseModal.waitTillOpened();
        createTestCaseModal.createTestCase(testCaseName, "Draft", "Test case description", "Critical",
                "High", true, "Test case preconditions...", "Test case postconditions...");
        projectPage.waitTillOpened();
        projectPage.checkThatListOfTestCasesContainsSpecificTestCase(testCaseName);

        projectPage.openProjectSettings();
        projectSettingsPage.waitTillOpened();
        projectSettingsPage.deleteCurrentProject();
    }
}
