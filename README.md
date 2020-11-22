# Instructions for code uploads

Remove/Comment out the top line of your code (package packagename;) before copying it over to the respective files. This is to allow for easier compilation and submission later.

# How to compile and test code outside of Eclipse
To test the code outside of Eclipse, complete the following steps:

** Make sure all codes work first! Comment out problematic code before compiling for testing!**

1. Go to github and click the green dropdown Code button. Click download ZIP. 
2. Unzip the zip file (which should be in your pc's Downloads folder)
3. Search "cmd" on your PC (assuming you use windows) command prompt. Terminal for Apple.
4. Navigate to the innermost folder that contains a java files
- just type: `cd Downloads\cz2002-project-main (1)\cz2002-project-main`
- `cd` is the keyword to navigate to different folders on your computer 
- use tab key to auto complete after typing first few letters of each folder,\ to move to next innermost folder
5. Once you are in the innnermost folder, paste this command that will compile all java files:
`javac *.java`
6. Once done, paste this command to start using the program:
`java MySTARSApp` 

** Note that the text files with pre-filled data have already been uploaded onto github 
so you DO NOT have to run TestingApp**
