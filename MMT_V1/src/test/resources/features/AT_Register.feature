Feature: Register functionality

  Scenario Outline: User register on website
    Given User navigates to home page
    And Home Page is accessed successfully
    When User clicks on User Sign Up button
    And User is able to view to New User SignUp section
    And User enters <name> and <email address>
    And User clicks on Sign Up button
    And User is able to view new user account info page
    And User selects <title>, verifies <name> and <email address>, enters <password>, DOB in <day>,<month>,<year> format
    And User clicks on Sign up for our newsletter!
    And User clicks on Receive special offers from our partners!
    And User fills personal details like <first name>, <last name>, <company>
    And User fills details like <address>, <address2>, <country>, <state>, <city>, <zip code> & <mobile no>
    And User clicks on Create Account button
    Then User should see account created message

Examples:
|name				|email address				|title|password  |day|month|year|first name|last name|company|address|address2|country|state|city|zip code|mobile no|
|TestQA0011	|testqa0011@ymail.com	|Mr		|Testqa0011|1  |1	   |2021|TestQA0011|Automation|Micro|Seventh Avenue|Lower Town|United States|New York|New York|452781|12092981|

