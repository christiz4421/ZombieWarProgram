# ZombieWarProgram
**CSC422 Week 5 Team Assignment**  
**Authors:** Dennis Feldbruegge, Thomas Sauro, and Zach Christianson  
**Date:** March 2026  
**Source:** Basic writing and formatting syntax (docs.github.com)

## Description
This program simulates a zombie virus outbreak where a group of survivors must fight their way to safety. Each type of survivor and zombie has unique health and attack values that determine how they perform in combat. The simulation randomly generates survivors and zombies, runs a full battle sequence, and reports how many survivors make it out alive.

Release 2.0 expands the simulation with character IDs and detailed battle logs that make the game more dynamic and engaging. 

Release 3.0 adds a full weapon system that increases variety in combat and makes each simulation run less predictable. 

Release 3.1 adds a set of JUnit tests to verify that the simulation runs correctly and that its essential game logic functions as expected.

## Character Hierarchy
- `Character` is the top‑level abstract class that contains shared health, attack, and combat behavior  
- `Survivor` and `Zombie` are abstract subclasses that group related character types  
- Concrete survivors include `Child`, `Teacher`, and `Soldier`  
- Concrete zombies include `CommonInfected` and `Tank`  
- Dead characters cannot attack, and health is prevented from dropping below zero  

## Survivor Types
- **Soldier** has high health and attack  
- **Teacher** has moderate health and attack  
- **Child** has low health and attack  

## Zombie Types
- **Common Infected** has low health and attack  
- **Tank** has very high health and attack  

## Simulation Logic
- Randomly generates survivors and zombies  
- Survivors attack all zombies  
- Zombies attack all survivors  
- Dead characters do not participate  
- Loop continues until one side is eliminated  
- Final report shows how many survivors reach safety

## What's New in Release 2.0
Release 2.0 introduces several improvements that make the simulation more informative and easier to follow:
- Unique character IDs for all types of survivors and zombies
- Detailed kill log showing which character killed which opponent

## What's New in Release 3.0
Release 3.0 adds a full weapon system to the simulation:
- Randomly generated weapon cache at the start of each run
- Survivors are assigned a random weapon
- Each weapon has its own damage and accuracy values
- Updated combat logic so survivors attack using their assigned weapon
- Missed attacks are possible based on weapon accuracy
- Battle log now shows which weapon was used to kill each zombie
- Weapons include: Shotgun, Submachine Gun, Assault Rifle, Pistol, Axe, Crowbar, and Frying Pan

## What's New in Release 3.1
Release 3.1 adds a set of JUnit tests to the simulation:
- Verifies that the simulation can be created without errors
- Verifies that the scenario prints successfully
- Verifies that the simulation runs from start to finish
- Verifies that the final report prints after a run
- Verifies that the `main` method runs without errors
- Verifies that base damage is used when a survivor has no weapon
- Verifies that character health never drops below zero

## Files Included
- `Character.java`: Top‑level abstract base class  
- `Survivor.java` and `Zombie.java`: Abstract subclasses  
- `Soldier`, `Teacher`, `Child`: Survivor types 
- `CommonInfected`, `Tank`: Zombie types
- `Weapon.java`: Provides the basic structure for weapon types, including their damage and accuracy
-  `WeaponGenerator.java`: Creates the random weapon cache for each simulation run
- `ZombieWarSimulation.java`: Handles the simulation logic and battle loop  
- `Main.java`: Entry point that runs the program
- `ZombieWarProgramTest.java`: Verifies program logic

## How to Run
1. Clone the repository to your local machine  
2. Open the project in IntelliJ IDEA or any Java IDE  
3. Run the main program

## Running the Tests
1. Make sure JUnit is set up in your IDE
2. Open `ZombieWarProgramTest.java`
3. Run all tests in your IDE
All tests should pass without errors

## Status
Release 3.0 is complete and includes the new weapon system, updated combat logic, and expanded battle logs.

Release 3.1 adds JUnit tests to verify program logic and maintain reliable performance in future updates.
