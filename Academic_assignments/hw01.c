
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. singh178@purdue.edu
*
*  Homework #:01
*
*  Academic Integrity Statement:
*
*       I have not used source code obtained from
*       any other unauthorized source, either modified
*       or unmodified.  Neither have I provided access
*       to my code to another. The project I am submitting
*       is my own original work.
*
*  Lab Division and Section:1801
*
*  Program Description:Given as integers an angle in degrees, minutes and 
*                      seconds display the value converted into radians.                                                   
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

#define PI M_PI

int main()
{

  int degrees; // stores integer value of degrees
  int minutes; // stores integer value of minutes
  int seconds; // stores integer value of seconds
  float min_to_deg; // stores value of minutes converted to degrees
  float sec_to_deg; // stores value of seconds converted to degrees
  double totdegrees; // total value of degrees and the converted minutes and seconds
  double radians; // the value of degrees converted to radians

  printf("Enter number of degrees: ");
  scanf("%d", &degrees);

  printf("Enter number of minutes: ");
  scanf("%d", &minutes);

  printf("Enter number of seconds: ");
  scanf("%d", &seconds);

  printf("\nData entered: %d%c %d%c %d%c\n", degrees, 176, minutes, 39, seconds, 34);

  min_to_deg = (float)minutes / 60;     // conversion of minutes to degrees
  sec_to_deg = (float)seconds / 3600;   // conversion of seconds to degrees

  totdegrees = degrees + min_to_deg + sec_to_deg;
  radians = (totdegrees * PI) / 180;  // conversion to radians

  printf("Radians Conversion: %.4f\n", radians);

  return(0);
}
  
