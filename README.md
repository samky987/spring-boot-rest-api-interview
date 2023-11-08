-Each module of the application handles specific responsibility to apply the Single Responsibility Principle.

-In the controller package is where all the rest endpoints are located.

-The service package contains the service classes which handle the buissness logic of the application.

-The respository package contains the repository that will handle saving and quering data from the DB.

-Modal contains all the JPA Entities.

Flow of the system:

-User call api -> controller -> service -> repository -><- JPA 

