Feature: Create opportunity
Scenario: TC001 Edit opportunity

Given Launch the browser and login to the application
And Click on the appLauncher
And Click on the ViewAll
And Click on the Saleslink
And Click on the opportunitylink
And Search for the opportunity
And Click on the Refresh button
And Select the first result
When Click on the Edit button
And Edit the close date to next date
And Edit the stage option
And Edit the delivery option
And Enter the description
Then Click on the Save button
And validate the value
And Close the browser
