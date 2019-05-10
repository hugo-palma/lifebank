
CREATE TABLE lb_bank.lb_bank_account
(
 acc_id             varchar(10) NOT NULL ,
 acc_fecha_creacion timestamp NOT NULL ,
 acc_monto          double precision NOT NULL ,
 CONSTRAINT PK_lb_bank_account PRIMARY KEY (acc_id)
);

CREATE TABLE lb_bank.lb_transferences_detail
(
 dtr_id                serial NOT NULL,
 dtr_transfer_date     timestamp NOT NULL ,
 dtr_amount_transfered double precision NOT NULL ,
 dtr_emitter_session   varchar(50) NOT NULL ,
 dtr_description       varchar(250) NOT NULL ,


 CONSTRAINT PK_lb_transferences_detail PRIMARY KEY (dtr_id)
);

CREATE TABLE lb_bank.lb_transferences
(
 tra_emitter_account  varchar(10) NOT NULL ,
 tra_receiver_account varchar(10) NOT NULL ,
 tra_dtr_id           int NOT NULL ,


 CONSTRAINT PK_lb_transferences PRIMARY KEY (tra_emitter_account, tra_receiver_account, tra_dtr_id),
 CONSTRAINT FK_13 FOREIGN KEY (tra_receiver_account)  REFERENCES lb_bank.lb_bank_account(acc_id),
 CONSTRAINT FK_23 FOREIGN KEY (tra_dtr_id)  REFERENCES lb_bank.lb_transferences_detail(dtr_id),
 CONSTRAINT FK_9 FOREIGN KEY (tra_emitter_account)  REFERENCES lb_bank.lb_bank_account(acc_id)
);


--INSERTS
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('0123456789', '2007-04-21 13:54:01.601', 960.54);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('0123456790', '2003-10-16 14:00:18.646', 1000);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('3', '2009-04-13 12:36:39.714', 0.842352064);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('4', '1996-04-20 17:37:16.453', 0.1426598912);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('5', '1991-09-05 08:40:27.805', 0.1172434432);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('6', '2016-03-11 16:13:20.481', 0.1174148864);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('7', '2001-07-09 09:58:16.338', 0.90815016);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('8', '1995-03-31 04:39:58.000', 0.35711072);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('9', '1997-10-26 04:55:10.790', 0.595208704);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto)
VALUES('10', '2001-02-04 02:25:54.348', 0.1029066752);
