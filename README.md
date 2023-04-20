# Festival Scheduler
 A Java program that predicts the optimal festival schedule using a custom `.txt` file schema. This program uses an MVC design to create a CLI app that can import festival data and predict the best schedule to follow to achieve what would theoretically be the most enjoyable overall route throughout the grounds.
 
 The program does this by calculating the overall rating of each song within the data by taking an average between the user's rating of the song as well as how willing they are to see it in person (irlIndex). Each artist then recieves an overall score based on all of their songs' average overall ratings as well as the user's willingness to see the artist perform live (irlIndex). The program then populates a list, taking in account the festival's schedule as well as each artist's set times, thereby suggesting the theoretical best route based on the highest rated artist performing at that point in time. The residual data is also used by the program to suggest alternative performances throughout the schedule.
 
 ### How to use:
 Visit `USEME.md` file for more information!
