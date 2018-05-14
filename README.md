# Application
Spring Demo

## Demo description

This web application let users add, modify and delete information from a contact list. The app has a basic login page where the user enters its credentials to access the contact list. 

## Development tools

- Java
- Spring
- Hibernate
- Thymleaf
- MySQL

## Webservice packages

- Components

The components package contains the class ContactsConverter which converts the Entity objects into Model objects and vice-versa.

- Controller

The controller package contains the login and contact controllers which are the classes used by the app to bind the front to the backend. 

- Entity 

The entity package contains the contacts class that has defined the database atributes.

- Model

The model package contains the contact atributes that are used by the methods to manipulate the contacts data.

- Repository

The repository package contains the class that does the queries to the database.

- Service

The service package contains the classes and methods that perform the inserts, updates and removals from data into the database.

## Database

MySQL is the database used by the webservice to do the data manipulation, the database settings are located at the `pom.xml` file.

## Frontend

The frontend consists of 3 HTML files. The login page, the contacts list page, and the contacts form. I didn't create the CSS file, I've used a template. For the data binding, I've used thymleaf tags.

## Special Considerations

The login is just an emulation of a ldap system. BUt it doesn't connect to the database.

The user is `root` and password is `root` 


