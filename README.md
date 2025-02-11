# Java ExecutorService Practice Repository

## Overview

This repository contains various implementations of Java's `ExecutorService`, showcasing different models of thread execution. It serves as a hands-on learning experience to understand multithreading and concurrency in Java.

## Features

- Implementation of five different thread execution models
- Hands-on practice with `ExecutorService` and thread pools
- Understanding of concurrent execution and task management
- Efficient utilization of CPU resources for parallel processing

## Technologies Used

- Java
- ExecutorService (Java Concurrency API)
- Maven (Build Tool)

## Execution Models Practiced

### 1. **Single Thread Executor** (`singleExecutorLearn`)
   - Uses a single-threaded executor to run tasks sequentially in a single worker thread.
   - Suitable for tasks that should not execute in parallel.

### 2. **Fixed Thread Pool** (`fixedPoolThread`)
   - Uses a predefined number of threads to execute tasks concurrently.
   - Helps optimize CPU utilization for parallel tasks.

### 3. **Future Task Execution** (`futureCall`)
   - Implements `Future` to run tasks asynchronously and retrieve results when needed.
   - Useful when a task needs to return a computed value.

### 4. **Multiple Thread Calls** (`multipleCall`)
   - Uses multiple threads to execute independent tasks in parallel.
   - Demonstrates the benefits of parallel execution.

### 5. **Any Multiple Thread Execution** (`anyMultipleCall`)
   - Generalized approach to execute multiple tasks using thread pools.
   - Provides flexibility in handling concurrent execution.

## Installation

### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven

### Steps to Run the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/grithwikreddy/ExecuterService-Learing.git
   cd ExecutorService-Learing
   ```
2. Compile and run the Java classes:
   ```sh
   mvn clean install
   java -cp target/ExecutorService-Learing.jar com.yourpackage.Main
   ```

