# Towards-AI
Built for the purpose of promotion for Artificial Intelligence, Towards AI is an enterprise towards a greater focus on product-based AI-centric enthusiasts, bringing all the latest happenings in the filed of AI, and more generally technology, in one space. This app features an all rounded streaming of knowledge employing both the video-based learning and article reading straight from trusted news sources and blogging websites.

Since todays AI is less consumer-based as compared to an Android application, this project was my first step towards preparing for an article that already sells: an app.

This production falls under the jurisdiction of M/s Edlytica, a Pakistani startup which serves the developmental solutions at an international platform.
This app includes the functionality to view the top Machine Learning Channels from YouTube using the Google’s own YouTube API. 

### Activities
Follow the link to dive straight into code.

https://github.com/umairansar/Towards-AI/tree/master/app/src/main/java/com/example/ansarfarid/myapplication

### Visiualize
See the final product in a short video clip at YouTube.

https://youtu.be/1FJtycfFfaM

### Components
- Splash Screen - which displays for 2 second everytime the app runs
- Main Screen - the home page listing four buttons which take us to the next screens
- Listview/ Category page - it lists all the availible videos concerning AI currently availible
- Embedded Video Player Screen - it plays the youtube videos directly into the app
- Sliding Navigation Menu - lists all the availible AI newsletters that can be accessed directly within an app
- Built-in Webwiew - loads the website links and proides in-app browser experience 
- SQLite Database - for storing names and paths of YouTube videos.

### Mathodology
- The main activity contains 4 graphic buttons for UI enhancement.

- Clicking these buttons takes us to a new activity having a list of all related videos under that category (of the button clicked).

- The number of activities (new different app screens) is equal to the number of channels - in our case its 4 (Robotics, AI, Astronomy, Change).

- Thus each different button takes us to a different activity (having different data).

- List is implemented using listview's builtin layout "simple_list_item_1." 

- Listview has data fetched from SQLite databse class to which itself is populated at the time of exxecution.

- Clicking a single item on list takes us to our final activity of the project: Youtube Media Player.

- Unlike different activities for all 4 video types, each distinct video does not has its own seperate Youtube Media Player activity/class, which would make this project frustratingly memory consuming and slow (it would also make this project development many times difficult and time-consuming)

- Every button click event loads the video name and path to the in-app-embedded media player which loads the Youtube video via internet and plays it in our app.

- Repositioning back to the home page, there is a silder menu which contains button click events (can be thought of as listview OnItemClick event) that jump to a new activity containing Web View.

- This Web View screen loads the path of the url hidden behind the item clicked and displayes the web page, without the need to load the url in external broswer (such as Google Chrome).

#### Note :- All the challenges/problems breached below were removed and corrected in this uploaded version of application in this repository. 

### Chanllenges
1. The database did not get refreshed and always retained any prior data populated on the last run. This caused the app to crash everytime I innitiated an instance thereafter my first time execution. 

2. The data in the tables also duplicated everytime I rerun the program.

3. I could not pass the name and path of the selected listview item to the VideoPlayer.java activity. Incorrect instantiatiion caused the app crashing.

4. Retaining the app to the Video View alone is not sufficient to play a YouTube video in the player. To do so will be time-consuming as you will have to copy the magnetic link of the video name which is way more complex than simply copy pasting a portion of the Youtube video URL.

5. When in the Website activity browising the articles, pressing the back button would quit the activity as a whole - much alike applying back operation on the app screen rather that the website being surfed.

### Resolutions
1. Delete any previous rows, using db.delete function, that got loaded in the last run and interfere with the populating of new data. This will prevent any irregular crashing of the program.

2. Using the same commmand as above also clears any prior data, thus preventing unnecessary duplicafion of data everytime a program is run for testin.

3. Avoid calling constructors or methods in between classes to pass on variable data. Instead use the "putExtra" function with an intent to pass any arguments to be processed by the receiver activity.

4. YoutubeAPI is necessary to run any youtube video with just its video ID portion from the whole URL. You will need to make a user account on Google Cloud Console which will return an API key which will beussed to authenticate the accessor's identity. Only then it is possible to play lest you opt for inefficient time consuming rmtp link of videos.

5. Implementinng an Overide method of OnBackPressed corrects the issue with exiting activities. It ensures that the back operation is executed on the website's screen instead.


### Future Work
Following are the remaining components that when accomplished would fit for consumer needs, which includes potentially transforming it into my current school's weekly newsletter for school updates and article distribution.

1. Add a favourites table to enhace user friendly UI.
2. Connect it to a live computer where content of the app refreshes everytime the database on the live device is updated, without the need to reinstall an update everytime new data is added to the app's database.
3. Jumping directly from one video to the next, or in future case, from one newsfeed page to the next without backing to the previous page to select the next feed.
