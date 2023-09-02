Uno Game Engine README
## Introduction
This README provides an overview of the Uno Game Engine and its design principles. The Uno Game Engine is an object-oriented implementation of the Uno card game, designed with clean code principles and object-oriented design patterns in mind.

## Design Pattern
The Uno Game Engine employs the Template Method design pattern. This pattern defines a skeleton algorithm in a method, allowing subclasses to provide specific implementations for certain steps of the algorithm. In this context, the Game class acts as the template, defining the overall structure of the game, while subclasses, like CustomUnoGame, implement specific Uno game variations. This pattern promotes code reuse and extensibility.

## Object-Oriented Design
The code follows key object-oriented design principles:

1. Single Responsibility Principle (SRP)
Each class in the Uno Game Engine has a single responsibility, such as managing cards, players, or game variations. This promotes better organization and maintainability.

2. Naming Conventions
The code follows meaningful and descriptive naming conventions for classes, methods, and variables, enhancing code readability and understanding.

3. Encapsulation
Every class encapsulates its internal details and exposes well-defined interfaces to interact with other parts of the code. This practice manages complexity and maintains code integrity.

4. Inheritance and Polymorphism
Inheritance and polymorphism are used to achieve code reuse and extensibility. The Game class serves as an abstract base class, while specific game variations extend it to provide customized implementations.

5. SOLID Principles

The code adheres to the SOLID principles of object-oriented design:

Single Responsibility Principle (SRP): Each class has a clear and single responsibility, promoting high cohesion and separation of concerns.

Open-Closed Principle (OCP): The code is designed to be easily extendable without modifying existing code. Developers can create new Uno game variations by extending the Game class and implementing the necessary methods.

Liskov Substitution Principle (LSP): Subclasses can be used interchangeably with their base class. For example, a CustomUnoGame object can be used wherever a Game object is expected.

Interface Segregation Principle (ISP): Although not explicitly demonstrated, the design allows for future interfaces to be introduced to define specific contracts and promote loose coupling between components.

Dependency Inversion Principle (DIP): The code relies on abstractions (e.g., Game) rather than concrete implementations (e.g., CustomUnoGame), promoting flexible and decoupled code.

## Code Structure
The Uno Game Engine consists of several key classes:

Game: An abstract base class defining common methods and properties for a game. It includes an abstract play method that must be implemented in each game variation.

Player: Represents a player in the game, holding the player's name, hand of cards, and methods for drawing, playing, and managing cards.

Deck: Represents the deck of Uno cards, including methods for shuffling, drawing cards, returning cards to the deck, and initializing the deck.

Card: Represents an Uno card and may have properties like color and value.

DiscardPile: Represents the pile of discarded cards and includes methods to set and get cards.

GameDriver: Contains the main method to start the game. It instantiates a game object and invokes the play method.

## Getting Started
To create your own Uno game variation:

Extend the Game class and override the abstract methods to define your specific game rules and card variations.

Use the GameDriver class to start your custom Uno game.

Clean Code and Best Practices
The Uno Game Engine adheres to clean code principles and best practices, making it a solid foundation for building Uno game variations. It promotes maintainability, extensibility, and reusability of code.

## Additional Improvements
While the code aligns with many clean code principles, there is room for further enhancements, such as incorporating static factory methods for object creation and using try-with-resources for resource management.

Feel free to use the Uno Game Engine as a starting point for your Uno game variations or as a reference for clean code and object-oriented design. Enjoy building and playing Uno!
