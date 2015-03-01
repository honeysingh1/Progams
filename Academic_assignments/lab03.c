
/***************************************************************************
*
*  Programmers and Purdue Email Addresses:
*	 1. singh178@purdue.edu
*	 2. hziegle@purdue.edu
*	 3. hsawyer@purdue.edu 
*
*  Lab #: 03
*
*  Academic Integrity Statement:
*
*       We have not used source code obtained from
*       any other unauthorized source, either modified
*       or unmodified.  Neither have we provided access 
*       to our code to another. The project we are submitting
*       is our own original work.
*
*  Lab Division and Section: 1801
*
*  Program Description: This program calculates and prints the taxable income,
*   the tax rate and tax owed for a given income which user has to input
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

// Global declarations

float getIncome();
float calcRate(float income);
void displayResults(float income, float taxRate);

int main()
{
  float taxRate;  //used to store the tax rate by calling the calc function
  float income;   //used to store the value of income by calling getIncome function

  income = getIncome();
  taxRate = calcRate(income);

  displayResults(income,taxRate);

  return(0);


}


/***************************************************************************
*
*     Function Information
*
*     Name of Function: getIncome
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: float
*
*     Parameters (list data type, name, and comment one per line)
*
*     Function Description: This function gets the input of the income from the user
*
***************************************************************************/

float getIncome()
{
  float income;

  printf("Enter taxable income: ");
  scanf("%f",&income);

  return(income);
}


/***************************************************************************
*
*     Function Information
*
*     Name of Function: calcRate
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: float
*
*     Parameters (list data type, name, and comment one per line):
*       1. float income;  //receives the value for the income the user inputs
*       
*     Function Description: This function receives the income and calculates the applicable
*       rate of tax.
*
***************************************************************************/

float calcRate(float income)
{
  float taxRate;     // this is used to calculate and store the rate of tax applicable
  int ratefactor;    // this is used to calculate a factor which can help define income to be less or more than 65000


  ratefactor = (((int)income / 65000) + 2) % (((int)income / 65000) + 1);
  taxRate = (((int)(income - 65000) / 7500) * .005 + .07) * ratefactor;

  return(taxRate);
}


/***************************************************************************
*
*     Function Information
*
*     Name of Function: displayResults
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. float income;      //this is used to receive the value of income that user inputs
*       2. float taxRate;     //this is used to receive the rate of tax applicable
*
*     Function Description: This function is used to print the results.
*
***************************************************************************/

void displayResults(float income, float taxRate)
{
  float taxOwed;   // it is used to store and calculate the value of the tax owed by the income the user inputs

  taxOwed = income * taxRate;
  printf("\nTaxable Income: $ %.2f\n",income);
  printf("Tax Rate: %.3f", (taxRate * 100));
  printf("%% \n");
  printf("Tax Owed: $ %.2f\n", taxOwed); 
}

  

 
