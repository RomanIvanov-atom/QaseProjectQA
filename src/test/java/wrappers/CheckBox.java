package wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Quotes;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {

    private final String label;

    public CheckBox(String label) {
        this.label = label;
    }

    public void setChecked(boolean select) {
        SelenideElement checkbox = $x(String.format("//label[contains(text(), %s)]/following-sibling::span/input", Quotes.escape(label)));
        if (checkbox.isSelected() ^ select) {
            checkbox.click();
        }
    }
}
