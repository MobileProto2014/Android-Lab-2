Android-Lab-0
=============

Setting up a git repository for android studio projects

###Creating the Project
1. Open up Android Studio
2. New Project...
3. Application Name: Anything you want. ExampleApp for example.
4. Module name: Anything you want. App is default for single module projects
5. Package Name: Generally com.[company name].[project name].[module]
6. Project Location: Default is fine (auto-generated from above information)
7. Minimum required SDK: API14 is good (API14 and up cover most users and give a nice set of features)
8. Target SDK: Up to you. Latest and greatest is nice. 
9. Compile With: Latest and greatest all the way.
10. Language Level: Default is fine
11. Theme: You can explore these later but they're just the appearance theme of the app. Default is fine. You can change it later.
12. Create activity (you need this if you're going to be running this application - though you can do it manually if you wish)
13. Next -> 
14. Blank Activity is fine for now.
15. Keep going Next -> Until it starts building stuff. 
16. Leave it for now. 

###Creating the Github Repo
1. Create a new repository
2. Name it whatever you want
3. Give it a description
4. Initialize with README
5. Give it a .gitignore (Android)
6. Create
7. Edit the .gitignore in the repository
8. Add .idea/
9. Add *.iml
10. Commit

###Project initialization in github repository
1. Terminal > Go to your local top-level project folder
2. git init
3. git remote add origin [github repo HTTPS clone url]
4. rm .gitignore #replacing the android's .gitignore with ours
5. git pull origin master
6. git add . # or git add -A
7. git commit -m "android studio project initialization" # Or whatever you want your message to be. these are important.
8. git push -u origin master

###Importing the project from a git repository
If you're getting someone else's code or sharing this project via git, you must import the project when opening it for the first time.

1. git clone [Github Repo HTTPS clone url]
2. Open Android Studio
3. Import Project ...
4. Navigate to the right directory
5. Select on the build.gradle in the top-level directory
6. And go! 
7. This sets up the local configurations files for you based on gradle and the project structure. (the things we gitignored)


### You're all set!
1. Remember your Gitiquette (Git Etiquette)
2. Add files individually based on what feature you worked on / changed
3. Commit them with useful messages detailing what you did for reference
4. Make use of git status as much as you can to make sure you know what git things are going on
5. Make use of separate branches for major changes. git checkout -b [new branch for new feature]. Make pull-requests back to master after testing.
6. Always test your application to make sure everything works before you push a new change (or you'll have a shitty time later). 
7. Master branch should ALWAYS be functional. If you break master, you're in for a lot of pain by your collaborators. (people branch off of master to make changes. it should always work!)
8. If you have questions about git, ask right away before you break things. 

### NOW MAKE HELLO WORLD!
We will be going over the pseudo-model-view-controller framework for [Android](http://stackoverflow.com/a/12139782) on the first day of class. You'll need to understand how that works.

1. Take a look at your res (resources) folder. It contains the XMLs you will be using to provide content and layout to the app. 
2. Take a look at your src (source) folder. It contains the java classes that take care of the logic behind the app. 
3. Make sure you understand how "hello world" is being displayed in the generated code. 
4. Add an OnClick functionality to the "hello world" text. 
5. Add an ActionBar menu button that updates UI Elements in some way. 
6. Once you're done, take a look at this repository's app. (git clone and android import build.gradle) 
7. This code has basic structure of what the app should look like as well as comments for what lines of code do. It also demonstrates a standard oragnization of code. It will save you lots of pain if you follow some organization in coding Android apps (Java in general). Files will grow disgustingly long and chaotic otherwise.
