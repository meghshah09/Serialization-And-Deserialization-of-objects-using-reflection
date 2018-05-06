
Assignment 4 - Search based Customer Support for Trouble Shooting is done by Megh Shah and Shashwat Maru.
We have tried my best to keep the code easy to understand and flexible for future use.

Run the Below commands assuming that you are inside Megh_shah_Shashwat_Maru/
--------------------------------------------------------------------------

## To clean:
ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.
-----------------------------------------------------------------------
## To compile: 
ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## I used this to run my code
ant -buildfile troubleShootSearch/src/build.xml run -Darg0="inputs/ProblemKeyword.txt" -Darg1="0"

Description: Will run the program with above line of code ONLY.We have used ProbleKeyword.txt insted of UserInputs.txt
All te inputs files (ProblemKeyword.txt,Product1Guide,...) are inside inputs folder which is at the same level of src.
Output Generated will be in output folder which is again at the same level of src folder.

-----------------------------------------------------------------------

## Created tarball for submission with following command.

tar -cvf Megh_Shah_Shashwat_Maru_assign4.tar Megh_Shah_Shashwat_Maru/
gzip Megh_Shah_Shashwat_Maru_assign4.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.ù"

[Date: 4/24/2018]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

1) ArrayList - Used for Storing.....
Worst Case Time Complexity - O(1) for adding a element in a list. O(n) for removal of data from array list since we go through each element.
Getting an element from Array List take O(1).

-----------------------------------------------------------------------
In this trouble shooter project, we designed a platform where system provides the technical guidelines for the queries asked by
the user, here user queries are in the form of input file and guidelines are provided using visitor pattern where algorithm are separated from
product objects to make it flexible for future changes. The visitor takes the instance reference as input, and implements the goal through double dispatch.

Here in this project, Important classes are dSeagate class and visitor classes for each search algorithms. In dSeagate class accept method is
present from where the visit method of each search algorithm is called.

Interface: One for visitor with visit and search method & one for product with accept method in it.
Data Structures for the project: Different arrayList are used for each product and One map is used in which product name is the key and product arraylist is the value.

Flow of the code ( only related to visitor pattern, not file reading and writing):
Here in Driver code, All the arrayList of products are populated with the technical guidelines and then it is added to the map.
Once this is done, then the accept method is called of the dSeagate object by passing the search algorithm to be looking for, 
from accept method, system calls visitor's visit method and once the control reaches to the visit method, it will call the search method
( where main algorithm is present), here system passes all the guideline of each products along with the problem keyword.
And if the search algorithms find the match then it written the corresponding technical guideline to the console/ output file.

Below are the search algorithms:
Exact Match:
Here in this algorithm, we are using regex pattern and checking whether the problem keyword which user had asked for in present in the 
technical guideline of all the product or not. If it matches/finds then It will give that to the output using a arrayList.


Naive Match:
Here in this algorithm, system takes the user query( problem keyword) and tries to find it in each product technical guideline, Here
system is checking whether the problem keyword is a substring of any word of the technical guideline sentences, if it is then we are
providing that to the user in output console and in a file using a arrayList. Here system tokenizes the problem keyword and finds the first
keyword entered by user and find that word in the technical guideline sentences.

Semantic Match:
Here in this algorithm system system finds the last entered word by the user in the problem keyword and then find the synonym of that word
in synonym file, if it has then it replace the original word with the synonym word and then tries to find the exact match of replaced problem keyword
keyword in technical guideline sentences for all the products.


--------------------------------------------------------ProblemKeyword.txt--------------------------------------------------------------
Product HDD:
extended storage device
format HDD
quick read speed
run time
HDD noise
replace old hard drives

Product SDD:
problem detecting
system storage
data transfer crash
learn more
download disk repair
replace the SATA wire
get a refund

Product media player:
saved data
install application
click sound
find data
issue with sound magnitute
compatible CPU

Product USB:
install location
copy data
slow transfer
detect error
USB compatibility fix

No Match:
updating the software
alot of errors
designed for laptop machines


---------------------------------LOGGER-------------------------------------------------------------
Logger static class has been implemented where different level of debug is created, so if programmer wants to print/log a particular scheme
then that level needs to be passed in the command line.
So in this writeMessage method is created which requires 2 arguments, String msg and Debug level and it has been called at every class, but
depending upon the debug level value, only a particular scheme will be printed/logged.


Debug-Level: 4 - Search strategy, This will print the search strategy which is passed in accept method in driver code. 
Debug-Level: 3 - Products, Here all the products which we iterating upon will be printed.
Debug-Level: 2 - Constructor, here all the constructors which are used will be printed with a constructor message.
Debug-Level: 1 - Search, Here only search guidelines will be printed along with the problem keyword.
Debug-Level: 0 - None, This will print all the log messages for errors/exceptions.

-----------------------------------------------------------------------
list of citations (urls, etc.) from where you have taken code