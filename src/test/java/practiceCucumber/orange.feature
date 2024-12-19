@login1
Feature: login page
Scenario Outline: to verify login feature
Given site is open
When user enter <user> and <pass>
Examples: 
		  | user  | pass 			 | 
      | Admin |    admin123| 
      | name2 |     7 		 | 
