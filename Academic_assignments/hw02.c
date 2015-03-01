
/***************************************************************************
*
*  Programmer and Purdue Email Address:
*  1. singh178@purdue.edu
*
*  Homework #: 02
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
*  Program Description: Marks for four exams to be input and display the 
*  score in each exam, grade earned in each exam and the total score and final grade.
*
***************************************************************************/
#include<stdio.h>
#include<math.h>

//Global Declarations for functions
int input(int, int);
void total(int, int, int, int);
void display(int, int);
int grade(int);
void gexam4(int);
void finalgrade(int);

int main()
{
  int exam1;        // stores score for exam 1 out of 100
  int exam2;        // stores score for exam 2 out of 100
  int exam3;        // stores score for exam 3 out of 100
  int exam4;        // stores score for exam 4 out of 150
  int counter = 0;  // declaration and intialisation of a counter to index the exam number

  exam1 = input( 1, 1);
  exam2 = input( 2, 2);
  exam3 = input( 3, 3);
  exam4 = input( 4, 4);

  printf("\nExam Score Grade\n");
  printf("----------------\n");

  display( ++counter, exam1); 
  display( ++counter, exam2);
  display( ++counter, exam3);
  gexam4(exam4);

  printf("----------------\n");

  total(exam1,exam2,exam3,exam4);

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
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*       1. int counter;   // used to receive and store the index number for the exam from main
*       2. int score;     // used to store the input score for an exam
*
*     Function Description: This function is used for inputting the values for 
*       the exam scores.
*
***************************************************************************/

int input(int counter, int score)
{
  printf("Enter score for exam #%d", counter);
  printf(": ");
  scanf("%d", &score);
  return score;
}  

/***************************************************************************
*
*     Function Information
*
*     Name of Function: total
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1.int exam1; // receives the score for exam 1, scored out of 100
*       2.int exam2; // receives the score for exam 2, scored out of 100
*       3.int exam3; // receives the score for exam 3, scored out of 100
*       4.int exam4; // receives the score for exam 4, scored out of 150
*
*     Function Description: This function will calculate and print the total
*       for all the four scores.
*
***************************************************************************/

void total(int exam1,int exam2,int exam3,int exam4)
{
 int exam_tot;          // stores the value for the total of all exam scores
 exam_tot = exam1 + exam2 + exam3 + exam4;

 printf("Total: %9d\n",exam_tot);
 
 finalgrade(exam_tot); // function call 
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
*       1. int counter; //receives the value of counter from the main function
*       2. int score;   //receives the score one by one for the first three exams
*
*     Function Description: Prints the index, scores and grade for first 3 exams
*       scored out of 100
*
***************************************************************************/

void display(int counter, int score)
{ 
  printf("%3d %5d %5c\n", counter, score, grade(score)); 
  return;
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: grade
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: int
*
*     Parameters (list data type, name, and comment one per line):
*       1. int score; //receives the score for the exam 
*
*     Function Description: This function receives score one by one and returns
*       the grade obtained. It calculates grade for the first 3 exams scored out of 100
*
***************************************************************************/

int grade(int score)
{
  int grade1;       // used to store the quotient after dividing by 85 and rounded to lowest integer
  int grade2;       // used to store the quotient after dividing by 75 and rounded to lowest integer and grade1 subtracted
  int grade3;       // used to store the quotient after dividing by 65 and rounded to lowest integer and grade 2 and grade1 subtracted
  int grade4;       // used to store the quotient after dividing by 55 and rounded to lowest integer and grade1, grade2 and grade3 subtracted
  char scr_grade;   // used to store the grade obtained in the exam
  grade1 = floor(score / 85.0);
  grade2 = floor(score / 75.0) - grade1 ;
  grade3 = floor(score / 65.0) - grade2 - grade1;
  grade4 = floor(score / 55.0) - grade3 - grade2 - grade1;
  
  scr_grade = (char)(grade1 * 65 + grade2 * 66 + grade3 * 67 + grade4 * 68 + (1 - grade4 - grade3 - grade2 - grade1) * 70);
  return scr_grade;
}  

/***************************************************************************
*
*     Function Information
*
*     Name of Function: gexam4
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int score;   //receives the score for the fourth exam scored out of 150
*
*     Function Description: This function calculates and prints grade for the fourth
*       exam. It also prints the index and the score for exam 4.
*
***************************************************************************/

void gexam4(int score)
{
  float grade1;     // used to store quotient of score divided by 85 rounded to lowest integer
  float grade2;     // used to store quotient of score divided by 75 rounded to lowest integer, grade1 subtracted
  float grade3;     // used to store quotient of score divided by 65 rounded to lowest integer, grade1 and grade2 subtracted
  float grade4;     // used to store quotient of score divided by 55 rounded to lowest integer, grade1, grade2 and grade3 subtracted
  int counter = 4;  // stores the value four for the index number of exam 4
  char scr_grade;   // stores the grade obtained in exam 4
  grade1 = floor(score / (.85 * 150));
  grade2 = floor(score / (.75 * 150)) - grade1;
  grade3 = floor(score / (.65 * 150)) - grade2 - grade1;
  grade4 = floor(score / (.55 * 150)) - grade3 - grade2 - grade1;
  scr_grade = (char)(grade1 * 65 + grade2 * 66 + grade3 * 67 + grade4 * 68 + (1 - grade4 - grade3 - grade2 - grade1) * 70);  

  printf("%3d %5d %5c\n", counter, score, scr_grade);
}

/***************************************************************************
*
*     Function Information
*
*     Name of Function: finalgrade
*
*     Programmer's Name: Honey Singh
*
*     Function Return Type: void
*
*     Parameters (list data type, name, and comment one per line):
*       1. int total;   //receives the total score of all 4 exams from the total function
*
*     Function Description: This function receives the total score of all 4 exams
*       and calculates and prints the final grade obtained.
*
***************************************************************************/

void finalgrade(int total)
{
  int grade1;        // used to store quotient of total score divided by 85 rounded to lowest integer
  int grade2;        // used to store quotient of total score divided by 75 rounded to lowest integer, grade1 subtracted
  int grade3;        // used to store quotient of total score divided by 65 rounded to lowest integer, grade1 and grade2 subtracted
  int grade4;        // used to store quotient of total score divided by 55 rounded to lowest integer, grade1,grade2 and grade3 subtracted
  char scr_grade;    // stores the final grade obtained
  grade1 = floor(total / (.85 * 450));
  grade2 = floor(total / (.75 * 450)) - grade1;
  grade3 = floor(total / (.65 * 450)) - grade2 - grade1;
  grade4 = floor(total / (.55 * 450)) - grade3 - grade2 - grade1;
  scr_grade = (char)(grade1 * 65 + grade2 * 66 + grade3 * 67 + grade4 * 68 + (1 - grade4 - grade3 - grade2 - grade1) * 70);

  printf("Grade: %9c\n", scr_grade);
}
