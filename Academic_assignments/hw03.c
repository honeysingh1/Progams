
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. singh178purdue.edu
*
*  Homework #: 03
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
*  Program Description: Given the value of time seen as reflected on a wall and inputted 
*    by the user, calculate and print the actual time.
*
***************************************************************************/

#include<stdio.h>

int inputHour();
int inputMinutes();
void calc(int, int);
void displayActual(int, int);
void displayReflected(int, int);

int main()
{
  int hour;      //this stores the value of the hour of the reflected time by calling the specified function
  int minutes;   //this stores the value of the minutes of the reflected time by calling the specified functiom

  hour = inputHour();
  minutes = inputMinutes();
  calc(hour, minutes);

  return (0);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: inputHour
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function is used to input the hour part of the
*       reflected time.
*
***************************************************************************/

int inputHour()
{
  int hour;     //this is used to store the input value of the hou of the reflected time

  printf("Enter the observed hour value: ");
  scanf("%d", &hour);
  
  return (hour);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: inputMinutes
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function is used to input the minutes part of
*       the reflected time.
*
***************************************************************************/

int inputMinutes()
{
  int minutes;     //this is used to store the input value of the minutes of reflected time
  
  printf("Enter the observed minute value: ");
  scanf("%d", &minutes);

  return minutes;
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: calc
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int hour;      //this is used to receive the value of the hour part of reflected time
*       2. int minutes;   //this is used to receive the value of the minutes part of reflected time
*
*     Function Description: This function calculates the actual time from the
*       values of reflected time.
*
***************************************************************************/

void calc(int hour, int minutes)
{
  int new_hour;      //this is used to store the value of hour for the actual time calculated from reflected time
  int new_minutes;   //this is used to store the value of minutes for the actual time calculated from the refleected time    
   
  if((hour == 0 || hour == 12 || hour == 24) && minutes == 0)
  {
    new_hour = hour;
    new_minutes = minutes;
  }
  
  if((hour == 12) && (minutes != 0))
  {
    new_hour = 23 - 12;
    new_minutes = 60 - minutes;
  }

  if(hour == 0 && minutes != 0)
  {
    new_hour = hour;
    new_minutes = 60 - minutes;
  }

  if(hour < 12)
  {
    new_hour = 11 - hour;
    new_minutes = 60 - minutes;
  }

  if(hour > 12)
  {
    new_hour = 23 - hour;
    new_hour = new_hour + 12;
    new_minutes = 60 - minutes;
  }
  
  displayReflected(hour, minutes);
  displayActual(new_hour, new_minutes);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: displayActual
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int hour;        //this is used to receive the value of hour part of the actual time 
*       2. int minutes;     //this is used to receive the value of minutes part of the actual time
*
*     Function Description: this function is used to print the actual time values.
*
***************************************************************************/

void displayActual(int hour,int minutes)
{
  if(hour < 10)
  {
    printf("Actual Time: %d%d", 0, hour);
  }
  else
  {
    printf("Actual Time: %d", hour);
  }

  if(minutes < 10)
  {
    printf(":%d%d\n", 0, minutes);
  }
  else
  {
    printf(":%d\n", minutes);
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: diaplayReflected
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void 
*
*     Parameters (list data type, name, and comment one per line):
*       1. int hour;       //this is used to receive the value for hour part of the reflected time
*       2. int minutes;    //this is used to receive the value for the minutes part of the reflected time
*
*     Function Description: This function prints the reflected time.
*
***************************************************************************/

void displayReflected(int hour,int minutes)
{
  if(hour < 10)
  {
    printf("\nReflected Time: %d%d", 0, hour);
  }
  else
  {
    printf("\nReflected Time: %d", hour);
  }

  if(minutes < 10)
  {
    printf(":%d%d\n", 0, minutes);
  }
  else
  {
    printf(":%d\n", minutes);
  }
}

  
      

