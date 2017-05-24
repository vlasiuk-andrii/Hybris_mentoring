@pickup @all
Feature: Pick up product from store
As a customer
I want to be able to choose store where I want product to pick it up
So that I can specify store and add product to basket

Background:
Given I am an anonymous customer with clear cookies
And I am on product deatils page for product "489702"
And I click on "Pick up in store"
And Product availability PopUp appears

Scenario Outline: Content for location with product in stock is correct
When I select location <LocationName>
Then I see <LocationName>, <Address>, "New York" and "DIGITAL CAMERA EASYSHARE C875" on the right side of the pop up
And I see price "$227.24" and stockLevel <StockLevel>
And I can change product amount
And I select "Add to cart" button

Examples:
| LocationName                        | Address       | StockLevel   |
| Sapporo Hotel Sunroute Sapporo      | 1732 Broadway | 4 IN STOCK   |
| Sapporo Ana Hotel Sapporo           | 1728 Broadway | 15 IN STOCK  |

Scenario: Content for location where product is out of stock is correct
When I select location "Sapporo Hotel Resol Trinity Sapporo"
Then I see "Sapporo Hotel Resol Trinity Sapporo", "1731 Broadway", "New York" and "DIGITAL CAMERA EASYSHARE C875" on the right side of the pop up
And I see price "$227.24" and stockLevel "OUT OF STOCK"
And I can't change product amount
And I can't select "Add to cart" button