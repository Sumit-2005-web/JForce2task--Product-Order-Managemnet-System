# Ecommerce Product Management System

A Spring Boot MVC application built using Java, Spring Boot, Spring Data JPA, Thymeleaf, Bootstrap, and MySQL.

The application provides separate functionalities for Admin and User without using Spring Security. Authentication is handled using HttpSession.

---

## Features

### Admin
- Login
- Add Product
- Edit Product
- Enable/Disable Product
- View All Products

### User
- Login
- View Products
- Add Product to Cart
- Update Cart
- Remove Item from Cart
- Place Order
- View Order History

---

## Tech Stack

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- MySQL
- Maven

---

## Project Structure

```
src
 ├── controller
 ├── service
 ├── impl
 ├── repository
 ├── entity
 ├── dto
 ├── exception
 ├── config
 └── templates
```

---

## Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/yourusername/ecommerce-product-management.git
```

### 2. Create Database

```sql
CREATE DATABASE jforcetask2DB;
```

### 3. Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jforcetask2DB
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

spring.mvc.hiddenmethod.filter.enabled=true
```

### 4. Run Project

```
mvn spring-boot:run
```

Application runs at

```
http://localhost:8080
```

---

## Default Credentials

### Admin

Username

```
admin
```

Password

```
admin123
```

### User

Create users manually or insert into database.
Default user 

Username

```
test
```

Password

```
test123
```

## Database Schema 
Users Schema
Column	Type
id	BIGINT
username	VARCHAR
password	VARCHAR
role	VARCHAR


Products Schema 
Column	Type
id	BIGINT
name	VARCHAR
description	VARCHAR
price	DOUBLE
quantity	INT
enabled	BOOLEAN

Cart Schema 
Column	Type
id	BIGINT
user_id	BIGINT
Cart Item Schema ------

Column	Type
id	BIGINT
cart_id	BIGINT
product_id	BIGINT
quantity	INT

Order Schema 

Column	Type
id	BIGINT
order_date	DATETIME
total_amount	DOUBLE
user_id	BIGINT



## Api Endpoints 
Authentication
Method	Endpoint	Description
GET	/login	Login page
POST	/login	Authenticate user
POST	/logout	Logout
Admin Apis

Method	Endpoint	Description
GET	/admin/products	View all products
GET	/admin/products/new	Add product page
POST	/admin/products	Save product
GET	/admin/products/{id}/edit	Edit page
PUT	/admin/products/{id}	Update product
PATCH	/admin/products/{id}/enable	Enable product
PATCH	/admin/products/{id}/disable	Disable product
Users Apis

Method	Endpoint	Description
GET	/products	View products
GET	/cart	View cart
POST	/cart/items	Add item to cart
PUT	/cart/items/{id}	Update cart item
DELETE	/cart/items/{id}	Remove cart item
GET	/orders	View orders
POST	/orders	Place order
## Sample API Requests

POST /login
Form data 
username=admin
password=admin123

Add Product 
POST /admin/products
name=Laptop
description=Dell Laptop
price=65000
quantity=10

Add to cart 
POST /cart/items

productId=1
quantity=2
## Author

Sumit Yadav 

