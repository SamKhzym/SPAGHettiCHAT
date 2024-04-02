# ONLY RUN THIS TO COMPLETELY RESET DATABASE WITH ALL DATA
DROP DATABASE spaghettichat;

CREATE DATABASE spaghettichat;

USE spaghettichat;

CREATE TABLE account (
	employeeId VARCHAR(50) PRIMARY KEY NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	isAdmin BIT NOT NULL
);

CREATE TABLE message (
	msgId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	msgString VARCHAR(1000) NOT NULL,
	sender VARCHAR(50) NOT NULL,
	lastMsgId INT,
	ts TIMESTAMP NOT NULL,
	isVanish BIT NOT NULL,
	FOREIGN KEY (lastMsgId) REFERENCES message(msgId),
	FOREIGN KEY (sender) REFERENCES account(employeeId)
);

CREATE TABLE chat (
	chatId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	creator VARCHAR(50) NOT NULL,
	receiver VARCHAR(50) NOT NULL,
	lastMsg INT,
	creationTs TIMESTAMP NOT NULL,
	FOREIGN KEY (creator) REFERENCES account(employeeId),
	FOREIGN KEY (receiver) REFERENCES account(employeeId),
	FOREIGN KEY (lastMsg) REFERENCES message(msgId)
);


