@regression @login
Feature: Testing functionality around logging in

  Background: Navigate to the environment
    Given I have navigated to the correct URL

	
  Scenario: Test able to login successfully
		When I enter nayan24_d@yahoo.co.uk as the Email
		And I enter Password123! as the Password
		And I click the Log In button
		Then my email will be present in the user home page
    
   
  Scenario: Test unable to login when no credentials are entered
		When I click the Log In button
		Then I will get the We didn't recognize that email and/or password. error message
  
  
  Scenario: Test unable to login when no email is entered
		When I enter Password123! as the Password
		And I click the Log In button
		Then I will get the We didn't recognize that email and/or password. error message
  
  
  Scenario: Test unable to login when no password is entered
		When I enter nayan24_d@yahoo.co.uk as the Email
		And I click the Log In button
		Then I will get the We didn't recognize that email and/or password. error message
  
  
  Scenario: Test clicking the logo takes you to the home page
  	When I click the logo icon
  	Then I will be redirected to the Site Home Page
  
  
  Scenario: Test clicking Need help takes you to the login help section
  	When I click the Need help link
  	Then I will be taken to the Login Help section
    
  
  Scenario: Test Log in with organisation takes you to the correct section
		When I click the Log In with an Organization button
  	Then I will be taken to the Log into Hudl with your Organization section