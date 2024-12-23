package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectSettingsPage {

    private static final String DELETE_PROJECT_BUTTON = "//*[@id='application-content']//span[contains(text(),'Delete project')]";
    private static final String DIALOG_WINDOW = "//*[@role='dialog']";
    private static final String CONFIRM_DELETE_PROJECT_BUTTON = DIALOG_WINDOW + "//button/span[contains(text(),'Delete project')]";
    private static final String SUBMIT_SETTINGS_BUTTON = "//button[@type='submit']";

    public ProjectSettingsPage waitTillOpened() {
        $x(SUBMIT_SETTINGS_BUTTON).shouldBe(visible, clickable);
        return this;
    }

    public ProjectsPage deleteCurrentProject() {
        $x(DELETE_PROJECT_BUTTON).click();
        $x(DIALOG_WINDOW).shouldBe(visible);
        $x(CONFIRM_DELETE_PROJECT_BUTTON).click();
        return new ProjectsPage();
    }
}
