
/***************************************************************************
 *
 *  Programmers and Purdue Email Addresses:
 *	 1. singh178@purdue.edu
 *	 2. skishta@purdue.edu
 *	 3. rwidjaj@purdue.edu (delete line if no third partner)
 *
 *  Lab #: 11
 *
 *  Academic Integrity Statement:
 *
 *       We have not used source code obtained from
 *       any other unauthorized source, either modified
 *       or unmodified.  Neither have we provided access 
 *       to our code to another. The project we are submitting
 *       is our own original work.
 *
 *  Lab Division and Section:1801
 *
 *  Program Description: The program gets input in an array of size 2 and 20 and
 *   calculates the merged average.
 *
 ***************************************************************************/
#include<stdio.h>

void input(int);
void sort(int[], int);
void mergeAvg(int[], int);

int main()
{
  int size;     // used to store the size of the array inputted

  printf("Enter set size: ");
  scanf("%d",&size);

  if(size > 20 || size < 2)
  {
    while(size > 20 || size < 2)
    {
      printf("\nError! Enter a value in the 2 to 20 range!\n");
      printf("\nEnter set size: ");
      scanf("%d",&size);
    }
  }
  input(size);
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
*       1. int size;     //receives the size of the array
*
*     Function Description: This function accepts the input for the data elements 
*      of the array.
*
***************************************************************************/

void input(int size)
{
  int array[size];       // array declared and size initialised
  int lcv;               // loop control variable

  for(lcv = 0; lcv < size; lcv++)
  {
    printf("Enter data #%d: ", lcv + 1);
    scanf("%d",&array[lcv]);
  }
  sort(array, size);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: sort
*
*     Programmer's Name: Ryan Widjaja and Samer Kishta
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int array[]     // receives the array with all data elements
*       2. int size        // receives the size of the array
*       
*     Function Description: This function sorts the array in ascending order
*
***************************************************************************/

void sort(int array[], int size)
{
  int lcv;          // loop control variable for the inner loop
  int numPass;      // loop control variable for the outer loop
  int temp;         // used to temporarily hold one data element of the array

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
  mergeAvg(array, size);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: mergeAvg
*
*     Programmer's Name: Samer Kishta
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int array[]    // receives the array with all data elements
*       2. int size       // receives the size of the array
*
*     Function Description: This function calculates the largest average value that 
*      can be possible for the given array (Merged Average)
*
***************************************************************************/

void mergeAvg(int array[], int size)
{
  int lcv = 0;    //used as loop control variable as an index of data elements of the array
  float avg;      // used to store the merged average

  avg = (array[lcv] + array[lcv + 1]) / 2.0;

  for(lcv = 2; lcv < size; lcv++)
  {
    avg = (avg + array[lcv]) / 2.0;
  }
  printf("\nResult: %.2f\n", avg);
}





