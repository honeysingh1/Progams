
/***************************************************************************
 *
 *  Programmer and Purdue Email Address:
 *  1. Honey Singh singh178@purdue.edu
 *
 *  Homework #: 05
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
 *  Program Description: Given four integers as input, the program decrypts the three
 *    characters that they represent.
 *
 ***************************************************************************/
#include<stdio.h>

void input();
void validation(int, int, int, int);
void output(int, int, int);

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
 *     Function Description: This function takes the inputs from the user and validates it.
 *
 ***************************************************************************/
void input()
{
  int value1;       // stores the first input
  int value2;       // stores the second input
  int value3;       // stores the third input
  int value4;       // stores the fourth input

  printf("Enter encrypted value #1: ");
  scanf("%d", &value1);
  printf("Enter encrypted value #2: ");
  scanf("%d", &value2);
  printf("Enter encrypted value #3: ");
  scanf("%d", &value3);
  printf("Enter encrypted value #4: ");
  scanf("%d", &value4);

  if(value3 < value1 || value4 < value2)
  {
    printf("\nUnable to calculate integer values.\n");
  }
  else
  {
    validation(value1, value2, value3, value4);
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: validation
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int value1;      // receives the value of input 1
*       2. int value2;      // receives the value of input 2
*       3. int value3;      // receives the value of input 3
*       4. int value4;      // receives the value of input 4
*
*     Function Description: This function checks the values of the integers, whether if
*      they are alphanumeric or not.
*
***************************************************************************/

void validation(int value1, int value2, int value3, int value4)
{
  int integ1;         // used to store value of integer 1
  int integ2;         // used to store value of integer 2
  int integ3;         // used to store value of integer 3

  integ1 = (value3 - value1) / 2;
  integ2 = (value4 - value2) / 2;
  integ3 = value1 + integ1;

  if((integ1 > 47 && integ1 < 58) || (integ1 > 64 && integ1 < 91) || (integ1 > 96 && integ1 < 123))
  {
    if((integ2 > 47 && integ2 < 58) || (integ2 > 64 && integ2 < 91) || (integ2 > 96 && integ2 < 123))
    {
      if((integ3 > 47 && integ3 < 58) || (integ3 > 64 && integ3 < 91) || (integ3 > 96 && integ3 < 123))
      {
        output(integ1, integ2, integ3);
      }
    }
  }
  else
  {
    printf("\nOne or more values does not represent an alphanumeric character!\n");
  }    
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: output
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int integ1;     //receives the value of integer 1
*       2. int integ2;     //receives the value of integer 2
*       3. int integ3;     //receives the value of integer 3
*
*     Function Description: This function prints the value of the integers in character form.
*
***************************************************************************/

void output(int integ1, int integ2, int integ3)
{
  printf("\nDecrypted characters: %c %c %c\n", (char)integ3, (char)integ1, (char)integ2);
}
