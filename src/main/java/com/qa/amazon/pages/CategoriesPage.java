package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class CategoriesPage {
    private Page page;

    // 1. String locators

    // 2. Constructor
    public CategoriesPage(Page page) {
        this.page = page;
    }

    // 3. Page action/methods
    public ResultsPage filterBy(String item){
        page.locator("li:has-text(\"${x}\") span a".replace("${x}", item)).click();
        return new ResultsPage(page);
    }
}
