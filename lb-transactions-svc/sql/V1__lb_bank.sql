drop TABLE if exists lb_bank.lb_transferences;
drop TABLE if exists lb_bank.lb_transferences_detail;
drop table if exists lb_bank.lb_account_loan_payments;
drop table if exists lb_bank.lb_loan_payments_details;
drop table if exists lb_bank.lb_account_creditcard_payments;
drop table if exists lb_bank.lb_creditcard_payments_details;
drop table if exists lb_bank.lb_loans;
drop table if exists lb_bank.lb_card_payments;
drop table if exists lb_bank.lb_credit_cards;
drop table if exists lb_bank.lb_bank_account;
drop table if exists lb_bank.lb_favorites;
drop table if exists lb_bank.lb_client;

CREATE TABLE lb_bank.lb_client
(
 cli_id       serial NOT NULL ,
 cli_mail     varchar(50) NOT NULL ,
 cli_password varchar(50) NOT NULL ,
 cli_document varchar(50) NOT NULL ,
 cli_username varchar(50) NOT NULL ,

 CONSTRAINT PK_lb_client PRIMARY KEY (cli_id)
);

CREATE TABLE lb_bank.lb_favorites
(
 fav_id            serial NOT NULL ,
 fav_creation_date timestamp NOT NULL ,
 fav_state         varchar(1) NOT NULL ,
 fav_cli_id        int NOT NULL ,
 fav_product_type  varchar(20) NOT NULL ,
 fav_product_code  varchar(50) NOT NULL ,
 fav_email         varchar(50) NOT NULL ,
 fav_name          varchar(50) NOT NULL ,


 CONSTRAINT PK_lb_favorites PRIMARY KEY (fav_id),
 CONSTRAINT FK_109 FOREIGN KEY (fav_cli_id)  REFERENCES lb_bank.lb_client(cli_id)
);

CREATE TABLE lb_bank.lb_bank_account
(
 acc_id             varchar(10) NOT NULL ,
 acc_fecha_creacion timestamp NOT NULL ,
 acc_monto          double precision NOT NULL ,
 acc_cli_id             int NOT NULL ,


 CONSTRAINT PK_lb_bank_account PRIMARY KEY (acc_id),
 CONSTRAINT FK_33 FOREIGN KEY (acc_cli_id)  REFERENCES lb_bank.lb_client(cli_id)
);

