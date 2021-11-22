Inheritance: "is a" relationship. This is when you extend another class or implement an interface.
    Example:  Dog is an Animal. public class Dog extends Animal()
 UML Symbol:  Arrow with an white tip.

Association: "has a" relationship. A broad category containing one-to-one, one-to-many, many-to-one, and many-to-many relationships. 
              Describes objects which are linked together in some way. "Composition" and "Aggregation" are strictly defined subsets of Association.
    Example:  A bank may have many employees. An employee may work at one or more banks.
 UML Symbol:  Regular line

Aggregation: "has a" relationship. A unidirectional association i.e. one-way relationship where the associated objects can conceptually exist
              free of one another. Aggregation is a specialized type of Association, dubbed a "Weak Association".
    Example:  A car needs wheels to function properly, but can exist without them. The wheels do not need the car in order to function properly.
 UML Symbol:  Line with a white diamond tip.

Composition: "part of" relationship. This is when you define one object through the existance of others. The whole object is defined by its parts.
              Composition is a specialized type of Association, dubbed a "Strong Association". It is also a subset of Aggregation.
    Example:  A Human has a Heart and a Brain. Destroying any of these destroys them all.
 UML Symbol:  Line with a black diamond tip.




== "Association" Notes ==
Better explanation for Composition and Aggregation I just found: "The composition and aggregation are two subsets of association. In both of the cases, the object of one class is owned by the object of another class; the only difference is that in composition, the child does not exist independently of its parent, whereas in aggregation, the child is not dependent on its parent i.e., standalone. An aggregation is a special form of association, and composition is the special form of aggregation."

Association is a link, Aggregation is a link where the objects are independent of each other, and Composition is a link where the objects are dependent on each other.