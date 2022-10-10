package com.qa.amazon.tests;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.pages.CategoriesPage;
import com.qa.amazon.pages.ProductPage;
import com.qa.amazon.pages.ResultsPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.qa.amazon.constants.AppConstants.HIGH_TO_LOW;
import static com.qa.amazon.constants.AppConstants.TV_APPLIANCES_ELECTRONICS;

public class SampleTest extends BaseTest {

	@Test()
	public void searchTest() throws InterruptedException {
		homePage.openHamburgerMenu();

		homePage.clickHMenuItem(TV_APPLIANCES_ELECTRONICS);

		CategoriesPage categoriesPage = homePage.clickHMenuItem("Televisions");

		ResultsPage resultsPage = categoriesPage.filterBy("Samsung");

		resultsPage.sortBy(HIGH_TO_LOW);

		ProductPage productPage = resultsPage.clickNthResult(2);

		assertThat(productPage.getAboutThisItem()).isVisible();

		productPage.logDescription();
	}

}
