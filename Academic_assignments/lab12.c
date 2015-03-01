
/***************************************************************************
*
*  Programmers and Purdue Email Addresses:
*	 1. singh178@purdue.edu
*	 2. skishta@purdue.edu
*	 3. rwidjaj@purdue.edu
*
*  Lab #: 12
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
*  Program Description: This program dtermines the rank of a given value entered
    by the user in a given data set of maximum 1000 elements.
*
***************************************************************************/
#include<stdio.h>

#define ARRAYSIZE 1000

void input(int[]);
void sort(int[], int);
void limit(int[], int);

int main()
{
  int array[ARRAYSIZE];        // array declared and size initialized
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
*       1. int array[];    // receives the declared array from main
*
*     Function Description: This function accepts the input for the array.
*
***************************************************************************/

void input(int array[])
{
  int size = 0;       //used as counter to measure the size of the array

  printf("Enter data or -1 to exit: ");
  do
  {
    scanf("%d",&array[size++]);
  }while(array[size - 1] != -1);
  
  sort(array, --size);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: sort
*
*     Programmer's Name: Ryan Widjaja 
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int array[];      // receives the array with the data elements
*       2. int size;         // receives the size of the array
*
*     Function Description: This function sorts the array in descending order.
*
***************************************************************************/

void sort(int array[], int size)
{
  int lcv;          // loop control variable for inner loop
  int numPass;      // loop control variable for outer loop
  int temp;         // used to temporarily store a data element for exchange

  for(numPass = 1; numPass < size; numPass++)
  {
    for(lcv = 0; lcv < size - numPass; lcv++)
    {
      if(array[lcv] < array[lcv + 1])
      {
        temp = array[lcv];
        array[lcv] = array[lcv + 1];
        array[lcv + 1] = temp;
      }
    }
  }
  limit(array, size);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: limit
*
*     Programmer's Name: Samer Kishta
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int array[];    // receives the intialized array
*       2. int size;       // receives the size of the array
*
*     Function Description: This function asks for the size limit and value to be
*      searched as input. Then, it searches the value within the limit and prints
*      the rank.
*
***************************************************************************/

void limit(int array[], int size)
{
  int lim;       // used to store the input value for limit
  int lcv;       // loop control variable
  int value;     // used to store the input value of integer to be searched
  int temp;      // used to temporarrily store the value of loop control variable

  printf("Enter list size limit: ");
  scanf("%d",&lim);

  printf("Enter value to seek: ");
  scanf("%d",&value);

  for(lcv = 0; lcv < lim; lcv++)
  {
    if(array[lcv] == value)
    {
      temp = lcv + 1;

      printf("\nRank: %d\n", temp);

      lcv = lim + 1;
    }
    else
    {
      if(lcv + 1 >= lim)
      {
        printf("\nDesired value (%d) not found within the limit (%d).\n", value, lim);
      }
    }
  }
}












