package com.qa.amazon.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ResultsPage {
    private Page page;

    // 1. String locators
    private String sortBy = "[aria-label=\"Sort by\\:\"]";

    // 2. Constructors
    public ResultsPage(Page page) {
        this.page = page;
    }

    // 3. Methods/Actions
    public void sortBy(String menuItem) throws InterruptedException {
        int counter = 0;

        Locator elem = page.locator("a:has-text(\"${x}\")".replace("${x}", menuItem));

        while (!elem.isVisible() && counter < 10){
            // sometimes from first click, dropdown menu does not appear for doing sorting operation
            page.locator(sortBy).click();
            counter++;
            Thread.sleep(100);
        }

        elem.click();

    }

    public ProductPage clickNthResult(Integer index){
        // click nth product from result and wait to open new tab
        Page newTab = page.waitForPopup(() -> {
            page.locator("[data-image-index='${x}']".
                    replace("${x}", String.valueOf(index))).click();
        });
        return new ProductPage(newTab);
    }
}
