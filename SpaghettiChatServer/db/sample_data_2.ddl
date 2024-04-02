USE spaghettichat;

INSERT INTO message (msgId, msgString, sender, lastMsgId, ts, isVanish)
VALUES
    (5, 'what do you think about 3a04?', 'athukorg', NULL, CURRENT_TIMESTAMP, FALSE),
    (6, 'kinda wack ngl', 'grewap17', 5, CURRENT_TIMESTAMP, FALSE),
    (7, 'frfr', 'athukorg', 6, CURRENT_TIMESTAMP, FALSE);

INSERT INTO chat(chatId, creator, receiver, lastMsg, creationTs)
VALUES
    (2, 'athukorg', 'grewap17', 4, CURRENT_TIMESTAMP);
