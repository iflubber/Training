Feature: Accordion Expand/Collaps
  As a user
  I want to be able to expand an Accordion
  So that other Accordions will collapse
	
  Scenario Outline: Accordions should expand/collapse
    Given the Accordion page is loaded
    When 'Section<n>' is clicked
    Then 'Section1' should <section1>
    Then 'Section2' should <section2>
    Then 'Section3' should <section3>
    Then 'Section4' should <section4>
     

Examples:
|	n	|	section1	|	section2	|	section3	|	section4	|
|	1	|	expand		|	collapse	|	collapse	|	collapse	|
|	2	|	collapse	|	expand		|	collapse	|	collapse	|
|	3	|	collapse	|	collapse	|	expand		|	collapse	|
|	4	|	collapse	|	collapse	|	collapse	|	expand		|
