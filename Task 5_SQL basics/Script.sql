/*
 * create table Manger contain

id, name , age , birth_date , address
----------------------------------
alter table manger drop address column
alter table manger add column (city_address, street) 
-------------------------------------
modify column name to full_name
-------------------------------------
make this table just for read
-------------------------------
create table same as  Manger with name Owner
just has colum id, name, birth_date 
----------------------------------------
rename manger table name to Master
-----------------------------------------
drop all tables     
 * 
 */

CREATE TABLE Manager(
			id NUMBER(3),
			name VARCHAR(50),
			age NUMBER(2),
			bith_date DATE,
			address VARCHAR(70)
);
ALTER TABLE MANAGER DROP COLUMN ADDRESS;
ALTER TABLE MANAGER ADD (city_address VARCHAR(255),street VARCHAR(255));
ALTER TABLE MANAGER RENAME COLUMN  name TO full_name;
ALTER TABLE manager READ ONLY ;
CREATE TABLE Owner AS SELECT id, full_name AS name,birth_date FROM manager WHERE 1=0;
ALTER TABLE MANAGER RENAME TO Master;
DROP TABLE MASTER ;
DROP TABLE OWNER ;






