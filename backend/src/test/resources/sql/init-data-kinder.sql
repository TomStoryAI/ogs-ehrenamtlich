INSERT INTO KINDER  (NAME, SCHULJAHR) VALUES ('Benjamin B',1);
INSERT INTO KINDER  (NAME, SCHULJAHR) VALUES ('Bibi',1);
INSERT INTO KINDER  (NAME, SCHULJAHR) VALUES ('Maja',1);
INSERT INTO KINDER  (NAME, SCHULJAHR) VALUES ('SOS Croco',1);
INSERT INTO KINDER  (NAME, SCHULJAHR) VALUES ('Xena',1);

-- One Wunsch object needs to be later updated for a child.
-- Benjamin
INSERT INTO WUENSCHE (ID,  wunsch_ag_id,prioritaet)
VALUES (1,4,1);
INSERT INTO WUENSCHE (ID,  wunsch_ag_id,prioritaet)
VALUES (2,4,1);
-- Maja
INSERT INTO WUENSCHE (ID,  wunsch_ag_id,prioritaet)
VALUES (3,1,1);
-- SOS CROCO
-- Xena
INSERT INTO WUENSCHE (ID,  wunsch_ag_id,prioritaet)
VALUES (4,2,1);

INSERT INTO kinder_wunsch (kind_id, wunsch_id)
VALUES(1,4);

INSERT INTO kinder_wunsch (kind_id, wunsch_id)
VALUES(2,4);

INSERT INTO kinder_wunsch (kind_id, wunsch_id)
VALUES(3,1);

INSERT INTO kinder_wunsch (kind_id, wunsch_id)
VALUES(4,2);