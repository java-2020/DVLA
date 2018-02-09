package com.dvla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleDetailsPage extends BasePage{
	
	public VehicleDetailsPage(WebDriver driver) {
        super(driver);
     
    }

	//Absolute CSS path object Identification faster than xpath
	@FindBy(css = "span[class='reg-mark']")
	private WebElement vehRegNumber;
	
	@FindBy(css = "li.list-summary-item strong")
	private WebElement vehicleMake;
	
	// /html/body/main/form/div/div/ul/li[3]/span[2]/strong/
	@FindBy(css = "li.list-summary-item:nth-of-type(3) strong")
	private WebElement vehicleColor;

	public String getRegNumber() {
		return vehRegNumber.getText();
	}

	public String getMake() {
		return vehicleMake.getText();
	}

	public String getColor() {
		return vehicleColor.getText();
	}

}
