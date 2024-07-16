Feature: Spotify web login

  @Login
  Scenario: Successful login
    Given the user is on the Spotify page
    When the user clicks the login button and enters credentials
    Then the user is logged in successfully
