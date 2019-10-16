package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestRequiredFieldsRegistrationTC2 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();


    public void testRegistrationConfirmation(){
        String message =rcfi.getDriver().findElement(By.xpath("//*[@id=\"joined-message\"]")).getText();
        System.out.println(message);
        boolean msgNewUser = message.startsWith("THANKS FOR JOINING OUR TALENT NETWORK");
        /* Assertion for new registered user  */
        Assert.assertTrue(msgNewUser);
    }

    @Test
    public void testRequiredFieldsUserRegistration() throws InterruptedException {

        rcfi.startWebDriver();

        rcfi.emailFieldInput("testme1000@gmail.com");
        Thread.sleep(3000);

        rcfi.locationFieldInput("12241");
        Thread.sleep(1000);

        rcfi.desiredJobFieldInput("Software Engineer");
        Thread.sleep(1000);

        rcfi.policyTermsCheckboxInput();
        Thread.sleep(1000);

        rcfi.uploadDocumentInput(CONSTANTS.PATHTOPDFFILE);
        Thread.sleep(1000);

        rcfi.joinSubmitButtonClick();
        Thread.sleep(1000);

        testRegistrationConfirmation();
    }


}
