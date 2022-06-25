package com.restful.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.restful.ui.dsl.WebDriverDsl.fillText;
import static com.restful.ui.dsl.WebDriverDsl.waitForNewPageOrModule;

/**
 * @author olufemi
 */
public class TopSearchHeader extends BasePageObject<TopSearchHeader> {

    @FindBy(id = "searchtext_freetext_search_form")
    private WebElement searchInput;

    @FindBy(css = ".nbf_button.nbf_tpl_quicksearch_button")
    private WebElement searchButton;


    public void searchHoliday(String text) {
        fillText(searchInput, text);
        searchButton.click();
    }


    @Override
    public TopSearchHeader waitForPageOrModule() {
        waitForNewPageOrModule(searchInput);
        return this;
    }
}
