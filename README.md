# Flappy Bird-Inspired Airplane Game

This project is a Flappy Bird-style game where the player controls an airplane, navigating through buildings and avoiding collisions. The game has been developed in Java and uses simple key inputs for control.

## Features
- **3D-style Gameplay**: The player controls an airplane that must navigate through gaps in buildings.
- **Graphics**: Simple graphics with custom airplane and building images.
- **Score Tracking**: Tracks current score and high score.

## Installation
1. Clone the repository or download the project files.
2. Open the project in an IDE like IntelliJ or Visual Studio Code.
3. Ensure all required images (airplane, building, and background) are located in the `src/Images` folder.

## How to Play
- **Objective**: Navigate the airplane through as many building gaps as possible to achieve a high score.
  
### Controls
- **Space Bar**: 
  - When the game starts: Press to start the game.
  - While playing: Press to make the airplane jump upward.
- **Arrow Keys**:
  - **Up Arrow**: Moves the airplane up.
  - **Down Arrow**: Moves the airplane down.
- **R Key**: Press to restart the game after a game-over.

### Scoring
- **Score**: Earn points for each building gap you successfully pass.
- **High Score**: Track the highest score reached in the session.

## Game Over Conditions
- The game ends if the airplane collides with a building or the ground. You can press the **R Key** to restart.

## Requirements
- Java Development Kit (JDK)
- Java Swing and AWT libraries for graphics

## Known Issues
- Ensure images are in the correct `src/Images` directory to prevent loading errors.
- The game is controlled exclusively through the keyboard.

Enjoy playing!