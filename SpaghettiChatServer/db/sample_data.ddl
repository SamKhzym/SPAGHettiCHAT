USE spaghettichat;

INSERT INTO Account (employeeId, firstName, lastName, isAdmin)
VALUES 
    ('khzyms', 'Sam', 'Khzym', TRUE),
    ('khakiana', 'Amaan', 'Khakiani', TRUE),
    ('issah3', 'Hamza', 'Issa', TRUE),
    ('grewap17', 'Preston', 'Grewal', TRUE),
    ('athukorg', 'Gayan', 'Athukorala', TRUE),
    ('shmoej69', 'Joe', 'Shmoe', FALSE);

INSERT INTO Message (msgId, msgString, sender, ts, isVanish)
VALUES
    (1, 'yoooo dude have you heard of this new secure messaging app?', 'khzyms', CURRENT_TIMESTAMP, FALSE),
    (2, 'nah what\'s it called?', 'khakiana', CURRENT_TIMESTAMP, FALSE),
    (3, 'spaghettichat', 'khzyms', CURRENT_TIMESTAMP, FALSE),
    (4, 'will have to check it out', 'khakiana', CURRENT_TIMESTAMP, FALSE);

INSERT INTO Chat(chatId, creatorId, creationTs)
VALUES
    (1, 'khzyms', CURRENT_TIMESTAMP);

INSERT INTO AccountInChat(chatId, employeeId)
VALUES
    (1, 'khzyms'),
    (1, 'khakiana');

INSERT INTO MessageInChat(chatId, msgId)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4);
