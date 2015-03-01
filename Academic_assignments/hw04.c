
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. singh178@purdue.edu
*
*  Homework #: 04
*
*  Academic Integrity Statement:
*
*       I have not used source code obtained from
*       any other unauthorized source, either modified
*       or unmodified.  Neither have I provided access
*       to my code to another. The project I am submitting
*       is my own original work.
*
*  Lab Division and Section: 1801
*
*  Program Description: Given the amount to borrow for a given loan in addition to annual interest rate
*   and term in years, the program calculates and prints the monthly amortization table.
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

void input();
void calculate(float, int, float);

int main()
{
  input();
  return 0;
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function:
*
*     Programmer's Name:
*
*     Function Return Type:
*
*     Parameters (list data type, name, and comment one per line):
*       1.
*       2.
*       3.
*
*     Function Description:
*
***************************************************************************/

void input()
{
  float amount;
  float rate;
  int term;
  printf("Enter the amount to borrow: ");
  scanf("%f", &amount);
  printf("Enter the annual interest rate: ");
  scanf("%f", &rate);
  printf("Enter the term of the loan in years: ");
  scanf("%d", &term);

  calculate(amount, term, rate);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function:
*
*     Programmer's Name:
*
*     Function Return Type:
*
*     Parameters (list data type, name, and comment one per line):
*       1.
*       2.
*       3.
*
*     Function Description:
*
***************************************************************************/

void calculate(float amt, int term, float rate)
{
  float monthly;
  float interest;
  float principal;
  float newbal;
  int i;

  rate /= 1200;

  for(i = 1; i <= (12 * term); i++)
  {
    monthly = (rate * amt * pow( 1 + rate, 12 * term)) / (pow( 1 + rate, 12 * term) - 1);
    interest = amt * rate;
    principal = monthly - interest;
    newbal = amt - principal;

    printf("%2d", i);
    printf("%4.2f", amt);
    printf("%3.2f", monthly);
    printf("%5.2f", interest);
    printf("%5.2f", principal);
    printf("%2.2f", newbal);

    amt = amt - principal;
  }
}




