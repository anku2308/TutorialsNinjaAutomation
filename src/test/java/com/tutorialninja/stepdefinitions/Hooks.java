package com.tutorialninja.stepdefinitions;

import com.opencart.base.ConfigLoader;
import com.opencart.base.DriverSetup;
import com.opencart.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setup() {

        DriverSetup.getDriver();

        DriverSetup.driver.get(
                ConfigLoader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            Thread.sleep(3000); // Wait 3 seconds to view page
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String scenarioName =
                scenario.getName()
                        .replace(" ", "_");

        ScreenshotUtil.captureScreenshot(
                DriverSetup.driver,
                scenarioName);

        DriverSetup.quitDriver();
    }
}