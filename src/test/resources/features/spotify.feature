Feature: Spotify web

  Background:
    Given the user is on the Spotify page
    When the user clicks the login button and enters credentials

  Scenario: Successful login
    Then the user is logged in successfully

  Scenario: Song search
    When the user searches for the desired song
    And the user selects the song and plays it
    Then the selected song matches the searched song
