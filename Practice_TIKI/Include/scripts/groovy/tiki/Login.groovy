import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Navigate to homepage")
	def navigateToHomePage() {
		WebUI.openBrowser("https://tiki.vn/")
		
	}

	@When("Navigate to Login popup")
	def navigateToLoginPopup() {
		WebUI.mouseOver(findTestObject('Home_page/span_Login'))
		WebUI.click(findTestObject('Home_page/button_Login'))
		WebUI.waitForPageLoad(20)
	}
	@Then("Verify Login popup is displayed")
	def verifyLoginPopupIsDisplayed() {
		println ("\n Verify Popup is displayed")
	}
	@When("User enter (.*) and (.*)")
	def enterAccount(String username, String password) {
		WebUI.setText(findTestObject('Home_page/input_user'), username)
		WebUI.setText(findTestObject('Home_page/input_Pass'), password)
	}
	@And("Click on Login button")
	def clickLoginButon() {
		WebUI.click(findTestObject('Home_page/button_dangnhap'))
	}
	@Then("Verify Home page is displayed")
	def verifyHomepageIsDisplayed() {
		println ("\n Verify Home page is displayed")
	}
}