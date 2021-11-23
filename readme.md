# Dungeon Crawler Deux

## Directories:

#### Documentation

* UML Class Diagram.md - PlantUML Class diagram of the entire project

* Class Relationships.md - Personal notes

* Movement Types.md - Theorycrafting the best way to handle movement in the game

#### src

* Bag - Used to store items aquired by the player

* Map - A collection of Tile objects which define the playspace

* ConsoleHelper - Frequently used bits of code for handling console formatting and output

#### src/actors

* Actor - Superclass for all actors

* Player - Representation of the player

* Goblin, Rat - Basic creatures

#### src/components

* BattleInstance - Handles combat

* MainMenuComponent - Handles the main menu

* MovementComponent - Handles any movement that needs doing by game objects

#### src/items

* Item - Superclass for all items

* Weapon - Basic weapon class

#### src/tiles

* Tile - Superclass for all tiles

* Rock - Blocks player movement entirely

* Room - Allows player movement only if unlocked


