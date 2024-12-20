# Chat Application

A Java-based chat application that facilitates real-time communication between a server and multiple clients. Messages exchanged in the chat are saved in a MySQL database for persistent storage. The application uses Java Swing for a graphical user interface (GUI) and multithreading to manage simultaneous input/output operations.

---

## Features

- **Real-Time Messaging:** Communication between server and client in real-time.
- **Graphical User Interface:** User-friendly GUI built with Java Swing.
- **Persistent Storage:** Messages are stored in a MySQL database.
- **Threaded Architecture:** Separate threads for reading and writing messages.

---

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java Development Kit (JDK)** (version 8 or later)
- **MySQL**
- **MySQL Connector for Java**
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans (optional)

---

## Installation and Setup

### 1. Clone the Repository
```bash
$ git clone https://github.com/your-username/chat-app.git
$ cd chat-app
```

### 2. Set Up the Database
1. Open your MySQL CLI or MySQL Workbench.
2. Run the following commands to create the database and table:

```sql
CREATE DATABASE chatapp;
USE chatapp;
CREATE TABLE messaget (
    meg TEXT(55),
    content TEXT(55)
);
```

3. Update the database credentials in the `Server.java` and `Client.java` files:
   - `url`: Database URL (e.g., `jdbc:mysql://localhost:3306/chatapp`)
   - `username`: Your MySQL username
   - `password`: Your MySQL password

### 3. Compile and Run the Application

#### Compile
```bash
$ javac Server.java Client.java chatdataset.java
```

#### Run
Start the server first:
```bash
$ java Server
```

Then start the client:
```bash
$ java Client
```

---

## How It Works

### Server
1. The `Server` class starts by listening for incoming connections on port `7777`.
2. Messages sent by the client are displayed in the server's GUI and stored in the MySQL database.
3. The server can send messages back to the client through the GUI.

### Client
1. The `Client` class connects to the server on localhost and port `7777`.
2. Messages sent by the server are displayed in the client’s GUI and stored in the MySQL database.
3. The client can send messages back to the server through the GUI.

### Database
1. Each message sent by the server or client is saved in the `messaget` table.
2. The columns `meg` and `content` store the messages.

---

## Screenshots

### Server GUI
![Server GUI](path-to-screenshot-server)

### Client GUI
![Client GUI](path-to-screenshot-client)

---

## Contributing

1. Fork the repository.
2. Create a new branch:
   ```bash
   $ git checkout -b feature-branch
   ```
3. Commit your changes:
   ```bash
   $ git commit -m 'Add some feature'
   ```
4. Push to the branch:
   ```bash
   $ git push origin feature-branch
   ```
5. Open a pull request.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- **Java Swing:** For the GUI framework.
- **MySQL:** For persistent message storage.
- **Community Resources:** Tutorials and documentation that guided the development of this project.

---

## Contact

If you have any questions, feel free to contact me at tusharfodse@gmail.com.

