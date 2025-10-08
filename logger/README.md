# 🧩 Logger (using Chain of Responsibility)
📘 Overview

This project implements a custom logging framework in Java using the Chain of Responsibility Design Pattern.
It mimics the behavior of frameworks like java.util.logging or Log4j, where multiple handlers (e.g., console, file) process log messages based on configured log levels.

## 🧠 Design Pattern Used: Chain of Responsibility
### Why Chain of Responsibility?

In a logging system, multiple handlers may process the same log (e.g., print to console, write to file, send to remote system).

Each handler decides whether to handle or forward the log message to the next handler.

This eliminates tight coupling between the logger and specific handlers.

### How It’s Used Here

LogHandler is the abstract base class in the chain.

ConsoleHandler and FileHandler are concrete handlers.

Each handler either:

Logs the message (if level is sufficient), and

Forwards it to the next handler in the chain.