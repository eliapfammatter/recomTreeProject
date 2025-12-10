# RecomTree: Socket-Based Movie Recommendation System

**Course:** Project 63-31 Collaborative Programming (Fall 2025)
**Topic:** Socket-Based Movie Recommendation System


## 👥 Authors
* Elia Pfamatter
* Vuk Vasic

## 📖 Project Description

RecomTree is a Java-based client-server application that simulates the core mechanisms of a movie recommendation platform, inspired by Netflix's recommender system.

The system maintains a hierarchical **N-ary Genre Tree** to represent the movie catalog. It allows multiple clients to connect via TCP sockets to browse genres, rate movies, and receive automated recommendations based on specific strategies.

## 🚀 Key Features

* **Multi-Client Support:** Handles multiple concurrent clients using Java TCP Sockets (`ServerSocket`, `Socket`).
* **Data Structure:** Implements a custom N-ary Tree (`GenreTree`) to manage genres and subgenres efficiently.
* **Recommendation Engine:** Generates suggestions using configurable strategies (e.g., Top-Rated, Genre-Similar).
* **Interactive CLI:** Clients can add movies, rate titles, and request recommendations via a text-based interface.
* **SOLID Design:** Built with strict adherence to modular architecture and design patterns.

## 🛠 Architecture & Design Patterns

This project enforces **SOLID principles** and utilizes the following design patterns:

1.  **Composite Pattern:** Used in the `GenreTree` and `GenreNode` structure to treat individual movies and genre hierarchies uniformly.
2.  **Command Pattern:** Used to parse and execute client requests (e.g., `AddMovieCommand`, `RecommendCommand`), ensuring loose coupling between the request and the execution logic.
3.  **Strategy Pattern:** Used in the `recommendation` package to switch between different recommendation algorithms (`TopRatedStrategy`, `GenreSimilarStrategy`) at runtime.

## 📂 Project Structure

The project is organized into the following packages:

```text
src/
├── client/
│   └── RecomTreeClient.java      # Handles TCP connection and user input
├── server/
│   ├── RecomTreeServer.java      # Main server loop
│   └── ClientHandler.java        # Manages individual client threads
├── command/
│   ├── Command.java              # Command Interface
│   ├── CommandFactory.java       # Creates commands from requests
│   └── [ConcreteCommands].java   # (AddMovie, ListSubtree, RateMovie, etc.)
├── recomTree/ (Model)
│   ├── GenreTree.java            # Manager for the N-ary tree
│   ├── GenreNode.java            # Nodes representing Genres
│   └── Movie.java                # Data object for Movie details
└── recommendation/
    ├── RecommendationStrategy.java # Strategy Interface
    └── [Strategies].java         # Concrete algorithms
