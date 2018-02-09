Feature: Launch DVLA website and check the vehicle registration details

  Scenario: Check the vehicle details
    Given Start DVLA web application with <Vehicle_01>
    When User enters the registration number 
    Then Vehicle details are verified
   

  