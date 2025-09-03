# 👔 Employee-Hierarchy (Composite Design Pattern)
    Compose objects into tree structures so that clients can treat individual objects and compositions uniformly.

**When to use:**
    You have hierarchical tree-like data (e.g., files/folders, menus/submenus, employees/managers).
    You want to treat leaf nodes and composites the same way (a manager is also an employee, but has children).

**Employee Hierarchy** – A Spring Boot application demonstrating how to model an **organization hierarchy** using the **Composite Design Principle** (without an extra interface).

Employees are stored in a **relational database (H2 by default)** with a self-referencing `manager_id` to represent the reporting structure.

---

## ✨ Features
- ✅ Fetch **Manager Chain** (upward traversal)
- ✅ Fetch **Subordinates** (downward traversal)
- ✅ Extendable to **full hierarchy trees**
- ⚡ Tech Stack:
    - Java 17
    - Spring Boot 3.x
    - JPA + H2 (can be switched to MySQL/Postgres easily)
    - Composite design principle → each Employee is both a **leaf** and a **composite**
- 🌐 REST endpoints for hierarchy traversal
- 📦 Preloaded demo data: `CEO → VP → Director → Engineer`

---

## 🏗️ Architecture

- **Entity**: `Employee` → self-referencing JPA entity (`manager_id` as FK)
- **Repository**: `EmployeeRepository` → Spring Data JPA
- **Service**: `OrgTraversalService` → handles upward & downward traversal
- **Controller**: `EmployeeController` → exposes REST APIs

---

## ⚙️ Setup & Run

1. **Clone repository**
   ```bash
   git clone https://github.com/amankumarsharma10/employee-hierarchy.git
   cd employee-hierarchy

2. **📖 API Endpoints**

   **🔹 Get Manager Chain**
    ```bash
    GET /employees/{id}/managers
    Example: http://localhost:8080/employees/E5/managers
    ````
    **🔹 Get Subordinates**
    ```bash
    GET /employees/{id}/subordinates
    Example: http://localhost:8080/employees/E1/subordinates
   ````

3. **🗄️ Database Schema**
  ```bash
   CREATE TABLE employee (
   id VARCHAR(50) PRIMARY KEY,
   name VARCHAR(100),
   title VARCHAR(100),
   manager_id VARCHAR(50),
   FOREIGN KEY (manager_id) REFERENCES employee(id)
   );

