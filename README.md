# Trivia-Kotlin-App

This project is a simple quiz app built with Android Studio and Kotlin. It allows users to answer multiple-choice questions and see their score on a leaderboard.


Designs:
![main](https://github.com/912-Crisan-Patricia/Trivia-Kotlin-App/assets/115460246/97c3d2c6-9c01-48a6-8a2d-0945e35910dd)

![question example](https://github.com/912-Crisan-Patricia/Trivia-Kotlin-App/assets/115460246/44be3296-cba6-4a5e-bf7e-766bd4f19125)

![final_score](https://github.com/912-Crisan-Patricia/Trivia-Kotlin-App/assets/115460246/fdb281a8-3503-4bb6-8c5d-8d463d2fcc3b)

![leader](https://github.com/912-Crisan-Patricia/Trivia-Kotlin-App/assets/115460246/e5e75660-6a64-4b8c-87a7-630e06e67509)


Features:

Leaderboard: Displays the top 3 users with their name, picture, and score.
Quiz: Users can answer multiple-choice questions for a set number of rounds.
Scorekeeping: Tracks the user's score throughout the quiz.
Navigation: Users can navigate between the leaderboard, main menu, quiz, and score screens.


Project Structure:


app: Contains the main application code.
Activity: Activity classes for the leaderboard, main menu, quiz, and score screens.
Adapter: Recycler view adapters for displaying leaders and question choices.
Domain: Data classes representing questions, users, and their scores.
Dependencies:


Glide: Image loading library (https://github.com/bumptech/glide)
androidx libraries: Navigation, RecyclerView, etc.


Future Enhancements:

Implement a larger question bank with different difficulty levels.
Add user authentication and accounts.
Integrate sound effects and background music.
Expand the leaderboard to show more users.
