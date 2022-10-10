package com.qa.amazon.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;

    // 1. String locators

    // 2. Constructor
    public ProductPage(Page page) {
        this.page = page;
    }

    // 3. Page action/methods


    public Locator getAboutThisItem() {
        return page.locator("text=About this item");
    }

    public void logDescription(){ // log 'about this item' section text to console
        String text = page.locator("div[id='feature-bullets']").textContent();
        System.out.println(text);
    }


}
