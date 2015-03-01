
/***************************************************************************
 *
 *  Programmers and Purdue Email Addresses:
 *	 1. Honey Singh singh178@purdue.edu
 *	 2. Matt Krawczyk mkrawczy@purdue.edu
 *	 3. Zach Brown brownz@purdue.edu 
 *
 *  Lab #: 07 
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
 *  Program Description: Given a positive integer as input, display all unique pairs of prime numbers that 
 *   sum to twice tha valu input.
 *
 ***************************************************************************/
#include<stdio.h>
#include<math.h>

int input();
void calculate(int);
int isPrime(int);

int main()
{
  int quantity;     //used to store the quantity inputted

  quantity = input();
  calculate(quantity);

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
 *     Function Return Type: int
 *
 *     Parameters (list data type, name, and comment one per line):
 *
 *     Function Description: This function is used to input the quantity.
 *
 ***************************************************************************/
int input()
{
  int num;    // used to store the input

  do
  {
    printf("Enter quantity: ");
    scanf("%d", &num);
    printf("\n");
    if(num < 1)
    {
      printf("Invalid Input! Enter a positive integer value!\n\n");
    }
  }
  while(num < 1);

  return num;
}

/***************************************************************************
 *
 *     Function Information
 *
 *     Name of Function: calculate
 *
 *     Programmer's Name: Matt Krawczyk
 *
 *     Function Return Type: void
 *
 *     Parameters (list data type, name, and comment one per line):
 *       1. int num   //this variable receives the value of quantity inputted
 *
 *     Function Description: This function calculates and displays the pairs of prime numbers. 
 *
 ***************************************************************************/
void calculate(int num)
{
  int lcv;     //this is loop control variable
  int counter = 0;    //it counts the number of pairs per line
  if(num == 1)
  {
    printf("No prime pairs found.\n");
  }
  else
  {
    printf("Pairs found: ");
    for(lcv = 2; lcv <= num; lcv++)
    {
      if(isPrime(lcv))
      {
        if(isPrime(num * 2 - lcv))
        {
          printf("[%d, %d] ", lcv, (num * 2 - lcv));
          counter++;
          if(counter % 5 == 0)
          {
            printf("\n");
          }
        }
      }
    }
  }
  printf("\n");
}

/***************************************************************************
 *
 *     Function Information
 *
 *     Name of Function: isPrime
 *
 *     Programmer's Name: Zach Brown
 *
 *     Function Return Type: int
 *
 *     Parameters (list data type, name, and comment one per line):
 *       1. int num    //receives the number which has to be checked for bein prime.
 *
 *     Function Description: This function checks if the number sent is prime or not and returns it.
 *
 ***************************************************************************/
int isPrime(int num)
{
  int lcv;     //loop control variable
  int temp = 1;   //place holder for return statement
  for(lcv = 2; lcv < num; lcv++)
  {
    if(num % lcv == 0)
    {
      temp = 0;
    }
  }
  return temp;
}








