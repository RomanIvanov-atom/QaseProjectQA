package wrappers;

import org.openqa.selenium.support.ui.Quotes;
import static com.codeborne.selenide.Selenide.$x;

public class PickList {

    private final String label;

    public PickList(String label) {
        this.label = label;
    }

    public void select(String option) {
        $x(String.format("(//label[contains(text(), %s)]/..//input)[1]", Quotes.escape(label))).click();
        $x(String.format("//div[@id='modals']/div[last()]//div[@role='option' and text()=%s]", Quotes.escape(option))).click();
    }
}
