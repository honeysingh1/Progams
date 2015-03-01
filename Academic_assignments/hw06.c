
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. Honey Singh singh178@purdue.edu
*
*  Homework #: 06
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
*  Program Description: The program prints the set of friendly numbers.
*
***************************************************************************/

#include<stdio.h>
#include<math.h>

void input();
void friendly(int[]);
void display(int, int, int);

int main()
{
  input();
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
*     Function Description: This function accepts the input for the array.
*
***************************************************************************/

void input()
{
  int integer[10];       // the array declared and initialized
  int lcv;               // loop control variable

  for(lcv = 0; lcv < 10; lcv++)
  {
    printf("Enter data #%d: ", lcv + 1);
    scanf("%d", &integer[lcv]);
  }
  friendly(integer);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: friendly
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int input1[]    // receives the array with the inputted values.
*
*     Function Description: This function checks if the pair of numbers are friendly.
*
***************************************************************************/

void friendly(int input1[])
{
  int lcv;            // loop control variable
  int lcv2;           // loop control variable two
  int num;            // stores the integer at the particular index of array
  int num2;           // stores the integer value at the index of the array
  int num3;           // stores the value of variable num
  int num4;           // stores the value of variable num2
  int counter = 0;    // used to count the number of digits in main integer
  int counter2 = 0;   // used to count the number of digitd in integer being checked
  int counter3 = 0;   // used to count the number of same digits in the two integers
  int count = 0;      // used to count the number of inputs per line
  int digit;          // stores the digits of num
  int digit2;         // stores the digits of num2
  int time = 0;       // used as counter for printing of header

  for(lcv = 0; lcv < 10; lcv++)
  {
    num = input1[lcv];
    num3 = num;
    for(lcv2 = lcv + 1; lcv2 < 10; lcv2++)
    {
      counter = 0;
      counter2 = 0;
      counter3 = 0;

      num2 = input1[lcv2];
      num4 = num2;

      while(num3 > 0)
      {
        digit = num3 % 10;
        counter++;

        while(num4 > 0)
        {
          digit2 = num4 % 10;
          counter2++;

          if(digit2 == digit)
          {
            counter3++;
            num4 = 0;
          }
          num4 = num4 / 10;
        }
        num4 = num2;
        num3 = num3 / 10;
      }

      if(num != 0 && num2 != 0)
      {
        if(counter == counter3 || counter2 == counter3)
        { 
          if(time == 0)
          { 
            ++time;
            printf("Friends: ");
          }
          ++count;
          display(num, num2, count);
        }
      }
      num3 = num;
    }
  }
  printf("\n");
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: display
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int num;         // receives the first integer
*       2. int num2;        // receives the second integer
*       3. int count;       // receives the count of outputs
*
*     Function Description: This function prints the pair of friendly numbers.
*
***************************************************************************/

void display(int num, int num2, int count)
{
  printf("[%d, %d] ", num, num2);
  if(count % 5 == 0)
  {
    printf("\n");
  }
}






