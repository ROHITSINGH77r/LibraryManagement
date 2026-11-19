# LibraryManagementSystem - B.Tech 3rd Sem OOPJ MSE-2

A lightweight, beginner-friendly RESTful API built with **Java** and **Spring Boot** using an in-memory `ArrayList<Book>` to manage books.

---

## Project Structure

```
LibraryManagement/
├── pom.xml
├── api-requests.http
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/library/
│   │   │       ├── Book.java
│   │   │       ├── BookService.java
│   │   │       ├── BookController.java
│   │   │       └── LibraryManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/library/
│               └── LibraryManagementSystemApplicationTests.java
```

---

## How to Run in IntelliJ IDEA

1. **Open Project**: Ensure `LibraryManagement` is open in IntelliJ IDEA.
2. **Reload Maven**: In the right sidebar, click the **Maven** tab and click the **Reload All Maven Projects** icon (circular arrows).
3. **Run Application**:
   - Open `src/main/java/com/example/library/LibraryManagementSystemApplication.java`.
   - Click the green **Run** triangle icon next to `public static void main(...)` or press `Shift + F10`.
4. **Access the API**: The server will start on port `8080`.

---

## API Endpoints Summary

| Method | Endpoint | Description | Success Status | Failure Status |
|---|---|---|---|---|
| `POST` | `/books` | Add a new book | `201 CREATED` | `409 CONFLICT` (duplicate ID) |
| `GET` | `/books` | Retrieve all books | `200 OK` (list or empty `[]`) | - |
| `GET` | `/books/{id}` | Retrieve book by ID | `200 OK` | `404 NOT FOUND` |
| `PUT` | `/books/{id}` | Update book details | `200 OK` | `404 NOT FOUND` |
| `DELETE` | `/books/{id}` | Delete book by ID | `200 OK` | `404 NOT FOUND` |

---

## Testing with IntelliJ HTTP Client

Open `api-requests.http` in IntelliJ IDEA and click the green play button next to each request.
