Feature: Covert a number into a Roman Numeral

  In order to get the convert a number to a Roman Numeral
  As a user
  I want that the application convert an input into Roman Numeral and return the result


  Rules:
    - The input should a number between 1 and 3999

  Scenario: Number is 1
    Given The number is '1'
    When the application converts the number
    Then the application returns 'I'

  Scenario: Number is 5
    Given The number is '5'
    When the application converts the number
    Then the application returns 'V'

  Scenario: Number is 10
    Given The number is '10'
    When the application converts the number
    Then the application returns 'X'

  Scenario: Number is 20
    Given The number is '20'
    When the application converts the number
    Then the application returns 'XX'

  Scenario: Number is 3999
    Given The number is '3999'
    When the application converts the number
    Then the application returns 'MMMCMXCIX'
