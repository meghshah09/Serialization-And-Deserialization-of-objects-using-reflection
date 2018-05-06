
Assignment 5 - Checkpointing Objects is done by Megh Shah.
I have tried my best to keep the code easy to understand and flexible for future use.

Run the Below commands assuming that you are inside Megh_shah_assign5/
--------------------------------------------------------------------------

## To clean:
ant -buildfile genericCheckpointing/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.
-----------------------------------------------------------------------
## To compile: 
ant -buildfile genericCheckpointing/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## I used this to run my code
ant -buildfile genericCheckpointing/src/build.xml run -Darg0="<mode>" -Darg1="<N>" -Darg2="<fileName>"

Description: Will run the program with above line of code ONLY.

-----------------------------------------------------------------------

## Created tarball for submission with following command.

tar -cvf Megh_Shah_assign5.tar Megh_Shah/
gzip Megh_Shah_assign5.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.ù"

[Date: 5/6/2018]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

1) ArrayList
Worst Case Time Complexity - O(1) for adding a element in a list. O(n) for removal of data from array list since we go through each element.
Getting an element from Array List take O(1).

2) HashMap
Worst Case Time Complexity - O(1) for adding a element in a Map
Getting an element from Hash Map take O(1).
-----------------------------------------------------------------------
list of citations (urls, etc.) from where you have taken code
1)[Ref: https://stackoverflow.com/questions/5725892/how-to-capitalize-the-first-letter-of-word-in-a-string-using-java]
2)[Ref: https://stackoverflow.com/questions/237061/using-regular-expressions-to-extract-a-value-in-java]
3)[Ref:https://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor]