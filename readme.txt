1.	For running this project, Java EE is required.
2.	Import project as existing maven project.
3.	Do following changes in java file stored in Java Resources > src > loader folder.
	I.	In ServletContextClass.java file change variable webPagePath and txtPath to the absolute path where HTMLFiles and TextFiles folders are stored. 
	II.	In GenerateString.java file change absolute path of buffeReader variable to the absolute path where irrelevant.txt is stored.
4.	Add VM argument in the Run Configuration –Vss512m.
5.	Update the maven project by right clicking on the project folder and select Maven > Update Project.
6.	On the Web Content Folder drop down list select index.html 
7.	Right Click on index.html > Run (J2EE Preview at J2EE Prview at localhost Host name: localhost) Run on Server. 
8.	The Project will run on the default browser or eclipse browser.
