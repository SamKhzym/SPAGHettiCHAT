USE spaghettichat;

INSERT INTO account (employeeId, firstName, lastName, isAdmin)
VALUES 
    ('khzyms', 'Sam', 'Khzym', TRUE),
    ('khakiana', 'Amaan', 'Khakiani', TRUE),
    ('issah3', 'Hamza', 'Issa', TRUE),
    ('grewap17', 'Preston', 'Grewal', TRUE),
    ('athukorg', 'Gayan', 'Athukorala', TRUE),
    ('shmoej69', 'Joe', 'Shmoe', FALSE);

INSERT INTO message (msgId, msgString, sender, lastMsgId, ts, isVanish)
VALUES
    (1, 'yoooo dude have you heard of this new secure messaging app?', 'khzyms', NULL, CURRENT_TIMESTAMP, FALSE),
    (2, 'nah what\'s it called?', 'khakiana', 1, CURRENT_TIMESTAMP, FALSE),
    (3, 'spaghettichat', 'khzyms', 2, CURRENT_TIMESTAMP, FALSE),
    (4, 'will have to check it out', 'khakiana', 3, CURRENT_TIMESTAMP, FALSE);

INSERT INTO chat(chatId, creator, receiver, lastMsg, creationTs)
VALUES
    (1, 'khzyms', 'khakiana', 4, CURRENT_TIMESTAMP);
