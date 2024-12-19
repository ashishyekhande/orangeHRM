@login
Feature: login page
Scenario Outline: testing
Given open orangeHRM site
When login with <User> and <Pass>
Examples: 
      | User  					| Pass 			  | 
      | standard_user 	| secret_sauce|
      | locked_out_user | secret_sauce|
     
