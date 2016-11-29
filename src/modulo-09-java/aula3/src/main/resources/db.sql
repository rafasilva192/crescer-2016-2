
--------------------------------------------------------
--  DDL for Sequence SEQ_CLIENT
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CLIENT"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_CONTRACT
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CONTRACT"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_CONTRACT_VALUE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CONTRACT_VALUE"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_COTACAO
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_COTACAO"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_CURRENCY_EXCHANGE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CURRENCY_EXCHANGE"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 2921 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_SERVICO
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SERVICO"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Sequence SEQ_USUARIO
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_USUARIO"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
/
--------------------------------------------------------
--  DDL for Table CLIENT
--------------------------------------------------------

  CREATE TABLE "CLIENT" ("ID_CLIENT" NUMBER(19,0), "DS_EMAIL" VARCHAR2(255 CHAR), "DS_PASSWORD" VARCHAR2(255 CHAR), "DS_PREFERRED_COIN" VARCHAR2(255 CHAR), "DS_STATE" VARCHAR2(255 CHAR), "DS_USER_NAME" VARCHAR2(255 CHAR), "NM_CLIENT" VARCHAR2(255 CHAR), "TP_PERMISSION" VARCHAR2(255 CHAR)) ;
/
--------------------------------------------------------
--  DDL for Table CONTRACT
--------------------------------------------------------

  CREATE TABLE "CONTRACT" ("ID_CONTRACT" NUMBER(19,0), "DS_DESCRIPTION" VARCHAR2(801 CHAR), "DS_STATE" VARCHAR2(255 CHAR), "DS_WEBSITE" VARCHAR2(255 CHAR), "NM_CONTRACT" VARCHAR2(255 CHAR), "CLIENT_ID_CLIENT" NUMBER(19,0)) ;
/
--------------------------------------------------------
--  DDL for Table CONTRACT_VALUE
--------------------------------------------------------

  CREATE TABLE "CONTRACT_VALUE" ("ID_CONTRACT_VALUE" NUMBER(19,0), "DS_COIN" VARCHAR2(255 CHAR), "DS_PERIODICITY" VARCHAR2(255 CHAR), "VL_AMOUNT_CONTRACT_VALUE" NUMBER(17,6), "VL_MONTHLY_USD" NUMBER(17,6), "CONTRACT_ID_CONTRACT" NUMBER(19,0)) ;
/
--------------------------------------------------------
--  DDL for Table COTACAO
--------------------------------------------------------

  CREATE TABLE "COTACAO" ("ID_COTACAO" NUMBER(19,0), "DS_COTACAO_DOLLAR_AUSTRALIANO" NUMBER(9,6), "DS_COTACAO_DOLLAR_CANADENSE" NUMBER(9,6), "DS_COTACAO_EURO" NUMBER(9,6), "DS_COTACAO_FRANCO_SUICO" NUMBER(9,6), "DS_COTACAO_LIBRA" NUMBER(9,6), "DS_COTACAO_REAL" NUMBER(9,6), "DS_COTACAO_YEN" NUMBER(9,6), "DS_COTACAO_YUAN" NUMBER(9,6), "DT_COTACAO" RAW(255)) ;
/
--------------------------------------------------------
--  DDL for Table CURRENCY_EXCHANGE
--------------------------------------------------------

  CREATE TABLE "CURRENCY_EXCHANGE" ("ID_CURRENCY_EXCHANGE" NUMBER(19,0), "DS_COIN" VARCHAR2(255 CHAR), "DT_CURRENCY_EXCHANGE" RAW(255), "VL_RATE" NUMBER(17,6)) ;
/
--------------------------------------------------------
--  DDL for Table SERVICO
--------------------------------------------------------

  CREATE TABLE "SERVICO" ("ID_SERVICO" NUMBER(19,0), "DS_DESCRICAO" VARCHAR2(801 CHAR), "DS_PERIODICIDADE" VARCHAR2(255 CHAR), "DS_SIMBOLO_MOEDA" VARCHAR2(255 CHAR), "DS_SITUACAO" VARCHAR2(255 CHAR), "DS_WEBSITE" VARCHAR2(255 CHAR), "NM_SERVICO" VARCHAR2(255 CHAR), "VL_MENSAL_USD" NUMBER(17,6), "VL_TOTAL_SERVICO" NUMBER(17,6), "USUARIO_ID_USUARIO" NUMBER(19,0)) ;
