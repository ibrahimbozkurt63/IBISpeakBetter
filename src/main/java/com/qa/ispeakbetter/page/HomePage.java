package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.ispeakbetter.util.ElementUtil;
import com.qa.ispeakbetter.util.JavaScriptUtil;

public class HomePage {

	// Locatars
	// Constructors
	// Page Methods

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructors
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	By duration = By.id("class_duration");
	By subClasses = By.id("package_length");
	By classWeek = By.id("per_week_class_number");
	By program = By.id("course_program");
	By buy = By.id("cmdPurchase");

	By loginBtn = By.xpath("//a[@id='cmdSiginLink']");
	By userName = By.xpath("//input[@id='_email']");
	By password = By.id("_password");
	By login = By.id("cmdSignin");

	public LoginPage clickLogin(String usName, String pwd) {
		elementUtil.doClick(loginBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		elementUtil.doSendKeys(userName, usName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(login);

		return new LoginPage(driver);

	}

	// PageMethods
	public String getTitle() {
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.titleContains("Learn English with Online Teachers - Get your Free Live English Class Now."));
		return title;
	}

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public void BuyProgram() throws InterruptedException {

		JavaScriptUtil.specificScrollPageDown(driver);
		Thread.sleep(3000);
		WebElement durationElement = driver.findElement(duration);
		WebElement subClassesElement = driver.findElement(subClasses);
		WebElement classWeekElement = driver.findElement(classWeek);
		WebElement programElement = driver.findElement(program);
		Select select1 = new Select(durationElement);
		select1.selectByVisibleText("30");

		Thread.sleep(3000);
		Select select2 = new Select(subClassesElement);
		select2.selectByVisibleText("4 weeks");
		Thread.sleep(3000);

		Select select3 = new Select(classWeekElement);
		select3.selectByVisibleText("3 Classes");

		Thread.sleep(3000);
		Select select4 = new Select(programElement);
		select4.selectByVisibleText("Children English");

		driver.findElement(buy).click();

	}

}
