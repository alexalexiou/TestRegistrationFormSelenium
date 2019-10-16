package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class TestLinksTC9 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();

    @Test
    public void testLinks() throws InterruptedException, IOException {
        rcfi.startWebDriver();
        Thread.sleep(5000);
        testPrivacyPolicyLinks();
        testTermsConditionsLink();
    }

    public void testPrivacyPolicyLinks() throws IOException {
        String privacyPolicyURL = rcfi.getDriver().findElement(By.xpath("//*[@id='privacy" +
                "-policy-link']")).getAttribute("href");

        verifyLink("https://www.jobs.net/jobs/intrasoft-intl/en-us/Talen" +
                "tNetwork/Pages/PrivacyPolicy" +
                ".aspx?portable=frame", "https://www.intrasoft-intl.com/careers");
    }


    public void testTermsConditionsLink() throws IOException {
        String termsCondURL = rcfi.getDriver().findElement(By.xpath("//*[@id=\"terms-link\"]")).getAttribute("href");

        verifyLink(termsCondURL, "https://www.intrasoft-intl.com/careers");
    }


    public void verifyLink(String urlLink, String expectedUrl) throws IOException {
        URL link = new URL(urlLink);
        HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
        httpConn.setConnectTimeout(2000);
        httpConn.connect();

        System.out.println(httpConn.getResponseCode());
        String url = httpConn.getURL().toString();
        Assert.assertEquals(expectedUrl, url);


    }


}
