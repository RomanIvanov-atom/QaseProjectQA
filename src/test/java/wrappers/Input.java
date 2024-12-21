package wrappers;

import org.openqa.selenium.support.ui.Quotes;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    private final String label;

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        $x(String.format("//label[contains(text(), %s)]/following-sibling::div[1]//input", Quotes.escape(label))).setValue(text);
    }
}
