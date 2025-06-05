# Sauce Demo Automation Framework

![Java](https://img.shields.io/badge/Java-11+-blue)
![TestNG](https://img.shields.io/badge/TestNG-7.7.1-red)
![Selenium](https://img.shields.io/badge/Selenium-4.8.0-green)
![REST Assured](https://img.shields.io/badge/REST_Assured-5.3.0-orange)

A robust test automation framework for testing the Sauce Demo web application and Simple Books API.

## 📌 Features

- **Page Object Model** design pattern for maintainable code
- **Cross-browser testing** (Chrome, Firefox) support
- **Parallel test execution** using TestNG
- **Extent Reports** for detailed test reporting
- **API testing** with REST Assured
- **Configuration management** via properties file
- **CI/CD ready** Maven project structure

## 🛠️ Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- Chrome and/or Firefox browsers installed
- Internet connection (for dependency downloads)

## 🚀 Setup Instructions

1. Clone the repository:
   ```bash
   git clone [your-repository-url]
   ```

2. Navigate to project directory:
   ```bash
   cd sauce-demo-framework
   ```

3. Install dependencies:
   ```bash
   mvn clean install
   ```

## ⚙️ Configuration

Edit `src/test/resources/config.properties` to configure:

```properties
# Supported browsers: chrome, firefox
browser=chrome

# Application URLs
baseUrl=https://www.saucedemo.com/
apiBaseUrl=https://simple-books-api.glitch.me

# Test credentials
validUsername=standard_user
validPassword=secret_sauce
```

## 🧪 Running Tests

### Run all tests sequentially:
```bash
mvn test -DsuiteXmlFile=testng-sequential.xml
```

### Run tests in parallel (cross-browser):
```bash
mvn test -DsuiteXmlFile=testng-parallel.xml
```

### Run specific test group:
```bash
mvn test -
