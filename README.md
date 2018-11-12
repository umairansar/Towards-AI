# Towards-AI
Built for the purpose of promotion for Artificial Intelligence, Towards AI is an enterprise towards a greater focus on product-based AI-centric enthusiasts, bringing all the latest happenings under the field AI, and more generally technology, in one space. This app features an all rounded streaming of knowledge employing both the video-based learning and article reading straight from trusted news sources and blogging websites.

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
- SQLite Database - for storing names and paths of YouTube videos.

### Mathedology
- The main activity contains 4 graphic buttons for UI enhancement.

- Clicking these buttons takes us to a new activity having a list of all related videos under that category (of the button clicked).

- The number of activities (new different app screens) is equal to the number of channels - in our case its 4 (Robotics, AI, Astronomy, Change).

- Thus each different button takes us to a different activity (having different data).

- List is implemented using listview's builtin layout "simple_list_item_1." 

- Listview has data fetched from SQLite databse class to which itself is populated at the time of exxecution.

- Clicking a single item on list takes us to our final activity of the project: Youtube Media Player.

- Unlike different activities for all 4 video types, each distinct video does not has its own seperate Youtube Media Player activity/class, which would make this project frustratingly memory consuming and slow (it would also make this project development many times difficult and time-consuming)

- Every button click event loads the video name and path to the in-app-embedded media player which loads the Youtube video via internet and plays it in our app.

### Future Work
Followinng are the remaining components that when accomplished would fit for consumer needs, which includes potentially transforming it into my current school's weekly newsletter for school updates and article distribution.

1. Add a favourites table to enhace user friendly UI.
2. Connect it to a live computer where content of the app refreshes everytime the database on the live device is updated.
3. Jumping directly from one video to the next, or in future case, from one newsfeed page to the next without backing to the previous oage to select the next feed.
