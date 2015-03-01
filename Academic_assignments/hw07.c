
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. singh178@purdue.edu
*
*  Homework #: 07
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
*  Program Description: The program accepts the input of 25 integers in an array and
*   sorts the array in a nearly ascending order.
*
***************************************************************************/
#include<stdio.h>

#define ARRAYSIZE 25

void input(int[]);
void sort(int[], int);
void nearlySort(int[], int);

int main()
{
  int array[ARRAYSIZE];         //array declared
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
*       1. int array[]      // this receives the declared array of the specified size
*
*     Function Description: This function receives the input for the array and
*      prints the original array.
*
***************************************************************************/

void input(int array[])
{
  int lcv;            // loop control variable
  int temp;           // used to store the length of the array
  for(lcv = 0; lcv < 25; lcv++)
  {
    printf("Enter data #%d or -1 to exit: ", lcv + 1);
    scanf("%d",&array[lcv]);

    if(array[lcv] == -1)
    {
      temp = lcv - 1;
      lcv = 25;
    }
    else
    {
      temp = lcv;
    }
  }
  printf("Original Data: ");

  for(lcv = 0; lcv < temp + 1; lcv++)
  {
    printf("%d ", array[lcv]);
  }
  printf("\n");

  sort(array, temp + 1);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: sort
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1.int array[]      // receives the array with the data elements
*       2.int size         // receives the size of the array
*
*     Function Description: This function uses the binary sort technique used in the notes
*       to sort the array in ascending order.
*
***************************************************************************/

void sort(int array[], int size)
{
  int numPass;          // loop control variable for external loop
  int lcv;              // loop control variable for inner loop
  int temp;             // used to temporarily hold the value of an array element

  for(numPass = 1; numPass < size; numPass++)
  {
    for(lcv = 0; lcv < size - numPass; lcv++)
    {
      if(array[lcv] > array[lcv + 1])
      {
        temp = array[lcv];
        array[lcv] = array[lcv + 1];
        array[lcv + 1] = temp;
      }
    }
  }

  nearlySort(array, size);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: nearlySort
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int array[]      // receives the array with data elements
*       2. int size         // receives the size of the array
*
*     Function Description: This function nearly sorts the array which was already
*      sorted in ascending order.
*
***************************************************************************/

void nearlySort(int array[], int size)
{
  int lcv;          // loop control variable stores the position of last data element
  int temp;         // used to temporarily store the value of array data element

  lcv = size - 1;

  while(lcv > 0)
  {
    if(array[lcv] == array[lcv - 1])
    {
      --lcv;
    }
    else
    {
      temp = array[lcv];
      array[lcv] = array[lcv - 1];
      array[lcv - 1] = temp;
      lcv = 0;
    }
  }
  printf("Final Data: ");

  for(lcv = 0; lcv < size; lcv++)
  {
    printf("%d ", array[lcv]);
  }
  printf("\n");
}


   



