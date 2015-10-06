DROP TABLE InfoEntity;
DROP TABLE PersonHobby;
DROP TABLE Hobby;
DROP TABLE Company;
DROP TABLE Phone;
DROP TABLE Address;
DROP TABLE CityInfo;
DROP TABLE Person;

CREATE TABLE Person (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    FIRSTNAME  VARCHAR(40),
    LASTNAME  VARCHAR(60)
);

CREATE TABLE CityInfo ( 
    Zip  VARCHAR(40) PRIMARY KEY,
    City  VARCHAR(60)
);

CREATE TABLE Address ( 
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Street  VARCHAR(40),
    Zip  VARCHAR(40),
    AdditionalInfo VARCHAR(40),
--     Primary Key (Street, Zip),
    FOREIGN KEY (Zip) REFERENCES CityInfo(Zip)
);

CREATE TABLE Phone ( 
    P_number  VARCHAR(40) PRIMARY KEY,
    description VARCHAR(255)
);

CREATE TABLE Company ( 
    C_Name  VARCHAR(255),
    description VARCHAR(255),
    cvr  VARCHAR(40) PRIMARY KEY,
    AdditionalInfo VARCHAR(40),
    NumEmployees int,
    MarketValue int
);

CREATE TABLE Hobby (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    HobbyNAME  VARCHAR(60),
    description VARCHAR(255)
);

CREATE TABLE PersonHobby (
    HobbyId int,
    PersonId int,
    FOREIGN KEY (HobbyId) REFERENCES Hobby(ID),
    FOREIGN KEY (PersonId) REFERENCES Person(ID)
);

CREATE TABLE InfoEntity (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    Email VARCHAR(255), 
    PhoneNumber VARCHAR(40), 
    cvr VARCHAR(40), 
    Person_ID INT,
    adr_Id int,
    FOREIGN KEY (PhoneNumber) REFERENCES Phone(P_number),
    FOREIGN KEY (cvr) REFERENCES Company(cvr),
    FOREIGN KEY (Person_ID) REFERENCES Person(ID),
    FOREIGN KEY (adr_ID) REFERENCES Address(ID)
);




commit;

