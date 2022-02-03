package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyUserCanLogin() {
        WebElement userNameEle = driver.findElement(By.id("user-name"));
        WebElement passwordEle = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userNameEle.sendKeys("standard_user");
        passwordEle.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement homePageLogo = driver.findElement(By.xpath("//div[@class='app_logo']"));
        WebElement homePageTitle = driver.findElement(By.cssSelector(".title"));

        Assert.assertTrue(homePageLogo.isDisplayed(), "Logo is missing from homePage");
        Assert.assertTrue(homePageTitle.isDisplayed(), "Title is missing from homePage");

        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();

        userNameEle = driver.findElement(By.id("user-name"));
        passwordEle = driver.findElement(By.id("password"));

        Assert.assertTrue(userNameEle.isDisplayed(), "userName input is missing from homePage");
        Assert.assertTrue(passwordEle.isDisplayed(), "password input is missing from homePage");

    }

}
