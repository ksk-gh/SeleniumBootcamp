Feature: Accounts feature
Background:
Given Login to the application
And Click on the appLauncher
And Click on the ViewAll
And Click on the Saleslink
And Click on the accountslink

Scenario: TC004 Create Accounts

Given user click on the New button
And Enter the accounts name as 'K.SANKARAKARTHIKEYAN'
And Click on the Ownership textbox
And Select the Ownership option as 'Public'
When Click on the Save button to save the Accounts
Then Validate the accounts snackbar value 'Account "K.SANKARAKARTHIKEYAN" was created.'

Scenario: TC005 Edit Accounts

Given Search for the Accounts as 'K.SANKARAKARTHIKEYAN'
And Click on the Refresh button in the Accounts search
And Select the first result of Accounts
When Click on the Edit button for Account data
And Click on the Type dropdown
And Select type option as 'Technology Partner'
And Click on the Industry dropdown
And Select the industry option as 'Healthcare'
And Enter the Billing street as 'BHEL Nagar'
And Enter the Billing City as 'Trichy'
And Enter the Billing zipcode as '620016'
And Enter the Billing State as 'Tamilnadu'
And Enter the Billing Country as 'India'
And Enter the Shipping street as 'BHEL Nagar'
And Enter the Shipping City as 'Trichy'
And Enter the Shipping zipcode as '620016'
And Enter the Shipping State as 'Tamilnadu'
And Enter the Shipping Country as 'India'
And Click on the Priority dropdown
And Select the Priority Option as 'Low'
And Click on the SLA Dropdown
And Select the SLA option as 'Silver'
And Click on the Active dropdown
And Select the Active option as 'No'
And Enter the Mobile Number as '(952)451-6666'
Then Click on the Save button to save the Accounts
And Validate the accounts snackbar value 'Account "K.SANKARAKARTHIKEYAN" was saved.'

Scenario: TC006 Delete Accounts

Given Search for the Accounts as 'K.SANKARAKARTHIKEYAN'
And Click on the Refresh button in the Accounts search
And Select the first result of Accounts
When User Clicked the Delete button
And Accepts the Delete
Then Validate the 'No items to display.' text message

