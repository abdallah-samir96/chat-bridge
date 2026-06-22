# Chat-Bridge

----

A Simple distributed chat application built with **Java RMI** and **Maven Multi-Module** architecture. 

The project demonstrates remote communication between a server and multiple clients using Java RMI.

## Features

- Client-server architecture
- Java RMI for remote communication
- Multiple clients can connect simultaneously
- Bidirectional communication (Server ↔ Client)
- Multi-module Maven project
- Shared interfaces between client and server
- Thread-safe client management
- Simple console-based interface


`mvn -pl server exec:java`

## Project Structure

```
echo-chat/
│
├── pom.xml                    # Parent Maven project
│
├── common/                    # Shared interfaces and DTOs
│   ├── src/main/java
│   └── pom.xml
│
├── server/                    # RMI Server
│   ├── src/main/java
│   └── pom.xml
│
└── client/                    # RMI Client
    ├── src/main/java
    └── pom.xml
```

## Architecture

```
                +----------------+
                |     Client 1   |
                +-------+--------+
                        |
                        |
                Java RMI|
                        |
+------------+----------+-----------+------------+
|            |                      |            |
|        RMI Registry           Chat Server      |
|            |                      |            |
+------------+----------------------+------------+
                        |
                Java RMI Callbacks
                        |
                +-------+--------+
                |     Client 2   |
                +----------------+
```

## Technologies

- Java
- Java RMI
- Maven
- Multi-Module Maven
- Object-Oriented Programming
- Concurrency (Locks/Threads)

## Modules

### Common

Contains all shared classes used by both the client and server.

Examples:

- Remote interfaces
- Shared models
- DTOs
- Constants

### Server

Responsible for:

- Starting the RMI Registry
- Registering remote objects
- Managing connected clients
- Broadcasting messages
- Handling client connections

### Client

Responsible for:

- Connecting to the server
- Sending messages
- Receiving messages through RMI callbacks
- Displaying chat messages

## Prerequisites

- Java 17+ (or your project version)
- Maven 3.9+

Verify installation:

```bash
java -version
mvn -version
```

## Build

From the project root:

```bash
mvn clean install
```

## Running the Application

### 1. Start the Server

```bash
mvn -pl server exec:java
```

### 2. Start One or More Clients

Open another terminal:

```bash
mvn -pl client exec:java
```

You can launch multiple clients by opening multiple terminals and running the same command.

## Communication Flow

1. Server starts and registers its remote object.
2. Client looks up the server using the RMI Registry.
3. Client registers itself with the server.
4. Client sends messages to the server.
5. Server broadcasts messages to all connected clients.
6. Clients receive messages through callback interfaces.

## Example

```
Client A:
Hello everyone!

Client B:
Hi!

Client C:
Welcome!
```

## Design Decisions

- Shared interfaces are placed inside the `common` module to avoid code duplication.
- Server communicates with clients using RMI callbacks.
- Maven multi-module structure keeps responsibilities separated.
- Each module can be built independently while sharing common contracts.

## Future Improvements

- GUI using JavaFX or Swing
- Private messaging
- User authentication
- Chat rooms
- Message history
- File sharing
- Encryption
- Logging
- Docker support

## Learning Objectives

This project demonstrates:

- Java RMI
- Distributed Systems fundamentals
- Maven Multi-Module Projects
- Remote Interfaces
- Callback Mechanis
- Client-Server Architecture
- Java Concurrency
- Object-Oriented Design

## License

This project is licensed under the MIT License.

You are free to use, modify, distribute, and sublicense this software, provided that the original copyright notice and license notice are included.
