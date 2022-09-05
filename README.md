# Mad-Libs-Game
This game is developed in Kotlin using Android Studio IDE

Mad Libs" are short stories that have blanks called placeholders to be filled in. In the non-computerized
version of this game, one person asks a second person to fill in each of the placeholders without the
second person knowing the overall story. Once all placeholders are filled in, the second person is shown
the resulting silly story.

This Android app will reads a Mad Lib from a text file in a specific format. The text file represents
placeholders as tokens that start and end with < > brackets, like <adjective> or <proper-noun>. This app
reads the file, looks for any such placeholders, and prompts the user to replace them with specific
words. Once the user has typed in replacements for all placeholders, the completed story is shown on
the screen. The screenshots below indicate a possible flow of the UI for such an app. Our flow has three
activities: An initial "welcome" screen explaining the app, then a screen that repeatedly prompts the
user to fill in placeholders, then a third activity to display the completed story. Of course you don't need
to exactly match our sample's UI, but it may give you ideas.
