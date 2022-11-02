Feature: Opportunity feature
Background:
Given Login to the application
And Click on the appLauncher
And Click on the ViewAll
And Click on the Saleslink
And Click on the opportunitylink

Scenario: TC001 Create opportunity


Given user click on the New button
And Enter the opportunity name as 'Avengers'
And Click on the Todaydate
And Click on the Stage option
When Click on the Save button
Then Verify the snackbar value 'Opportunity "Avengers" was created.'

Scenario: TC002 Edit opportunity


Given Search for the opportunity as 'Avengers'
And Click on the Refresh button
And Select the first result
When Click on the Edit button
And Edit the close date to next date
And Edit the stage option
And Edit the delivery option
And Enter the description
Then Click on the Save button
And Validate the snackbar value as 'Opportunity "Avengers" was saved.'

Scenario: TC003 Search and Delete opportunity

Given Search for the opportunity as 'Avengers'
And Click on the Refresh button
And Select the first result
When Click on the Delete button
And Accept the confirmation message to Delete the opportunity
Then Validate the 'No items to display.' text message