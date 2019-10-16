package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestEmptyFieldsJoinSubmitTC1 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();


    public void testEmptyFormSubmitButton() throws InterruptedException {
        boolean displayed = false;
        WebElement element = rcfi.getDriver().findElement(By.xpath("//*[@id=\"Submit2\"]"));
        ((JavascriptExecutor) rcfi.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);  //scroll to button
        Thread.sleep(500);

        rcfi.getDriver().findElement(By.xpath("//*[@id=\"Submit2\"]")).click();
        displayed = rcfi.getDriver().findElement(By.xpath("//*[@id=\"ContentPlace" +
                "Holder__ctl0__ctl0_ucJoinForm_phErrors\"]")).isDisplayed();
        String msg = rcfi.getDriver().findElement(By.xpath("//*[@id=\"ContentPlace" +
                "Holder__ctl0__ctl0_ucJoinForm_phErrors\"]")).getText();
        System.out.println(msg);
        Assert.assertTrue("Failed, no error message is being displayed", displayed);
    }

    @Test
    public void testEmptyFormSubmit() throws InterruptedException {
        rcfi.startWebDriver();
        Thread.sleep(3000);
        testEmptyFormSubmitButton();
    }
}
