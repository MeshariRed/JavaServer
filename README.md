<h1 align="center"> 
    Java Server
</h1>

<h3 align="center"> 
    This code implements a simple client-server chat application using Java sockets.
</h3>

<p align="center">
    <a href="https://www.oracle.com/">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="made-with-Java">
    </a>
    <img src="http://ForTheBadge.com/images/badges/built-with-love.svg" alt="built-with-love"><br> 
    <a href="https://github.com/MeshariRed">
        <img title="Author" src="https://img.shields.io/badge/Author-MeshariRed-blue.svg?color=54aeff&style=for-the-badge&logo=github" /><br>
    </a>
    <a href="https://github.com/MeshariRed/JavaServer/blob/main/LICENSE">
        <img src="https://img.shields.io/github/license/MeshariRed/JavaServer.svg" alt="LICENSE">
    </a>
    <img src="https://img.shields.io/github/watchers/MeshariRed/JavaServer.svg" alt="Watching">
    <img src="https://img.shields.io/github/forks/MeshariRed/JavaServer.svg" alt="Forks">
    <img src="https://img.shields.io/github/stars/MeshariRed/JavaServer.svg" alt="Stars">
</p>


## Project introduction
This code implements a simple client-server chat application using Java sockets.

## Quick revision
The ClientHandler class extends Thread and is responsible for handling communication with a single client.
When a new client connects, a new ClientHandler thread is created to handle communication with that client. The 
run() method reads messages from the client and broadcasts them to all connected clients.
Thebroadcast() method sends a message to all clients in the clients list.

## Features 
The Server class listens for client connections on port 5000. When a new client connects, a new ClientHandler
thread is created to handle communication with the client. The ExecutorService class is used to create a thread 
pool to handle multiple clients simultaneously.

The Client class connects to the server and sends user input to the server. The server's response is read and displayed to the user.

## Conclusion
Overall, this code demonstrates the basic concepts of socket programming in Java and can be used as a starting point
for more complex client-server applications.

All The Best
