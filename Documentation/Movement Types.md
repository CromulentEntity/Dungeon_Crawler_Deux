# Movement Types

## Coordinate Based

* The player object stores its location as a pair of integers corresponding to x and y coordinates on the map. 

* The player and the map/rooms have no reference to one another.

* When moving, you must get the players location, modify it based on the direction they want to go, and check if the room at the resulting set of coordinates is locked or not.

## Reference Based

* Each room has a player object which is either null when the player is not in the room, or equal to the player object when they are.

* Each room also stores a reference to each of its neighbors. This would be calculated after the map is created on a per-room basis.

* When moving, you must get the room currently containing the player and check if the neighbor in the desired direction is locked.

## Misc.

Is movement a function of the player, or a function of the game??


