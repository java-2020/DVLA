package com.dvla;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dvla.pages.RegistrationPage;
import com.dvla.pages.StartPage;
import com.dvla.pages.VehicleDetailsPage;
import com.dvla.utils.TestDataProvider;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions  {
	
	
	public StepDefinitions(){
		System.out.println("in StepDefinitions..const");
	}
	WebDriver driver = null;
	public RegistrationPage registrationPage = null;
	public StartPage startPage = null;
	public VehicleDetailsPage vehicleDetailsPage =null;
	
	private void initiatePages(WebDriver driver){
		registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
		startPage = PageFactory.initElements(driver, StartPage.class);
		vehicleDetailsPage = PageFactory.initElements(driver, VehicleDetailsPage.class);
	}
	
	@Before
    public void setUp() {
		String baseUrl = "https://www.gov.uk/get-vehicle-information-from-dvla"; // Change this value to PropertyFile
		//System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","/Users/nageshdarjipati/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		initiatePages(driver);
    }
	
	@After
    public void tearDown() {
        driver.quit();
    }

	

	@Given("^Start DVLA web application with \"(.*)\"$")
	public void launch(String testDataid) throws IOException {
		TestDataProvider.getTestData(testDataid);
		startPage.clickStartBtn();
	}

	@When("^User enters the registration number$")
	public void inputVehicleDetails(DataTable table) {
		registrationPage.inputVehicleDetails(TestDataProvider.testdata.get("Vehicle_Registration"));
	}

	@Then("^Vehicle details are verified$")
	public void verifyVehicleDetails() throws Exception {
		Assert.assertTrue(TestDataProvider.testdata.get("Vehicle_Registration").equals(vehicleDetailsPage.getRegNumber()),"Vehicle Registration Number validation");
		Assert.assertTrue(TestDataProvider.testdata.get("Make").equals(vehicleDetailsPage.getMake()),"Vehicle Make validation");
		Assert.assertTrue(TestDataProvider.testdata.get("Color").equals(vehicleDetailsPage.getColor()),"Vehicle Color validation");
	}

}