/
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "USUARIO" ("ID_USUARIO" NUMBER(19,0), "DS_EMAIL" VARCHAR2(255 CHAR), "DS_SENHA" VARCHAR2(255 CHAR), "DS_SITUACAO" VARCHAR2(255 CHAR), "DS_USER_NAME" VARCHAR2(255 CHAR), "NM_USUARIO" VARCHAR2(255 CHAR), "TP_PERMISSAO" VARCHAR2(255 CHAR)) ;
/
--------------------------------------------------------
--  DDL for Index UK_42VO2RRGXDG6VAV1OQ0KYTQBS
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_42VO2RRGXDG6VAV1OQ0KYTQBS" ON "CLIENT" ("DS_USER_NAME") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_STATE_CLIENT
--------------------------------------------------------

  CREATE INDEX "INDEX_STATE_CLIENT" ON "CLIENT" ("DS_STATE") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014962
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014962" ON "CLIENT" ("ID_CLIENT") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_NAME_CONTRACT
--------------------------------------------------------

  CREATE INDEX "INDEX_NAME_CONTRACT" ON "CONTRACT" ("NM_CONTRACT") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_CLIENT_CONTRACT
--------------------------------------------------------

  CREATE INDEX "INDEX_CLIENT_CONTRACT" ON "CONTRACT" ("CLIENT_ID_CLIENT") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_STATE_CONTRACT
--------------------------------------------------------

  CREATE INDEX "INDEX_STATE_CONTRACT" ON "CONTRACT" ("DS_STATE") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014969
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014969" ON "CONTRACT" ("ID_CONTRACT") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014976
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014976" ON "CONTRACT_VALUE" ("ID_CONTRACT_VALUE") ;
/
--------------------------------------------------------
--  DDL for Index UK_6XG5NGJOVETS7YS04V7SGJKB0
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_6XG5NGJOVETS7YS04V7SGJKB0" ON "CONTRACT_VALUE" ("CONTRACT_ID_CONTRACT") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_VL_MONTHLY_USD
--------------------------------------------------------

  CREATE INDEX "INDEX_VL_MONTHLY_USD" ON "CONTRACT_VALUE" ("VL_MONTHLY_USD") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_DT_COTACAO
--------------------------------------------------------

  CREATE INDEX "INDEX_DT_COTACAO" ON "COTACAO" ("DT_COTACAO") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014680
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014680" ON "COTACAO" ("ID_COTACAO") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014981
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014981" ON "CURRENCY_EXCHANGE" ("ID_CURRENCY_EXCHANGE") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_DT_CURRENCY_EXCHANGE
--------------------------------------------------------

  CREATE INDEX "INDEX_DT_CURRENCY_EXCHANGE" ON "CURRENCY_EXCHANGE" ("DT_CURRENCY_EXCHANGE") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_DS_COIN
--------------------------------------------------------

  CREATE INDEX "INDEX_DS_COIN" ON "CURRENCY_EXCHANGE" ("DS_COIN") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_NOME_SERVICO
--------------------------------------------------------

  CREATE INDEX "INDEX_NOME_SERVICO" ON "SERVICO" ("NM_SERVICO") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_VALOR_SERVICO
--------------------------------------------------------

  CREATE INDEX "INDEX_VALOR_SERVICO" ON "SERVICO" ("VL_TOTAL_SERVICO") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_GERENTE
--------------------------------------------------------

  CREATE INDEX "INDEX_GERENTE" ON "SERVICO" ("USUARIO_ID_USUARIO") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_SITUACAO_SERVICO
--------------------------------------------------------

  CREATE INDEX "INDEX_SITUACAO_SERVICO" ON "SERVICO" ("DS_SITUACAO") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014691
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014691" ON "SERVICO" ("ID_SERVICO") ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0014699
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014699" ON "USUARIO" ("ID_USUARIO") ;
/
--------------------------------------------------------
--  DDL for Index UK_T7NU60YWRAVOIE4XIO3ONI5WC
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_T7NU60YWRAVOIE4XIO3ONI5WC" ON "USUARIO" ("DS_USER_NAME") ;
/
--------------------------------------------------------
--  DDL for Index INDEX_SITUACAO_USUARIO
--------------------------------------------------------

  CREATE INDEX "INDEX_SITUACAO_USUARIO" ON "USUARIO" ("DS_SITUACAO") ;
