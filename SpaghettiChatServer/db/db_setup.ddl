# ONLY RUN THIS TO COMPLETELY RESET DATABASE WITH ALL DATA
DROP DATABASE spaghettichat;

CREATE DATABASE spaghettichat;

USE spaghettichat;

CREATE TABLE Account (
	employeeId VARCHAR(50) PRIMARY KEY NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	isAdmin BIT NOT NULL
);

CREATE TABLE Message (
	msgId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	msgString VARCHAR(1000) NOT NULL,
	sender VARCHAR(50) NOT NULL,
	ts TIMESTAMP NOT NULL,
	isVanish BIT NOT NULL,
	FOREIGN KEY (sender) REFERENCES Account(employeeId)
);

CREATE TABLE Chat (
	chatId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	creatorId VARCHAR(50) NOT NULL,
	creationTs TIMESTAMP NOT NULL,
	FOREIGN KEY (creatorId) REFERENCES Account(employeeId)
);

CREATE TABLE AccountInChat (
	chatId INT NOT NULL,
	employeeId VARCHAR(50) NOT NULL,
	PRIMARY KEY (chatId, employeeId),
	FOREIGN KEY (chatId) REFERENCES Chat(chatId),
	FOREIGN KEY (employeeId) REFERENCES Account(employeeId)
);

CREATE TABLE MessageInChat (
	chatId INT NOT NULL,
	msgId INT NOT NULL,
	PRIMARY KEY (chatId, msgId),
	FOREIGN KEY (chatId) REFERENCES Chat(chatId),
	FOREIGN KEY (msgId) REFERENCES Message(msgId)
);

# set password for root user to 'root'
ALTER USER 'root'@'localhost' IDENTIFIED VIA mysql_native_password USING PASSWORD('root');