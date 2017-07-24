Feature: Advantage Store browsing on items

  Scenario: clicking on an item
    Given user is logged in
    When user clicks on an item
    Then he can see the item description