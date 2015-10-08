SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE PersonHobby;
DROP TABLE Phone;
DROP TABLE Hobby;
DROP TABLE Company;
DROP TABLE Person;
DROP TABLE InfoEntity;
DROP TABLE Address;
DROP TABLE CityInfo;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE CityInfo ( 
    Zip  VARCHAR(40) PRIMARY KEY,
    City  VARCHAR(60)
);

CREATE TABLE Address ( 
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Street  VARCHAR(40),
    Zip  VARCHAR(40),
    AdditionalInfo VARCHAR(40),
    FOREIGN KEY (Zip) REFERENCES CityInfo(Zip)
);

CREATE TABLE InfoEntity (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    Email VARCHAR(255), 
    adr_Id int,
    FOREIGN KEY (adr_ID) REFERENCES Address(ID)
);

CREATE TABLE Person (
    ID INT NOT NULL PRIMARY KEY, 
    FIRSTNAME  VARCHAR(40),
    LASTNAME  VARCHAR(60),
    FOREIGN KEY (ID) REFERENCES InfoEntity(ID)
);

CREATE TABLE Company ( 
    ID INT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    cvr VARCHAR(40),
    NumEmployees int,
    MarketValue int,
    FOREIGN KEY (ID) REFERENCES InfoEntity(ID)
);

CREATE TABLE Hobby (
    HobbyNAME VARCHAR(60)PRIMARY KEY,
    description VARCHAR(255)
);

CREATE TABLE Phone ( 
    P_number VARCHAR(40) PRIMARY KEY,
    description VARCHAR(255),
    ID INT NOT NULL,
    FOREIGN KEY (ID) REFERENCES InfoEntity(ID)
);

CREATE TABLE PersonHobby (
    HobbyNAME VARCHAR(60),
    PersonId int,
    FOREIGN KEY (HobbyNAME) REFERENCES Hobby(HobbyNAME),
    FOREIGN KEY (PersonId) REFERENCES Person(ID)
);

commit;