
## Building an executable JAR file

To generate an executable version of the game you will need to use *JarSplice* and follow these steps:

1. Right-click on the project and select *Export*.
2. Click on *Java* and select *Runnable JAR File*.
3. Select your main class in the *Lunch configuration* drop-down menu.
4. Select *Extract required libraries into generated JAR* and press the *Finish* button.
5. Download *JarSplice* at http://ninjacave.com/jarsplice and execute it (double-click on it).
6. Select *1) ADD JARS*, press the *Add Jar(s)* button in the bottom and select the previously exported JAR file.
7. Select *2) ADD NATIVES*, press the *Add Native(s)* button in the bottom, go to you projects *native* library and select all the files inside it.
8. Select *3) MAIN CLASS*, and in the *Enter Main Class* area type in the name of your main class including the name of the package (e.g. examples.SimpleSlickGame).
9. Select *4) CREATE FAT JAR* and press the *Create Fat Jar* button.
10. The Jar you generated can be distributed and played on Windows, Linux and Mac.


