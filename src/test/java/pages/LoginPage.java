package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final static String USER = "[name=email]";
    private final static String PASSWORD = "[name=password]";
    private final static String SIGN_IN_BUTTON_TEXT = "Sign in";
    private final static String SUBMIT_BUTTON = "//button[@type='submit']";

    public LoginPage openPage() {
        open("login");
        $x(SUBMIT_BUTTON).shouldBe(visible, clickable);
        return this;
    }

    public ProjectsPage login(String login, String password) {
        $(USER).setValue(login);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN_BUTTON_TEXT)).click();
        return new ProjectsPage();
    }
}