CREATE TABLE lb_bank.lb_transferences_detail
(
 dtr_id                serial NOT NULL,
 dtr_transfer_date     timestamp NOT NULL ,
 dtr_amount_transfered double precision NOT NULL ,
 dtr_authorization_number   varchar(50) NOT NULL ,
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

-- ************************************** [lb_bank].[lb_loan_payments_details]

CREATE TABLE lb_bank.lb_loan_payments_details
(
 lpd_id                   int NOT NULL ,
 lpd_payment_date         timestamp NOT NULL ,
 lpd_payment_amount       double precision NOT NULL ,
 lpd_authorization_number varchar(50) NOT NULL ,
 lpd_description          varchar(50) NOT NULL ,


 CONSTRAINT PK_lb_loan_payments_details PRIMARY KEY (lpd_id)
);

-- ************************************** [lb_bank].[lb_loans]

CREATE TABLE lb_bank.lb_loans
(
 loa_id              int NOT NULL ,
 loa_start_date      timestamp NOT NULL ,
 loa_total_amount    double precision NOT NULL ,
 loa_debt            double precision NOT NULL ,
 loa_interest_rate   double precision NOT NULL ,
 loa_interest_amount double precision NOT NULL ,
 loa_cli_id          int NOT NULL ,


 CONSTRAINT PK_lb_loans PRIMARY KEY (loa_id),
 CONSTRAINT FK_58 FOREIGN KEY (loa_cli_id)  REFERENCES lb_bank.lb_client(cli_id)
);


-- ************************************** [lb_bank].[lb_creditcard_payments_details]

CREATE TABLE lb_bank.lb_creditcard_payments_details
(
 cpd_id                   int NOT NULL ,
 cpd_payment_date         timestamp NOT NULL ,
 cpd_payment_amount       double precision NOT NULL ,
 cpd_authorization_number varchar(50) NOT NULL ,
 cpd_description          varchar(50) NOT NULL ,


 CONSTRAINT PK_lb_creditcard_payments_details PRIMARY KEY (cpd_id)
);


-- ************************************** [lb_bank].[lb_credit_cards]

CREATE TABLE lb_bank.lb_credit_cards
(
 cre_id                   int NOT NULL ,
 cre_amount_limit         double precision NOT NULL ,
 cre_creation_date		  timestamp not null,
 cre_amount_available     double precision NOT NULL ,
 cre_interest_rate        double precision NOT NULL ,
 cre_interest_accumulated double precision NOT NULL ,
 cre_cut_day              int NOT NULL ,
 cre_cli_id               int NOT NULL ,


 CONSTRAINT PK_lb_credit_cards PRIMARY KEY (cre_id),
 CONSTRAINT FK_44 FOREIGN KEY (cre_cli_id)  REFERENCES lb_bank.lb_client(cli_id)
);


-- ************************************** [lb_bank].[lb_card_payments]

CREATE TABLE lb_bank.lb_card_payments
(
 cpa_id                   int NOT NULL ,
 cpa_cre_id               int NOT NULL ,
 cpa_payment_amount       double precision NOT NULL ,
 cpa_payment_description  varchar(50) NOT NULL ,
 cpa_payment_date         timestamp NOT NULL ,
 cpa_authorization_number varchar(50) NOT NULL ,


 CONSTRAINT PK_lb_card_payments PRIMARY KEY (cpa_id),
 CONSTRAINT FK_97 FOREIGN KEY (cpa_cre_id)  REFERENCES lb_bank.lb_credit_cards(cre_id)
);




-- ****************** SqlDBM: Microsoft SQL Server ******************
-- ******************************************************************

-- ************************************** [lb_bank].[lb_account_loan_payments]

CREATE TABLE lb_bank.lb_account_loan_payments
(
 alp_acc_id varchar(10) NOT NULL ,
 alp_loa_id int NOT NULL ,
 alp_lpd_id int NOT NULL ,


 CONSTRAINT PK_lb_account_loan_payments PRIMARY KEY (alp_acc_id, alp_loa_id, alp_lpd_id),
 CONSTRAINT FK_62 FOREIGN KEY (alp_acc_id)  REFERENCES lb_bank.lb_bank_account(acc_id),
 CONSTRAINT FK_66 FOREIGN KEY (alp_loa_id)  REFERENCES lb_bank.lb_loans(loa_id),
 CONSTRAINT FK_76 FOREIGN KEY (alp_lpd_id)  REFERENCES lb_bank.lb_loan_payments_details(lpd_id)
);

-- ************************************** [lb_bank].[lb_account_creditcard_payments]

CREATE TABLE lb_bank.lb_account_creditcard_payments
(
 acp_acc_id varchar(10) NOT NULL ,
 acp_cre_id int NOT NULL ,
 acp_cpd_id int NOT NULL ,


 CONSTRAINT PK_lb_account_creditcard_payments PRIMARY KEY (acp_acc_id, acp_cre_id, acp_cpd_id),
 CONSTRAINT FK_80 FOREIGN KEY (acp_acc_id)  REFERENCES lb_bank.lb_bank_account(acc_id),
 CONSTRAINT FK_83 FOREIGN KEY (acp_cre_id)  REFERENCES lb_bank.lb_credit_cards(cre_id),
 CONSTRAINT FK_94 FOREIGN KEY (acp_cpd_id)  REFERENCES lb_bank.lb_creditcard_payments_details(cpd_id)
);




--INSERTS
--clientes
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(1, 'on pr', '123', ' ut aliquip ex ea commod', 'amco laboris nisi ut aliquip ex e');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(2, ' ea commodo cons', '123', ' aute irure do', 'officia deserunt');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(3, 'im id est ', '123', 'nisi ut aliquip ex e', 'atat non proide');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(4, ' in voluptate velit esse cillum', '123', 'labor', 'lo');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(5, 'at ', '123', 'irure dolor in reprehenderit in voluptate velit ', 's nisi ut aliquip ex ea commo');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(6, 'cididunt ', '123', 'or sit amet, consectetur adipiscing elit, sed do', ', quis nostrud exercitation ullamco laboris nisi');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(7, 'ui officia deserunt mollit anim', '123', 'uptate velit esse c', ' do');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(8, ' dolor in reprehenderit in vo', '123', 't esse c', 'im veniam, quis nostrud exercitation ullamco l');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(9, 'mpor incididunt ut labore et ', '123', 'd do eiusmod', 'eu');
INSERT INTO lb_bank.lb_client
(cli_id, cli_mail, cli_password, cli_document, cli_username)
VALUES(10, 'nostrud exercitation ul', '123', 'ute irure dolor in reprehenderit in voluptate ', 'o laboris nisi ut al');

--cuentas
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('0123456789', '2007-04-21 13:54:01.601', 960.54, 1);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('0123456790', '2003-10-16 14:00:18.646', 1000, 1);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('3', '2009-04-13 12:36:39.714', 0.842352064, 1);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('4', '1996-04-20 17:37:16.453', 0.1426598912, 2);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('5', '1991-09-05 08:40:27.805', 0.1172434432, 2);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('6', '2016-03-11 16:13:20.481', 0.1174148864, 3);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('7', '2001-07-09 09:58:16.338', 0.90815016, 4);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('8', '1995-03-31 04:39:58.000', 0.35711072, 5);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('9', '1997-10-26 04:55:10.790', 0.595208704, 6);
INSERT INTO lb_bank.lb_bank_account
(acc_id, acc_fecha_creacion, acc_monto, acc_cli_id)
VALUES('10', '2001-02-04 02:25:54.348', 0.1029066752, 7);
--Detalles transferencias
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(1, '2000-01-01 00:00:00.000', 120.12, 'dca6a1e1-f9cd-45f1-b151-6e095753fe80', 'ru');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(2, '2000-01-01 00:00:00.000', 54.64, '78c1815c-01a5-4dff-ad61-1ad8c2c0fbb5', 'giat nulla pa');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(3, '2000-01-01 00:00:00.000', 1240.48, 'd855bd28-bb2f-49f3-b7c9-06b9d7d2dc5a', 'in reprehender');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(4, '2000-01-01 00:00:00.000', 0.234795024, '4175baa5-b034-430e-b49e-cb36a3468a97', 'up');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(5, '2000-01-01 00:00:00.000', 0.525511616, 'ec5555ba-6be9-48b1-b5b1-5944326545e4', 'mod tempor incididu');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(6, '2000-01-01 00:00:00.000', 0.332424448, '9aa94edb-f247-49ce-a69e-420647e7b55c', 'e ve');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(7, '2000-01-01 00:00:00.000', 0.155315904, 'e7489b12-d5a8-45d6-9583-12bff25a8f53', 'labore et');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(8, '2000-01-01 00:00:00.000', 0.1105631744, '977f8c69-d799-44e7-bc07-87c14853b703', 'llamco laboris nis');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(9, '2000-01-01 00:00:00.000', 0.277153984, '461a7e74-6ad3-4531-b30f-315c93a32540', 'atur.');
INSERT INTO lb_bank.lb_transferences_detail
(dtr_id, dtr_transfer_date, dtr_amount_transfered, dtr_authorization_number, dtr_description)
VALUES(10, '2000-01-01 00:00:00.000', 0.161364896, '5225ccde-5464-4766-aab1-48281351a015', 'i ');
--transacciones
insert into lb_bank.lb_transferences values('0123456789', '0123456790', 1);
insert into lb_bank.lb_transferences values('0123456790', '0123456789', 1);
