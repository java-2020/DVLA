package com.dvla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
        super(driver);
        visit(baseUrl + "/");
    }
	
	//Absolute CSS path object Identification faster than xpath
	@FindBy(css = "input#Vrm") 
	private WebElement registrationNumber;
	
	@FindBy(css = "button[name='Continue']")
	private WebElement continueBtn;

	public  void inputVehicleDetails(String regNumber){
		registrationNumber.sendKeys(regNumber);
		continueBtn.click();
	}

}
