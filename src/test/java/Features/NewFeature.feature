Feature: Register the project

@Login
Scenario: Login to Guru99
Given user launch Chrome Browser
When user opens url
And user clicks on insurance project
Then verify the page title
And click on Register button
Then user enter details
|Mr|sairam|Bellamkonda|8213486997|1939|5|1|1|4|Thoraipakkam|Chennai|India|600097|Demo@123|Demo@123|
When user enter login details
Then user click on login button
And Close the browser


@Webtable
Scenario: Accessing Dynamic WebTable
Given user launch Chrome Browser
When user opens site
And user handles the dynamic webtable
And Close the browser
 
























