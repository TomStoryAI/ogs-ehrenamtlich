-- One Wunsch object needs to be later updated for a child.
INSERT INTO WUENSCHE (ID, kind_id, wunschag1_id, wunschag2_id, wunschag3_id, wunschag4_id)
VALUES (1,1,1,2,NULL,NULL);
UPDATE KINDER SET Kinder.wunsch_id = 1 where KINDER.ID == 1;

INSERT INTO WUENSCHE (ID, kind_id, wunschag1_id, wunschag2_id, wunschag3_id, wunschag4_id)
VALUES (1,1,1,2,NULL,NULL);
UPDATE KINDER SET Kinder.wunsch_id = 2 where KINDER.ID == 1;