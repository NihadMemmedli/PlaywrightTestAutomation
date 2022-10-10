package com.qa.amazon.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.qa.amazon.factory.PlaywrightFactory;
import com.qa.amazon.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;

    protected HomePage homePage;


    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) {

        pf = new PlaywrightFactory();

        prop = pf.init_prop();

        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        page = pf.initBrowser(prop);

        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

    @AfterClass
    public void stopTracing() {
        page.context().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }

}
