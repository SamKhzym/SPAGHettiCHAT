USE spaghettichat;

INSERT INTO Message (msgId, msgString, sender, ts, isVanish)
VALUES
    (5, 'what do you think about 3a04?', 'athukorg', CURRENT_TIMESTAMP, FALSE),
    (6, 'kinda wack ngl', 'grewap17', CURRENT_TIMESTAMP, FALSE),
    (7, 'frfr', 'athukorg', CURRENT_TIMESTAMP, FALSE);

INSERT INTO Chat(chatId, creatorId, creationTs)
VALUES
    (2, 'athukorg', CURRENT_TIMESTAMP);

INSERT INTO AccountInChat(chatId, employeeId)
VALUES
    (2, 'athukorg'),
    (2, 'grewap17');

INSERT INTO MessageInChat(chatId, msgId)
VALUES
    (2, 5),
    (2, 6),
    (2, 7);