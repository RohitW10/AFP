Feature: Login functionality

Scenario Outline: User login with valid email id & valid password
Given User navigates to home page
And Home Page is accessed successfully
When User clicks on Signup / Login with Email button
And Verify "Login to your account" message is visible
And User enters valid email address <email> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in

Examples:
|email								|password	 |
|testqa0012@ymail.com	|Testqa0012|


#Scenario Outline: User login with invalid email id & valid password
#Given User navigates to home page
#And Home Page is accessed successfully
#When User clicks on Signup / Login with Email button
#And Verify "Login to your account" message is visible
#And User enters invalid email address <email> into email field
#And User enters valid password <password> into password field
#And User clicks on Login button
#Then User should view "Your email or password is incorrect!" error message
#
#Examples:
#|email									|password	 |
#|testqa0012345@ymail.com	|Testqa0012|
#
#Scenario Outline: User login with valid email id & invalid password
#Given User navigates to home page
#And Home Page is accessed successfully
#When User clicks on Signup / Login with Email button
#And Verify "Login to your account" message is visible
#And User enters valid email address <email> into email field
#And User enters invalid password <password> into password field
#And User clicks on Login button
#Then User should view "Your email or password is incorrect!" error message
#
#Examples:
#|email								|password	 		|
#|testqa0012@ymail.com	|Testqa0012345|
#
#Scenario Outline: User login with invalid email id & invalid password
#Given User navigates to home page
#And Home Page is accessed successfully
#When User clicks on Signup / Login with Email button
#And Verify "Login to your account" message is visible
#And User enters invalid email address <email> into email field
#And User enters invalid password <password> into password field
#And User clicks on Login button
#Then User should view "Your email or password is incorrect!" error message
#
#Examples:
#|email								|password	 		|
#|testqa0012345@ymail.com	|Testqa0012345|