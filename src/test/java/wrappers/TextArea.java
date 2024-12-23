package wrappers;

import org.openqa.selenium.support.ui.Quotes;

import static com.codeborne.selenide.Selenide.$x;

public class TextArea {
    private final String label;

    public TextArea(String label) {
        this.label = label;
    }

    public void write(String text) {
        $x(String.format("//label[contains(text(), %s)]/ancestor::*[contains(@class,'form-group')]" +
                "//div[contains(@class, 'toastui-editor-content') and @contenteditable]", Quotes.escape(label))).setValue(text);
    }
}
