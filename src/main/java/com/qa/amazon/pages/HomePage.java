package com.qa.amazon.pages;

import com.microsoft.playwright.Page;
public class HomePage {
	private Page page;

	// 1. String locators
	private String openMenu = "[aria-label='Open Menu']"; // Hamburger menu

	// 2. Constructor
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. Page action/methods
	public void openHamburgerMenu() throws InterruptedException {
		page.click(openMenu);
		int counter = 0;
		Thread.sleep(250);
		while(!page.locator("div#hmenu-customer-name").isVisible() && counter < 5){
			page.click(openMenu);
			Thread.sleep(200);
			counter++;
		}
	}
	public CategoriesPage clickHMenuItem(String menuItem){
//		page.locator("a:text('${x}')".replace("${x}", menuItem)).click();
		page.locator(("text="+menuItem)).click();
		return new CategoriesPage(page);
	}

}
