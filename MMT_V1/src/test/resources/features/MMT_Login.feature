Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User clicks on Sign In with Email button
When User enters valid email address <username> into email field
And User clicks on Continue
And User enters valid password <password> into password field
And User clicks on Continue
And User clicks on Login button
And User enters received OTP and clicks Login
Then User should get successfully logged in
Examples:
|username								|password	|
|rohit999waingankar@gmail.com	|MMTitb@62644		|