import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.waitForPageLoad(10)

'Click button skip'
WebUI.click(findTestObject('Object Repository/Home_page/button_skip'))

'Mouse over to extend span login'
WebUI.mouseOver(findTestObject('Home_page/span_Login'))

'Click on button Login'
WebUI.click(findTestObject('Home_page/button_Login'))

WebUI.waitForPageLoad(20)

'Enter username'
WebUI.setText(findTestObject('Home_page/input_user'), GlobalVariable.username)

'Enter password'
WebUI.setText(findTestObject('Home_page/input_pass'), GlobalVariable.password)

'Click on button Login'
WebUI.click(findTestObject('Home_page/button_dangnhap'))

WebUI.waitForPageLoad(10)

'Mouse over account after login'
WebUI.mouseOver(findTestObject('Object Repository/Home_page/span_taikhoan'), FailureHandling.STOP_ON_FAILURE)

'Verify title donhangcuatoi is display'
WebUI.verifyElementPresent(findTestObject('Object Repository/Home_page/Donhang_lbl'), 3)

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    WebUI.openBrowser(GlobalVariable.var_url)
}

@com.kms.katalon.core.annotation.TearDown
def TearDown() {
    WebUI.closeBrowser()
}

