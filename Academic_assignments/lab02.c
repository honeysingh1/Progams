

/***************************************************************************
*
*  Programmers and Purdue Email Addresses:
*	 1. singh178@purdue.edu
*	 2. hziegle@purdue.edu
*	 3. hsawyer@purdue.edu 
*
*  Lab #:02
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
*  Program Description:Given the slant height(s), and radius of circle at water level(r) and base(R)
*  we have to calculate the vertical height , volume, total surface area, lateral surface area, slant height of cone
*  vertical height of cone, volume of cone, total surface area of cone, lateral surface area of cone.
*
***************************************************************************/


#include<stdio.h>
#include<math.h>

#define PI M_PI

int main()
{
  float lradius; //stores value for input of the radius of the base of cone
  float uradius; //stores value of the radius of the circle at the water level
  float sheight; //stores the input value of the slant height
  float heightw; //stores the calculated value of the vertical height of water
  float volumew; //stores the volume of water
  float sawater; //stores the calculated value of the total surface area of the cone under water
  float lsafrustum; //stores the calculated value of the lateral surface area of the portion of cone under the water 
  float sheightcone; //stores the calculated value of the slant height of the entire cone
  float heightc; //stores the calculated value of the vertical height of the entire cone
  float volumec; //stores the calculated value of the volume of the cone
  float sacone;  //stores the calculated value of the total surface area of the entire cone
  float lsacone; //stores the calculated value of the lateral surface area of the entire cone

  printf("Enter the lower radius: ");
  scanf("%f",&lradius);

  printf("Enter the upper radius: ");
  scanf("%f",&uradius);

  printf("Enter slant height:     ");
  scanf("%f",&sheight);

  printf("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

  heightw = pow((pow(sheight,2) - pow((lradius - uradius),2)),.5); //calculation of the height of water

  printf("Vertical height of water: %19.4f", heightw);

  volumew =  PI * (heightw / 3.0) * (pow(lradius,2) + (lradius * uradius) + pow(uradius,2)); //calculation for volume of water

  printf("\nVolume of water: %28.4f", volumew);

  // calculation for the surface area under water
  sawater = (PI * (lradius + uradius) * (pow(pow((lradius - uradius),2) + pow(heightw,2),.5))) + (PI * pow(uradius,2)) + (PI * pow(lradius,2));
  printf("\nTotal surface area under water: %13.4f", sawater);

  lsafrustum = PI * ( lradius + uradius) * pow((pow((lradius - uradius),2) + pow(heightw,2)),.5); //calculation for lateral surface area under water
  printf("\nLateral surface area of the frustum: %8.4f", lsafrustum);

  printf("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

  sheightcone = lradius * ( sheight / (lradius - uradius)); //calculation for slant height of cone
  printf("Slant height of cone: %23.4f", sheightcone);

  heightc = heightw + ((heightw * uradius) / (lradius - uradius)); //calculation for height of cone
  printf("\nHeight of cone: %29.4f", heightc);

  volumec = (PI / 3.0) * heightc * pow(lradius,2); //calculation of volume of cone
  printf("\nVolume of cone: %29.4f", volumec);

  sacone = (PI * lradius * sheightcone) + (PI * pow(lradius,2)); //calculation of surface area of entire cone
  printf("\nTotal surface area of cone: %17.4f", sacone);

  lsacone = (PI * lradius * sheightcone); //calculation of the lateral surface area of the entire cone
  printf("\nLateral surface area of the cone: %11.4f", lsacone);

  printf("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

  return(0);
}


  



