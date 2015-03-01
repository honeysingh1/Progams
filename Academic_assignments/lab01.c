
/***************************************************************************
*
*  Programmers and Purdue Email Addresses:
*	 1. singh178@purdue.edu
*	 2. hsawyer@purdue.edu
*	 3. hziegle@purdue.edu 
*
*  Lab #:1
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
*  Program Description:Find the area of the intersection of two semi-circles
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

int main()
{
  float xcoord1; // stores the x coordinate of the center of first semi-circle 
  float radius1; // stores the radius of the first semi-circle
  float xcoord2; // stores the x coordinate of the center of second semi-circle
  float radius2; // stores the radius of the second semi-circle
  float dist;    // stores the distance between the centres of the 2 semi-circles
  float theta1;  // stores the numerical value of the angle of the sector in the smaller circle
  float theta2;  // stores the numerical value of the angle of the sector in the larger circle
  float area1;   // stores the calculated value of the sector in smaller circle
  float area2;   // stores the calculated value of the sector in larger circle
  float distd;   // stores the calculated area of the diamond shape
  float area;    // stores the calculated area of the overlapping intersection of 2 semi-circles


  printf("Enter the x coordinate for the first circle: ");
  scanf("%f", &xcoord1);

  printf("Enter the radius for the first circle: ");
  scanf("%f", &radius1);

  printf("Enter the x coordinate for the second circle: ");
  scanf("%f", &xcoord2);

  printf("Enter the radius for the second circle: ");
  scanf("%f", &radius2);

  dist = pow( pow(( xcoord2 - xcoord1),2),.5); // calculating the distance between the centers

  // calculating the angle and area of the sector in smaller circle
  theta1 = ( pow(dist,2) + pow(radius1,2) - pow(radius2,2)) / ( 2 * dist * radius1 );
  area1 = pow(radius1,2) * acos(theta1);

  //calculating the angle and area of the sector in larger circle
  theta2 = ( pow(dist,2) + pow(radius2,2) - pow(radius1,2)) / (2 * dist * radius2);
  area2 = pow(radius2,2) * acos(theta2);

  // calculating the area of the diamond shape reactangle
  distd = .5 * pow(((radius1 + radius2 - dist) * (radius1 - radius2 + dist) * (dist - radius1 + radius2) * (dist + radius1 + radius2)),.5);

  area = ( area1 + area2 - distd ) / 2; // calculating the area of the intersection by subtracting area of sectors by area of diamond shape

  printf("\nTotal area of intersection: %.2f\n",area);
  
  return(0);
} 
 












 

