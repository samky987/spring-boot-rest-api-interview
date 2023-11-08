-Each module of the application handles specific responsibility to apply the Single Responsibility Principle, and Seperation of Concerns.

-In the controller package is where all the rest endpoints are located.

-The service package contains the service classes which handle the buissness logic of the application.

-The respository package contains the repository that will handle saving and quering data from the DB.

-Modal contains all the JPA Entities.

-The api's that allow members to delete their accounts and borrow and return books are under Member controller and service.

-The api's that allow Librarians to manage Books and Members are under Book Management and Member Management controller and service

Flow of the system:

-User call api -> controller -> service -> repository -><- JPA 

