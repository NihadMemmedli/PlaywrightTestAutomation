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
		int counter = 0;
		page.locator(openMenu).click(new Locator.ClickOptions().setDelay(10).setForce(true));
//		Thread.sleep(50); // sometimes menu does not open on time
		while(!page.locator("div#hmenu-customer-name").isVisible() && counter < 5){
			if(page.locator(openMenu).isVisible()){
				page.locator(openMenu).click(new Locator.ClickOptions().setDelay(10).setForce(true));
			}
			Thread.sleep(200);
			counter++;
		}
	}
	public CategoriesPage clickHMenuItem(String menuItem){
		page.locator(("text="+menuItem)).click();
		return new CategoriesPage(page);
	}

}
