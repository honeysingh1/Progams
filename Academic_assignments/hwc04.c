
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
void display();

int main()
{
  input();    // calling input function
  return 0;
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: input
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function accepts the input from the user and sends
*       values to the calculate function
*
***************************************************************************/

void input()
{
  float amount;       // used to store the input value of loan amount
  float rate;         // used to store input value of annual interest rate
  int term;           // used to store input value of the term of loan in years

  printf("Enter the amount to borrow: ");
  scanf("%f", &amount);
  printf("Enter the annual interest rate: ");
  scanf("%f", &rate);
  printf("Enter the term of the loan in years: ");
  scanf("%d", &term);

  calculate(amount, term, rate);      // values passed to calculate function
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: calculate
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. float amt;    // used to receive the value of amount of loan
*       2. int term;     // used to receive value of term of loan in years
*       3. float rate;   // used to receive annual interest rate
*
*     Function Description: This function calculates and prints the monthly installments,
*       interest paid, principal paid, old and the new balance.
*
***************************************************************************/

void calculate(float amt, int term, float rate)
{
  float monthly;        // used to calculate monthly payments done by user
  float interest;       // used to calculate the interest paid 
  float principal;      // used to calculate the principal amount paid
  float newbal;         // used to calculate the new balance amount
  int i;                // used as for loop control variable

  rate /= 1200;         // rate modified on monthly 
  
  display();            // display function called

  monthly = (rate * amt * pow(1 + rate, 12 * term)) / (pow( 1 + rate, 12 * term) - 1); 

  for(i = 1; i <= (12 * term); i++)
  {
    interest = amt * rate;
    principal = monthly - interest;
    newbal = pow( pow((amt - principal), 2), .5);

    printf("%3d", i);
    printf("%11.2f", amt);
    printf("%9.2f", monthly);
    printf("%10.2f", interest);
    printf("%11.2f", principal);
    printf("%9.2f\n", newbal);

    amt = amt - principal;
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: display
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function displays the header of the amortization table.
*
***************************************************************************/

void display()
{
  printf("\nMonth    Old    Monthly  Interest  Principal    New\n");
  printf("       Balance  Payment    Paid      Paid     Balance\n");
  return;
}



