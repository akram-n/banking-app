# Banking App

A RESTful banking application built with Spring Boot that provides basic banking operations like account management, deposits, and withdrawals.

## 📋 Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Contributing](#contributing)

## ✨ Features

- Create new bank accounts
- View account details
- Get all accounts
- Deposit money to accounts
- Withdraw money from accounts
- Delete accounts
- RESTful API architecture
- MySQL database integration
- Data validation and error handling

## 🚀 Technologies

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **Spring Web**
- **MySQL** - Database
- **Lombok** - Boilerplate code reduction
- **Maven** - Dependency management

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🛠️ Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd banking-app
   ```

2. **Create MySQL Database**
   ```sql
   CREATE DATABASE banking_app;
   ```

3. **Install dependencies**
   ```bash
   mvn clean install
   ```

## ⚙️ Configuration

1. **Environment Variables**
   
   Create environment variables for database configuration:
   ```bash
   export DB_URL=jdbc:mysql://localhost:3306/banking_app
   export DB_USERNAME=your_username
   export DB_PASSWORD=your_password
   ```

2. **Alternative: Update application.properties**
   
   You can also directly update `src/main/resources/application.properties`:
   ```properties
   spring.application.name=banking-app
   spring.datasource.url=jdbc:mysql://localhost:3306/banking_app
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

## 🏃‍♂️ Running the Application

### Using Maven
```bash
mvn spring-boot:run
```

### Using Java
```bash
mvn clean package
java -jar target/banking-app-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/accounts` | Create a new account | `{"accountHolderName": "string", "balance": number}` |
| GET | `/api/accounts/{id}` | Get account by ID | - |
| GET | `/api/accounts` | Get all accounts | - |
| PUT | `/api/accounts/{id}/deposit` | Deposit money | `{"amount": number}` |
| PUT | `/api/accounts/{id}/withdraw` | Withdraw money | `{"amount": number}` |
| DELETE | `/api/accounts/{id}` | Delete account | - |

### Example Requests

**Create Account:**
```bash
curl -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"accountHolderName": "John Doe", "balance": 1000.0}'
```

**Deposit Money:**
```bash
curl -X PUT http://localhost:8080/api/accounts/1/deposit \
  -H "Content-Type: application/json" \
  -d '{"amount": 500.0}'
```

**Withdraw Money:**
```bash
curl -X PUT http://localhost:8080/api/accounts/1/withdraw \
  -H "Content-Type: application/json" \
  -d '{"amount": 200.0}'
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/practice/banking/
│   │   ├── BankingAppApplication.java       # Main application class
│   │   ├── controller/
│   │   │   └── AccountController.java       # REST controller
│   │   ├── dto/
│   │   │   └── AccountDTO.java             # Data Transfer Object
│   │   ├── entity/
│   │   │   └── Account.java                # JPA Entity
│   │   ├── mapper/
│   │   │   └── AccountMapper.java          # Entity-DTO mapper
│   │   ├── repository/
│   │   │   └── AccountRepository.java      # Data access layer
│   │   └── service/
│   │       ├── AccountService.java         # Service interface
│   │       └── impl/
│   │           └── AccountServiceImpl.java # Service implementation
│   └── resources/
│       └── application.properties          # Configuration
└── test/
    └── java/com/practice/banking/
        └── BankingAppApplicationTests.java  # Test classes
```

## 🧪 Testing

Run the tests using Maven:

```bash
mvn test
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🐛 Known Issues

- Add proper error handling for insufficient funds
- Implement transaction history
- Add authentication and authorization
- Add input validation

## 🚀 Future Enhancements

- [ ] Add transaction history tracking
- [ ] Implement user authentication
- [ ] Add money transfer between accounts
- [ ] Add account types (Savings, Checking)
- [ ] Add interest calculation
- [ ] Add API documentation with Swagger
- [ ] Add unit and integration tests
- [ ] Add Docker containerization

## 📞 Support

If you have any questions or issues, please open an issue in the repository.

---

**Happy Banking! 🏦**
