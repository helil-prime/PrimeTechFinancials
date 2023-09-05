Feature: Items Management


  @createItem
  Scenario: As a user, I am able to create an item or a service
    Given As an entity user, I am logged in
    And I navigate to Items tab
    When I click on the Add Item button
    And I should be on item input page
    When I provide item information name "Coffee beans", price "1800", unit "pc", and description "very nice coffee mug"
    And I click Save Item button
    Then The Item is added to the Item list table
    And I delete the item
