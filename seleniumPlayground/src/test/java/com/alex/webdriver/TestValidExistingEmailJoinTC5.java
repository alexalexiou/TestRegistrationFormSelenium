package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestValidExistingEmailJoinTC5 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();


    public void testExistingEmail(){
        String message =rcfi.getDriver().findElement(By.xpath("//*[@id=\"joined-message\"]")).getText();
        System.out.println(message);
        boolean msgAlreadyJoined = message.startsWith("YOU'VE ALREADY JOINED OUR TALENT NETWORK");
        /* Assertion for already registered user  */
        Assert.assertTrue(msgAlreadyJoined);
    }

    @Test
    public void testValidExistingEmailRegistration() throws InterruptedException {

        rcfi.startWebDriver();

        rcfi.emailFieldInput("testme112@gmail.com");            //existing email address
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

        testExistingEmail();
    }
}
