Feature: Login Feature

  Scenario Outline: Test Login with valid account on TIKI page
    Given Navigate to homepage
    When Navigate to Login popup
    Then Verify Login popup is displayed
    When User enter <username> and <password>
    And Click on Login button
    Then Verify Home page is displayed

    Examples: 
      | username   | password   |
      | 0906229687 | Abc123@123 |
      | 0987423748 | otoke123   |
