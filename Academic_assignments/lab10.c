
/***************************************************************************
 *
 *  Programmers and Purdue Email Addresses:
 *	 1. singh178@purdue.edu
 *	 2. skishta@purdue.edu
 *	 3. rwidjaj@purdue.edu
 *
 *  Lab #:10
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
 *  Program Description: The program asks for input in an array and checks if the 
 *   integers in the array are valid or invalid and prints them.
 *
 ***************************************************************************/
#include<stdio.h>
#include<math.h>

#define ARRAYSIZE 10

void input(int[]);
void checkValid(int[]);
int odd(int);
void check(int[]);

int main()
{
  int array[ARRAYSIZE];        //array declared
  input(array);
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
 *       1. int array[]   //this receives the array called from the main function
 *
 *     Function Description: This function asks the user for input.
 *
 ***************************************************************************/

void input(int array[])
{
  int lcv;              //loop control variable

  for(lcv = 0;lcv < ARRAYSIZE;lcv++)
  {
    printf("Enter data #%d: ",lcv + 1);
    scanf("%d", &array[lcv]);
  }
  checkValid(array);
}

/***************************************************************************
 *
 *     Function Information
 *
 *     Name of Function: checkValid
 *
 *     Programmer's Name: Samer  
 *
 *     Function Return Type: void
 *
 *     Parameters (list data type, name, and comment one per line):
 *       1. int array[]     //this receives the array with the inputted values
 *
 *     Function Description: This function checks if the integers in the array are valid
 *      or invalid and prints the same.
 *
 ***************************************************************************/

void checkValid(int array[])
{
  int invalid[ARRAYSIZE] = {0};        // this array stores the invalid integers
  int lcv;                      // loop control variable
  int lcv2 = 0;                 // counter variable
  int num;                      // used to store a single element of the array at a time
  int num2;                     // used to temporarily store the value of num
  int val;                      // used to store the single digit of integer num
  int newval;                   // stores the value of val for the first check of odd digit in the integer
  int foundodd = 0;             // used as flag to check occurrence of odd digits in the integer
  int counter = 0;              // used to count number of odd digits in the integer
  int counter2 = 0;             // used to count the occurrence of single odd digit in the integer
  int time = 0;                 // a counter to check printing 

  for(lcv = 0;lcv < ARRAYSIZE;lcv++)
  {
    counter = 0;
    foundodd = 0;
    counter2 = 0;

    num = array[lcv];
    num2 = num;
    while(num > 0)
    {
      val = num % 10;
      if(odd(val))
      {
        if(foundodd == 0)
        {
          foundodd = 1;
          newval = val;
        }
        if(val != newval)
        {
          counter++;
        }
        else
        {
          if(val == newval)
          {
            counter2++;
          }
        }
      }
      num /= 10;
    }
    if(counter == 0)
    {
      if(counter2 >= 2)
      {  
        if(time == 0)
        {
          time++;
          printf("\nValid Values: ");
        }
        printf("%d ", num2);
      }
      else
      {
        if(invalid[lcv] != num2)
        {
          invalid[lcv2++] = num2;
        }
      }
    }
    else
    {
      invalid[lcv2++] = num2;
    }
  }
  check(invalid);
  printf("\n");
}

/***************************************************************************
 *
 *     Function Information
 *
 *     Name of Function: odd
 *
 *     Programmer's Name: Ryan
 *
 *     Function Return Type: int
 *
 *     Parameters (list data type, name, and comment one per line):
 *       1. int val    //receives the digit to checked for being odd
 *
 *     Function Description: This function checks if the received digit is odd.
 *
 ***************************************************************************/

int odd(int val)
{
  if(val % 2 != 0)
  {
    return 1;
  }
  else
  {
    return 0;
  }
}

/***************************************************************************
 *
 *     Function Information
 *
 *     Name of Function: check
 *
 *     Programmer's Name: Honey Singh
 *
 *     Function Return Type:void
 *
 *     Parameters (list data type, name, and comment one per line):
 *       1. int invalid[]     //receives the array of invalid values
 *
 *     Function Description: This function checks if the invalid values array
 *      is null, else prints the array.
 *
 ***************************************************************************/

void check(int invalid[])
{
  int lcv;     //loop control variable
  if(invalid[1] != 0)
  {
    printf("\nInvalid Values: ");
  }
  for(lcv = 9;lcv >= 0; lcv--)
  {
    if(invalid[lcv] != 0)
    {
      printf("%d ", invalid[lcv]);
    }
  }
}





