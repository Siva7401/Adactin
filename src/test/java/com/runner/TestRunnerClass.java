package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags= {"@pages"}, snippets=SnippetType.CAMELCASE,strict = true, dryRun=false, plugin= {"pretty","json:\\target\\cucumber.json"},monochrome=true,features ="src\\test\\resources",glue="com.stepdefinition")

public class TestRunnerClass extends BaseClass{
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMreport(System.getProperty("user.dir") + "\\cucumber.json");


	}
	
	
	
}
