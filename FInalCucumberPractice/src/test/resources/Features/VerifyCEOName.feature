Feature: Verify CEO Name
Scenario Outline: Go to the Directory Page and Verify the CEO
Given User in the Dashboard Page
When User navigates to Directory Page
And user search as "Chief Executive Officer" as Job_Title
Then the user should see the "<CEO_Name>" as below
Examples:
|CEO_Name|
|John Smith|