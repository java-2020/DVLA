package com.dvla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected String baseUrl = "https://www.gov.uk/get-vehicle-information-from-dvla";
	
	protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement find(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    
    public void visit(String url) {
        driver.get(url);
    }

  
}
