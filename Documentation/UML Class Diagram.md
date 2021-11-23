@startuml
class Actor {
    - name : String
    - health : int
    - maxHealth : int
    - mana : int
    - maxMana : int
    - baseDamage : int
    - location : int[]
    --
    .. General ..
    loseHealth(damage : int)
    gainHealth(healing : int)
    attack(targetActor : Actor)
    toString() : String
    .. Gets ..
    getName() : String
    getHealth() : int
    getMana() : int
    getLocation() : int
    .. Sets ..
    setHealth(health : int)
    setMana(mana : int)
    setLocation(xDimensions : int, yDimensions : int)
}

class Player {
    - STARTINGHEALTH : int = 100
    - STARTINGMANA : int = 100
    - BASEDAMAGE : int = 5
    - STARTINGLOCATION : int[] = {0, 0}
    - weapon : Weapon
    - experience : int
    - level : int
    - bag : Bag
    --
    .. General ..
    gainExperience(ammount : int)
    attack(targetActor : Actor)
    equipWeapon()
    removeWeapon()
    toString()
    .. Gets ..
    getExperience() : int
    getLevel() : int
    getBag() : Bag
}

class Goblin {
    - NAME : String = Goblin
    - HEALTH : int = 20
    - MANA : int = 0
    - BASEDAMAGE : int = 2
    - STARTINGLOCATION : int[] = {3, 3}
}

class Rat {
    - NAME : String = Rat
    - HEALTH : int = 6
    - MANA : int = 1200
    - BASEDAMAGE : int = 0
    - STARTINGLOCATION : int[] = {2, 2}
}



class MovementComponent {
    .. General ..
    moveActor(currentXCoordinate : int, currentYCoordinate : int, map : Map)
    checkCollisions(int, int, int, int, String)
}

class BattleComponent {
    - player : Actor
    - enemies : Actor[]
    - turn : int
    --
    .. General ..
    battle() : boolean
    advanceTurn()
    chooseTarget() : Actor
}

class MainMenuComponent {
    .. General ..
    actionSelect(map : Map, player : Player) : boolean
}



class Item {
    - name : String
    - description : String
    - value : int
    --
    .. Gets ..
    getName() : String
    getDescription() : String
    getValue() : int
}

class Weapon {
    - damage : int
    - slot : String
    --
    .. General ..
    toString() : String
    .. Gets ..
    getDamage() : int
    getSlot() : String
}



class Tile {
    -icon : String
    -activeIcon : String
    -isSolid : boolean
    -isLocked : boolean
    -isPassable : boolean
    --
    .. General ..
    updateIsPassable()
    tileCanBeEntered()
    isPlayerPresent(boolean)
    .. Gets ..
    getActiveIcon()
    getIsPassable()
    getIsSolid()
    getIsLocked()
    .. Sets ..
    setIsLocked(boolean)
    setIsSolid(boolean)
}

class Rock {
    -ICON : "■"
    -ISSOLID : true
    -ISLOCKED : false
}

class Room {
    -ICON : "□"
    -ISSOLID : false
}



class Main {
    .. General ..
    initializePlayer() : Player
    initializeMap() : Map
}

class Map {
    - map : Tile[][]
    - xDimensions : int
    - yDimensions : int
    --
    .. General ..
    generateMap()
    toString() : String
    .. Gets ..
    getMap() : Tile[][]
}

class Bag {
    - weapons : ArrayList<Weapon>
    --
    .. General ..
    addWeaponToBag(weapon : Weapon)
    removeWeaponFromBag(weaponPosition : int) : Weapon
    toString() : String
    .. Gets ..
    getWeapons() : ArrayList<Weapon>
}

Tile <|-- Rock : < is a
Tile <|-- Room : < is a

Actor <|-- Player : < is a
Actor <|-- Rat : < is a
Actor <|-- Goblin : < is a
Actor "1" *-- "1" MovementComponent : < part of

Item <|-- Weapon : < is an

Map "1" *-- "Many" Tile : made of >

Bag "1" o-- "Many" Weapon : contains >

MainMenuComponent "1" *-- "1" Player : Relies on >
MainMenuComponent "1" *-- "1" Map : Relies on >

BattleComponent "1" *-- "Many" Actor : Requires >

Main "1" *-- "1" Player : Relies on >
Main "1" *-- "1" Map : Relies on >

Player "1" *-- "1" Bag : Has a >
@enduml