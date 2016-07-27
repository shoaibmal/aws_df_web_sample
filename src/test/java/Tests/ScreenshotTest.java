/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests;

import java.io.File;

import Tests.AbstractBaseTests.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test.
 */
public class ScreenshotTest extends TestBase {

    private final String TEST_URL = "http://www.seleniumhq.org/";

    @Test
    public void testScreenshot() throws InterruptedException {

	Thread.sleep(5000);
	driver.get(TEST_URL);
	Thread.sleep(5000);
	Assert.assertTrue(driver.findElement(By.cssSelector("#header [href='/projects/']")).isDisplayed(),"Project Link is not displayed");
	// This will store the screenshot under /tmp on your local machine
	String screenshotDir = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	screenshot.renameTo(new File(screenshotDir, "device_farm.png"));

    }
}
