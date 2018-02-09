package com.dvla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {
	
	public StartPage(WebDriver driver) {
        super(driver);
     
    }

	@FindBy(css = "a.button") //Identifying by Absolute CSS path
	private WebElement startBtn;	
	
	public  void clickStartBtn(){
		startBtn.click();
	}
	
}
