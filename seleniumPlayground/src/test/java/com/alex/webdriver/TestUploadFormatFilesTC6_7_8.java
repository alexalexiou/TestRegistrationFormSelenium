package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestUploadFormatFilesTC6_7_8 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();


    public void testRegistrationConfirmation(){
        String message =rcfi.getDriver().findElement(By.xpath("//*[@id=\"joined-message\"]")).getText();
        System.out.println(message);
        boolean msgNewUser = message.startsWith("THANKS FOR JOINING OUR TALENT NETWORK");
        /* Assertion for new registered user  */
        Assert.assertTrue(msgNewUser);
    }

    @Test
    public void testUploadDocumentFormat() throws InterruptedException {

        rcfi.startWebDriver();

        rcfi.emailFieldInput("testme1000@gmail.com");
        Thread.sleep(3000);

        rcfi.locationFieldInput("12241");
        Thread.sleep(1000);

        rcfi.desiredJobFieldInput("Software Engineer");
        Thread.sleep(1000);

        rcfi.policyTermsCheckboxInput();
        Thread.sleep(1000);

        /* replace parameter to "CONSTANTS.PATHTOTXTFILE" for testing txt format files*/
        rcfi.uploadDocumentInput(CONSTANTS.PATHTODOCFILE);
        Thread.sleep(1000);

        rcfi.joinSubmitButtonClick();
        Thread.sleep(1000);

        testRegistrationConfirmation();
    }

}