/
--------------------------------------------------------
--  Constraints for Table CLIENT
--------------------------------------------------------

  ALTER TABLE "CLIENT" MODIFY ("ID_CLIENT" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("DS_EMAIL" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("DS_PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("DS_PREFERRED_COIN" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("DS_STATE" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("DS_USER_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("NM_CLIENT" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" MODIFY ("TP_PERMISSION" NOT NULL ENABLE);
 
  ALTER TABLE "CLIENT" ADD PRIMARY KEY ("ID_CLIENT") ENABLE;
 
  ALTER TABLE "CLIENT" ADD CONSTRAINT "UK_42VO2RRGXDG6VAV1OQ0KYTQBS" UNIQUE ("DS_USER_NAME") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CONTRACT
--------------------------------------------------------

  ALTER TABLE "CONTRACT" MODIFY ("ID_CONTRACT" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" MODIFY ("DS_DESCRIPTION" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" MODIFY ("DS_STATE" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" MODIFY ("DS_WEBSITE" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" MODIFY ("NM_CONTRACT" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" MODIFY ("CLIENT_ID_CLIENT" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT" ADD PRIMARY KEY ("ID_CONTRACT") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CONTRACT_VALUE
--------------------------------------------------------

  ALTER TABLE "CONTRACT_VALUE" MODIFY ("ID_CONTRACT_VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" MODIFY ("DS_COIN" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" MODIFY ("DS_PERIODICITY" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" MODIFY ("VL_AMOUNT_CONTRACT_VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" MODIFY ("VL_MONTHLY_USD" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" MODIFY ("CONTRACT_ID_CONTRACT" NOT NULL ENABLE);
 
  ALTER TABLE "CONTRACT_VALUE" ADD PRIMARY KEY ("ID_CONTRACT_VALUE") ENABLE;
 
  ALTER TABLE "CONTRACT_VALUE" ADD CONSTRAINT "UK_6XG5NGJOVETS7YS04V7SGJKB0" UNIQUE ("CONTRACT_ID_CONTRACT") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table COTACAO
--------------------------------------------------------

  ALTER TABLE "COTACAO" MODIFY ("ID_COTACAO" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_DOLLAR_AUSTRALIANO" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_DOLLAR_CANADENSE" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_EURO" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_FRANCO_SUICO" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_LIBRA" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_REAL" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_YEN" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DS_COTACAO_YUAN" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" MODIFY ("DT_COTACAO" NOT NULL ENABLE);
 
  ALTER TABLE "COTACAO" ADD PRIMARY KEY ("ID_COTACAO") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CURRENCY_EXCHANGE
--------------------------------------------------------

  ALTER TABLE "CURRENCY_EXCHANGE" MODIFY ("ID_CURRENCY_EXCHANGE" NOT NULL ENABLE);
 
  ALTER TABLE "CURRENCY_EXCHANGE" MODIFY ("DS_COIN" NOT NULL ENABLE);
 
  ALTER TABLE "CURRENCY_EXCHANGE" MODIFY ("DT_CURRENCY_EXCHANGE" NOT NULL ENABLE);
 
  ALTER TABLE "CURRENCY_EXCHANGE" MODIFY ("VL_RATE" NOT NULL ENABLE);
 
  ALTER TABLE "CURRENCY_EXCHANGE" ADD PRIMARY KEY ("ID_CURRENCY_EXCHANGE") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table SERVICO
--------------------------------------------------------

  ALTER TABLE "SERVICO" MODIFY ("ID_SERVICO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("DS_DESCRICAO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("DS_PERIODICIDADE" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("DS_SIMBOLO_MOEDA" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("DS_SITUACAO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("DS_WEBSITE" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("NM_SERVICO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("VL_MENSAL_USD" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("VL_TOTAL_SERVICO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" MODIFY ("USUARIO_ID_USUARIO" NOT NULL ENABLE);
 
  ALTER TABLE "SERVICO" ADD PRIMARY KEY ("ID_SERVICO") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USUARIO" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("DS_EMAIL" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("DS_SENHA" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("DS_SITUACAO" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("DS_USER_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("NM_USUARIO" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" MODIFY ("TP_PERMISSAO" NOT NULL ENABLE);
 
  ALTER TABLE "USUARIO" ADD PRIMARY KEY ("ID_USUARIO") ENABLE;
 
  ALTER TABLE "USUARIO" ADD CONSTRAINT "UK_T7NU60YWRAVOIE4XIO3ONI5WC" UNIQUE ("DS_USER_NAME") ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table CONTRACT
--------------------------------------------------------

  ALTER TABLE "CONTRACT" ADD CONSTRAINT "FK_O7ODW75F2GRYF4WL3PMMQ778T" FOREIGN KEY ("CLIENT_ID_CLIENT") REFERENCES "CLIENT" ("ID_CLIENT") ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table CONTRACT_VALUE
--------------------------------------------------------

  ALTER TABLE "CONTRACT_VALUE" ADD CONSTRAINT "FK_6XG5NGJOVETS7YS04V7SGJKB0" FOREIGN KEY ("CONTRACT_ID_CONTRACT") REFERENCES "CONTRACT" ("ID_CONTRACT") ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table SERVICO
--------------------------------------------------------

  ALTER TABLE "SERVICO" ADD CONSTRAINT "FK_H4OW4GEXEHNOTSHWJSBFKATGD" FOREIGN KEY ("USUARIO_ID_USUARIO") REFERENCES "USUARIO" ("ID_USUARIO") ENABLE;
/
