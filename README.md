# Paranormal-Escape-2D
Authors: Beni Levi and Kayra Calgara.

This project was created using only Java and the Swing Framework. 
The two topics of choice we wanted to improve was version control and AI/Algorithms.

We implemented version control by using git from the very start of the development. We used it to back up our data and used branches to work on the game when we were working online.
The .git file is in the zip file and consists of the logs/branches that we used.

We implemented AI for the enemies in the game. The enemy AI moves towards the player when it's energy is above zero. We calculate the closest energy cell using an algorithm.
If the energy is 0 and the player isn`t near the enemy, it moves towards the closest energy cell. When the enemy has energy, it can jump. The higher the energy it has, the more likely it will jump.

We used a lot of classes and inheritance to make the calculations and code easier. Player and Ghost classes inherit from the Movables class which has a lot of methods and variables which we use for the moves.
Objects on screen also inherit from JPanel (Movables, EnergyCell, Display Panel, Grid, and Menu classes).

Controls:
W - move up, A - move left, S - move down, D - move right
↑ - jump up, ← - jump left, ↓ - jump down, → - jump right

The game is built for the user to play without seeing the ghosts and only the distance. However, we implemented the option to make them visible in case the user wanted to see and test the movement of the ghosts.
