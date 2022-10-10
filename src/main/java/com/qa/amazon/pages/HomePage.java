package com.qa.amazon.pages;

import com.microsoft.playwright.Locator;
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
		Locator openMenuLocator = page.locator(openMenu);
		int counter = 0;
		openMenuLocator.click(new Locator.ClickOptions().setDelay(10).setForce(true));
		while(openMenuLocator.isVisible() && counter < 5){
			if(openMenuLocator.isVisible()){ // double check in order to prevent event conflict which leads to flaky test
				openMenuLocator.click(new Locator.ClickOptions().setDelay(10).setForce(true));
			}
			Thread.sleep(200);
			counter++;
		}
	}
	public CategoriesPage clickHMenuItem(String menuItem){
		page.locator(("text="+menuItem)).click(new Locator.ClickOptions().setDelay(10));
		return new CategoriesPage(page);
	}

}
