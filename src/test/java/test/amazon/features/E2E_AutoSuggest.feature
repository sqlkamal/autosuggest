@e2e @autosuggest @amazon @smoke @regression
Feature: E2E_AutoSuggest

  Scenario Outline: Validate user selects random product from autosuggest list based on the products search
    Given user is on homepage
    Then user searches for the product "<product>"
    Then user validates autosuggest list against search "<product>" and RestAPI response
    Then user selects random product from autosuggest list

    Examples: 
      | product |
      | watch   |