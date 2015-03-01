

/***************************************************************************
*
*  Programmers and Purdue Email Addresses:
*	 1. Honey Singh singh178@purdue.edu
*	 2. Zach Brown brownz@purdue.edu
*	 3. Matt Krawczyk mkrawczy@purdue.edu 
*
*  Lab #: 08
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
*  Program Description: The program check if the input integer is a prime.
*   If not, then checks for it being semi-prime. It also checks for wagstaff,
*   mersenne, thabit or carol primes.
*
***************************************************************************/


#include<stdio.h>
#include<math.h>

long long input();
long long isPrime(long long);
void semiPrime(long long);
void wagstaff(long long);
void mersenne(long long);
void thabit(long long);
void carol(long long);

int main()
{
  long long num;      // it stores the input

  num = input();

  if (isPrime(num))
  {
    printf("The number entered %lld is prime!\n", num);
    wagstaff(num);
    mersenne(num);
    thabit(num);
    carol(num);
  }
  else 
  {
    semiPrime(num);
  }

  return(0);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: semiPrime
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;       //receives the value of the number to be checked for being semi prime
*
*     Function Description: This function checks if a number is semi-prime and then prints the 
*       factors.
*
***************************************************************************/

void semiPrime(long long num)
{
  long long firstpair;       //stores the first factor of the number provided
  int semistatus;            //used as a control variable to check for factors
  int counter;               //used to check if number is semi-prime, else print it is not

  firstpair = 3;
  semistatus = 0;
  counter = 0;

  while ( firstpair <= sqrt(num) + 1 && semistatus == 0)
  {
    semistatus = isPrime(firstpair) && isPrime(num / firstpair) && ((num % firstpair) == 0);

    if (semistatus == 0)
    {
      firstpair += 2;
    }
    else
    { 
      printf("The number entered %lld is not a prime, but it is a semi prime with factors [%lld and %lld].\n", num, firstpair, num / firstpair);
      counter++;
    }
  }
  if(counter == 0)
  {
    printf("The number entered %lld is  not prime\n", num);
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: wagstaff
*
*     Programmer's Name: Matt Krawczyk
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;      //receives the value to be checked for being wagstaff prime
*
*     Function Description: This function checks if the number is wagstaff prime.
*
***************************************************************************/

void wagstaff(long long num)
{
  long long q;         // used to calculate the value for wagstaff prime

  q = log(3 * num - 1) / log(2);

  if(((pow(2, q) + 1) / 3) == num)
  {
    if (isPrime(q))
    {
      printf(" -- Is a Wagstaff prime!\n");
    }
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: mersenne
*
*     Programmer's Name: Zach Brown
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;       //receives the value of the number to be checked for being mersenne prime
*
*     Function Description: This function checks if the number is mersenns prime.
*
***************************************************************************/

void mersenne(long long num)
{
  long long n;       // used to calculate value for mersenne prime

  n = log2(num + 1);

  if( (pow(2, n) - 1) == num)
  {
    if (n > 0)
    {
      printf(" -- Is a Mersenne prime!\n");
    }
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: thabit
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;       // receives the value of the number to be checked for being thabit prime
*
*     Function Description: This function checks if the number id thabit prime number.
*
***************************************************************************/

void thabit(long long num)
{
  long long n;        // used to calculate the value for thabit prime

  n = log2( num / 3.0 +  1 / 3.0);

  if( (3 * pow(2, n) - 1) == num)
  {
    if (n > 0)
    {
      printf(" -- Is a Thabit prime!\n");
    }
  }
}


/***************************************************************************
*
*     Function Information
*
*     Name of Function: carol
*
*     Programmer's Name: Matt Krawczyk
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;      // receives the value of number to be checked for being carol prime
*
*     Function Description: This function checks if a prime number is carol prime or not.
*
***************************************************************************/

void carol(long long num)
{
  long long n;       //used to calculate the value for carol prime

  n = log2(sqrt(num + 2) + 1);

  if((pow((pow(2, n) - 1), 2) - 2) == num)
  {
    if (n > 0)
    {
      printf(" -- Is a Carol prime!\n");
    }
  }
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: isPrime
*
*     Programmer's Name: Zach Brown
*
*     Function Return Type: long long
*
*     Parameters (list data type, name, and comment one per line):
*       1. long long num;     // receives the value of the integer to checked for being prime
*
*     Function Description: This function checks if a number is prime.
*
***************************************************************************/

long long isPrime(long long num)
{

  long long root;     // used to store the squarre root of the input
  long long lcv;      // loop control variable

  if(num <= 1)
  {
    return 0;
  }

  if(num == 2)
  {
    return 1;
  }

  if(num % 2 == 0)
  {
    return 0;
  }

  root = sqrt(num * 1.0);

  for(lcv = 3; lcv <= root; lcv += 2)
  {
    if(num % lcv == 0)
    {
      return 0;
    }
  }
  return 1;
}


/***************************************************************************
*
*     Function Information
*
*     Name of Function: input
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: long long
*
*     Parameters (list data type, name, and comment one per line):
*
*     Function Description: This function asks the user for input.
*
***************************************************************************/

long long input()
{
  long long num;       // used to store the value of the input

  printf("Enter a number to test for prime: ");
  scanf("%lld", &num);
  printf("\n");

  return num;
}
