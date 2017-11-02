Feature: Apparel Shopping
  As a regular user
  I want to be able to browse apparels of different types & attributes easily
  So that I get a smooth shopping experience

Background:
	Given the "automationpractice.com" is loaded in browser
  
Scenario: Browse apparels & add to cart
	When the 'T-shirts' category is selected
	Then all available "T-shirts" should get listed
	When the size is selected as 'S'
#	And the color is selected as 'Orange'
#	And the compositions is selected as 'Cotton'
#	And the styles is selected as 'Casual'
#	And I hover over 'Faded Short Sleeve T-shirts'
#	And I select quick view
#	Then the T-shirt detail is loaded
#	When the quantity is increased to 2
#	And the T-shirt is added to cart
#	Then the 'Product successfully added to your shopping cart' message is shown
#	And the cart quantity is 2
#	When the checkout is done
#	Then my shopping cart is updated with 2 products    
