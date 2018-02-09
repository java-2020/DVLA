package com.dvla.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	format = {"pretty","html:target/cucumber"},
	glue = "com.dvla",
	features = "classpath:cucumber/DVLA.feature"
		)

public class DVLARunner {
	
}