INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 3, '421.512.111-0', 2000.00, 'Gustavo Tiago da Silva', 'gustavo@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS' );
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 5, '521.534.265-X', 3000.00, 'Emerson da Silva', 'emerson.silva@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 1, '621.678.654-1', 4000.00, 'José Paulo', 'jose.paulo@hotmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 8, '721.923.345-2', 5000.00, 'Nélio Alves', 'nelio.alves@outlook.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 0, '121.097.876-3', 6000.00, 'Henrique Lima', 'henrique.lima@hotmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 7, '221.154.435-4', 7000.00, 'Pedro Henrique Souza', 'pedro.souza@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 2, '321.963.213-5', 8000.00, 'Maria da Silva', 'maria.silva@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 2, '421.126.233-6', 9000.00, 'Cláudio Xavier', 'claudio@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');
INSERT INTO Tb_Client (BIRTH_DATE, CHILDREN, CPF, INCOME, NAME, EMAIL, PASSWORD) VALUES (NOW(), 1, '521.356.787-7', 10000.00, 'Paulo Augusto', 'paulo.augusto@gmail.com','$2y$12$sSqU32cf7PDmQIlnC6qGVexk1wQH.4Pl0pugy4igCSpP4GjIA3CkS');

INSERT INTO tb_role (name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_client_role (client_id, role_id) VALUES (1, 1);
INSERT INTO tb_client_role (client_id, role_id) VALUES (2, 1);
INSERT INTO tb_client_role (client_id, role_id) VALUES (2, 2);