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

'Call common test case'
WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('var_username') : var_email, ('var_password') : var_pass], 
    FailureHandling.STOP_ON_FAILURE)

'Click on button Login'
WebUI.click(findTestObject('Home_page/button_dangnhap'))

'Verify with expected from excel file'
switch (var_expected.toString()) {
    case 'invalid':
        'verify warning message display when login with invalid account'
        def errorMess = WebUI.getText(findTestObject('Object Repository/Home_page/warning_message'))

        WebUI.verifyEqual(errorMess.contains('không hợp lệ'), true)
        break
    case 'valid':
		WebUI.waitForElementPresent('Object Repository/Home_page/warning_message', 10)
        println('OK')
        break
}

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    WebUI.openBrowser()
    WebUI.navigateToUrl(GlobalVariable.var_url)
}

@com.kms.katalon.core.annotation.TearDown
def TearDown() {
    WebUI.closeBrowser()
}

