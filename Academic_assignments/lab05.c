
/**************************************************************************
*
*  Programmers and Purdue Email Addresses:
*         1. Zach Brown brownz@purdue.edu
*         2. Honey Singh singh178@purdue.edu
*         3. Matt Krawczyk mkrawczy@purdue.edu
*
*  Lab #: 05
*
*  Academic Integrity Statement:
*
*       We have not used source code obtained from
*       any other unauthorized source, either modified
*       or unmodified.  Neither have we provided access 
*       to our code to another. The project we are submitting
*       is our own original work.
*
*  Lab Division and Section: 18/1
*
*  Program Description: Calculate how much user can borrow and how to manage the loan.
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

//Function declarations
int dispOps();
void monthPay();
void maxPurch();
void remBal();

int main()
{
  int option;   // used to store user's option selection
  
  option = dispOps();

  switch (option)    //used for calling the correct function according to user's choice
  {
    case 1: monthPay();
            break;
    case 2: maxPurch();
            break;
    case 3: remBal();
  }

  return(0);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: dispOps
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function displays the options of the program and returns 
*       the user's selection.

***************************************************************************/

int dispOps()
{
  int opt;    //used for input of option

  printf("Select one of the following:\n\n");
  printf("1. Calculate monthly payment.\n");
  printf("2. Determine maximum purchase.\n");
  printf("3. Calculate remaining balance.\n");

  printf("\nEnter your option: ");
  scanf("%d", &opt);
  printf("\n");

  return(opt);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: monthPay
*
*     Programmer's Name: Zach Brown
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function calculates the monthly payment for a loan
*       according to the credit score.
*
***************************************************************************/

void monthPay()
{
  int credit;           // User's credit score
  int loan;             // Amount of loan
  int home;             // Value of home
  float rate;           // Annual interest rate of the loan
  int term;             // Term of the loan in years
  float monthly = 0;    // Loan's monthly payment

  printf("Enter your credit score: ");
  scanf("%d", &credit);
  printf("Enter your loan amount: ");
  scanf("%d", &loan);
  printf("Enter the value of the home: ");
  scanf("%d", &home);
  printf("Enter the annual interest rate of the loan: ");
  scanf("%f", &rate);
  printf("Enter the term of the loan in years: ");
  scanf("%d", &term);

  rate /= 12;
  rate /= 100;

  if (credit >= 730)
  {
    monthly = ( rate + ( rate / ( pow( ( 1 + rate), 12 * term) - 1))) * loan; 
  }
  
  if (credit < 730 && credit > 600)
  {
    if ( (float) loan / home <= .8 )      // condition checked if modified loan is required
    {
      monthly = ( rate + ( rate / ( pow( ( 1 + rate), 12 * term) - 1))) * loan;
    }
    else
    {
      monthly = ( rate + ( rate / ( pow( ( 1 + rate), 12 * term) - 1))) * loan * .8 + .2 * ((rate + 2. / 1200) + ((rate + 2. / 1200) / (pow((1 +(rate + 2. / 1200)), 12 * (term - 10)) - 1))) * loan;     // calculates monthly payment for modified loan

    }
  }
  if(credit <= 600)
  {
    if ((float) loan / home <= .8 )       // checks if loan conditions have been modified
    {
      monthly = ( rate + ( rate / ( pow((1 + rate), (12 * term)) - 1))) * loan * .8 + .2 * ((rate + 2. / 1200) + ((rate + 2. / 1200) / (pow( (1 + (rate + 2. / 1200)), 12 * (term - 10)) - 1))) * (loan);      // calculates the monthly payment for modified loan
      
    }
    else
    {
      printf("Denied Loan\n\n");
    }
  }

  if (monthly > 0)
  {
    printf("Monthly Payment: $%.2f\n\n", monthly);
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: maxPurch
*
*     Programmer's Name: Matt Krawczyk
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function determines if a user is eligible to obtain a loan 
*        and if so what the maximum loan amount would be.
*
***************************************************************************/

void maxPurch()
{
  int credit;       // User's Credit Score
  float rate;       // Annual interest rate for loan
  int term;         // Term of loan in years
  float monthly;    // User's desired monthly payment
  float maxloan;    // Maximum loan amount

  printf("Enter your credit score: ");
  scanf("%d", &credit);

  if (credit < 730)
  {
    printf("\nBased on your input you are not eligilbe for a loan.\n");
  }
  else
  {
    printf("Enter the term of the loan in years: ");
    scanf("%d", &term);
    printf("Enter the annual interest rate of the loan: ");
    scanf("%f", &rate);
    printf("Enter desired monthly payment: ");
    scanf("%f", &monthly);

    maxloan = monthly / ((rate / 1200) + ( (rate / 1200) / ( pow( ( 1 + (rate / 1200)), 12 * term) - 1)));   // maximum loan amount calculated

    printf("\nMaximum Loan: ");
    printf("$%.2f\n", maxloan);
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: remBal
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function calculates the remaining balance of a loan
*       assuming it to be a traditional loan.
*
***************************************************************************/

void remBal()
{
  int term;       // Term of the loan in years
  float rate;     // Annual interest rate of the loan
  int loan;       // Amount of loan
  int numpay;     // Number of Payments made
  float monthly;  // Loan's monthly payment
  float rembal;   // Loan's remaining balance

  printf("Enter the term of the loan in years: ");
  scanf("%d", &term);
  printf("Enter the annual interest rate of the loan: ");
  scanf("%f", &rate);
  printf("Enter number of payments made: ");
  scanf("%d", &numpay);
  printf("Enter original loan amount: ");
  scanf("%d", &loan);

  rate = rate / 1200;   // monthly rate
  monthly = (rate + rate / (pow( ( 1 + rate), 12 * term) - 1)) * loan;      // calculates the monthly payment of loan
 
  rembal = loan * pow((1 + rate), numpay) - monthly * ((pow((1 + rate), numpay) - 1) / rate);  // calculates the remaining balance of the loan

  printf("\nRemaining Balance: ");
  printf("$%.2f\n", rembal);
}
