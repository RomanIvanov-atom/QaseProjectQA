package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private static final String CREATE_NEW_PROJECT_TITLE = "Create new project";
    private static final String PROJECT_NAME_FIELD = "#project-name";
    private static final String PROJECT_CODE_FIELD = "#project-code";
    private static final String MODAL_HEADER = "#modal-header";
    private static final String IS_PUBLIC_RADIOBUTTON = "//*[@id='modals']//*[@value='public']";
    private static final String SUBMIT_BUTTON = "//*[@id='modals']//*[@type='submit']";

    public void openPage() {
        open("projects");
    }

    public ProjectsPage waitTillOpened() {
        $(byText(CREATE_NEW_PROJECT_TITLE)).shouldBe(visible, clickable);
        return this;
    }

    public ProjectsPage clickCreateProject() {
        $(byText(CREATE_NEW_PROJECT_TITLE)).click();
        $(MODAL_HEADER).shouldBe(visible);
        return this;
    }

    public ProjectPage fillCreateProjectFieldsAndSubmit(String projectName, String projectCode) {
        $(PROJECT_NAME_FIELD).setValue(projectName);
        $(PROJECT_CODE_FIELD).setValue(projectCode);
        $x(IS_PUBLIC_RADIOBUTTON).click();
        $x(SUBMIT_BUTTON).click();
        return new ProjectPage();
    }
}
