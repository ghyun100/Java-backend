SELECT * FROM hotel.custom;

#내용
-- 내용
/* 부분 주석 */
/* 
여러줄
주석
*/

# DDL (데이터 정의어)
# 데이터 베이스 또는 테이블(뷰, 인덱스, 프로시저...)을 생성, 수정, 삭제할 때 
# 사용하는 SQL문

-- CREATE 문
-- 데이터베이스, 테이블 등을 생성할 때 사용하는 SQL문
-- 데이터베이스 생성
-- CREATE DATABASE 데이터베이스명;

CREATE DATABASE Hotel;

SHOW DATABASES;

-- 데이터베이스를 생성했으면 사용할 데이터베이스를 선택
-- USE 데이터베이스명;

USE Hotel;

-- 테이블 생성
-- CREATE TABLE 테이블명 (
-- 필드명 데이터타입(데이터길이) 제약조건,
-- ...
-- );

CREATE TABLE Custom (
	id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(30) UNIQUE,
    age INT,
    address TEXT,
    accept_marketing BOOLEAN DEFAULT false
);

SHOW TABLES;

-- 데이터베이스 수정
-- ALTER DATABASE 데이터베이스명 속성명 = 값;

-- 테이블 수정
-- ALTER TABLE 테이블명

-- 테이블 필드 추가
-- ALTER TABLE 테이블명 ADD 필드명 데이터타입(데이터길이) 제약조건;
-- 테이블 필드 삭제
-- ALTER TABLE 테이블명 DROP 필드명;
-- 테이블 필드 수정
-- ALTER TABLE 테이블명 MODIFY COLUMN 필드명 데이터타입(데이터길이) 제약조건;

-- 데이터베이스 삭제
-- DROP DATABASE 데이터베이스명;

-- 테이블삭제
-- DROP TABLE 테이블명;
-- TRUNCATE TABLE 테이블명;

-- DROP TABLE 테이블명 : 테이블의 정의 자체를 제거
-- TRUNCATE  TABLE 테이블명 : 테이블의 정의만 남기고 모두 제거 (생성 초기상태로 돌려놓음)

-- DML (데이터 조작어)
-- 데이터베이스 테이블에 래코드를 삽입, 수정, 삭제, 검색 작업을 수행시키고자 할 때 사용하는 SQL문

-- 삽입문 (INSERT INTO)
-- 해당 테이블에 레코드를 삽입 할 때 사용하는 SQL문
-- INSERT INTO 테이블명 (필드명1, 필드명2, ...)
-- VALUES (필드1의 데이터, 필드2의 데이터, ...);

INSERT INTO Custom(id, name) VALUES (1, 'Jone Doe');
INSERT INTO Custom(id, email) VALUES (5, 'qwer@qwer'); -- 필수 값 미입력
INSERT INTO Custom(id, name, email) VALUES (1, 'Jone Doe', 'qwer@qwer'); -- 기본키 중복


SELECT * FROM Custom;

-- 모든 필드에 값을 넣을 때:
-- INSERT INTO 테이블명
-- VALUES (데이터1, 데이터2, ...);
 
-- 필드 정의를 선언했을 때 그 순서대로 넣어 줘야됨

INSERT INTO Custom 
VALUES (10, 'Michle', 'rewq@qwer.com', 30, 'This is Address', true);

INSERT INTO Custom
VALUES (11, 'Jihoon' , 'lacls159@gmail.com', 31, 'Busan', true);

INSERT INTO Custom 
VALUES (12, 'Michle', 'rewq1@qwer.com', 30, 'This is Address');

-- 수정문 (UPDATE)
-- 해당 테잉블에서 특정 필드의 값을 수정하고자 할 때 사용하는 SQL문

-- UPDATE 테이블명 SET 필드명1=데이터1, 필드명2=데이터2, ...;
UPDATE Custom SET accept_marketing = false;
UPDATE Custom SET accept_marketing = true, age = 10;

-- UPDATE 테이블명 SET 필드명1=데이터1, ...
-- WHERE 조건(ex 필드명 = 데이터);
UPDATE Custom SET email = 'email@email.com'
WHERE id = 1; 

-- 삭제문 (DELETE)
-- 해당 테이블에서 레코드를 삭제할 때 사용하는 SQL문

-- DELETE FROM 테이블명;
DELETE FROM Custom;

-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM Custom WHERE name = 'Jone Doe';

-- 검색문 (SELECT)
-- 해당 테이블에서 특정 필드를 검색하고자 할 때 사용하는 SQL문

-- SELECT 필드명1, 필드명2, ... FROM 테이블명;
SELECT id, name FROM Custom;

-- SELECT * FROM 테이블명;
SELECT * FROM Custom;

-- 필드에 별칭 사용
SELECT name AS 'Full Name'
FROM Custom;

-- 테이블에 별칭 사용
SELECT name
FROM Custom AS C; -- 여기서는 테이블에 별칭을 왜쓰는지 모르겠음..중복되는게 있을때 쓰기 위한게 별칭이라서 여기서는 굳이 필요없음

-- 중복 제거 (DISTINCT)
SELECT DISTINCT name FROM Custom;

-- 연산자
-- 비교연산

-- BETWEEN a AND b
-- a 보다 크거나 같으면서 b보다 작거나 같으면 true를 반환
SELECT * FROM Custom
WHERE age BETWEEN 10 AND 20;

-- IN()
-- 인수로 전달된 값과 동일한 값이 하나라도 존재한다면 true를 반환
SELECT * FROM Custom
WHERE name IN('John Doe', 'Micle', 'James');
-- (위와 동일)
-- SELECT * FROM Custom
-- WHERE name = 'John Doe'
-- OR name = 'Micle'
-- OR name = 'James';

-- IS 
-- 비교 대상이 Boolean 형태일 때 사용하는 비교 연산자
SELECT * FROM Custom
WHERE accept_marketing IS true;

-- IS NULL
-- 비교 대상이 NULL 이면 true를 반환
SELECT * FROM Custom
WHERE email IS NULL; 

-- LIKE
-- 문자열의 패턴을 비교하여 동일한 패턴을 가지고 있는 문자열이면 true를 반환

-- 와일드 카드(패턴을 적용할 때 사용) 
-- % : 0개 이상의 패턴 
-- _ : 1개의 패턴 
SELECT * FROM Custom
WHERE email LIKE '%gmail%'; 

-- Constraint (제약조건)
-- RDBMS에서 삽입, 수정, 삭제에 대해서 무결성을 보장해주는 조건

-- NOT NULL
-- 입력 또는 수정 작업에 있어서 해당 필드에 Null이 올 수 없도록 하는 
-- 제약조건

-- CREATE
CREATE TABLE NotnullTable1 (
	notnull_field INT NOT NULL
);

-- ALTER
-- Alter로 NOT NULL 제약 조건을 추가할 땐
-- 원래 존재하는 레코드에서 해당 필드의 데이터가 Null이 존재하면 안됨
CREATE TABLE NotnullTable (
	notnull_field INT 
);

ALTER TABLE NotnullTable1 
MODIFY COLUMN notnull_field INT NOT NULL; 

-- Default
-- 입력 작업에서 해당 필드의 값이 들어오지 않으면 기본값으로 지정해 주는 
-- 제약 조건

-- CREATE
CREATE TABLE defaultTable1 (
	default_field INT DEFAULT 1
);
    
-- ALTER
 CREATE TABLE defaultTable2 (
	default_field INT
);
    
ALTER TABLE defaultTable2 
MODIFY COLUMN default_field INT DEFAULT 1;
 
-- UNIQUE
-- 삽입, 수정 작업에서 해당 제약 조건이 걸려있는 필드의 데이터에 대해 
-- 중복을 허용하지 않는 제약 조건

-- CREATE
CREATE TABLE Unique_Table1 (
	unique_field INT UNIQUE
);

CREATE TABLE Unique_Table2 (
	unique_field INT,
    CONSTRAINT unique_key_1 UNIQUE ( unizue_field)
);
-- 위에서 CONSTRAINT unique_key_1 는 이름을 지정해주는 거로 굳이 안써도 됨

-- ALTER
CREATE TABLE Unique_Table3 (
	unique_field INT
);

ALTER TABLE Unique_Table3 MODIFY unique_field INT UNIQUE;

CREATE TABLE Unique_Table4 (
unique_field INT
);

AlTER TABLE Unique_Table4
ADD CONSTRAINT unique_key_1 UNIQUE (unique_field);

-- PRIMARY KEY
-- 기본키에 대한 제약조건, NOT NULL / UNIQUE 가 포함되어 있음
-- 삽입, 수정시에 NULL을 포함할 수 없음, 중복된 데이터를 포함할 수 없음


-- CREATE
CREATE TABLE primary_table1(
	primary_field INT primary key
);

CREATE TABLE primary_table2(
	primary_field INT, 
    CONSTRAINT primary_key_1
    PRIMARY KEY (primary_field)
);

-- ALTER
CREATE TABLE primary_table3(
	primary_field INT 
);

ALTER TABLE primary_table3
MODIFY COLUMN primary_field INT PRIMARY KEY;

CREATE TABLE primary_table4(
	primary_field INT
);

ALTER TABLE primary_table4
ADD CONSTRAINT primary_key_1 PRIMARY KEY (primary_field);

-- FOREIGNKEY
-- 참조 제약조건, 해당 테이블을 해당 필드를 기준으로 외부 테이블의 외부 필드를
-- 참조하도록 하는 제약조건
-- 해당 제약조건이 걸려있는 필드의 경우 참조하는 테이블의 참조 필드에
-- 존재하는 데이터만 삽입할 수 있음 

-- CREATE
CREATE TABLE Referenced_Table (
	primary_key INT PRIMARY KEY
); 

-- CREATE 시에 참조 제약조건을 추가할 땐
-- 선행적으로 참조할 테이블과 필드가 존재해야하고 
-- 참조할 필드가 PRIMARY KEY 또는 UNIQUE 제약조건이 지정되어 있어야함 
-- 참조 제약조건이 걸리는 필드는 참조할 필드의 데이터타입과 일치해야함
CREATE TABLE Foreign_Table1 (-- Referenced_Table(위에 애)를 참조하는 테이블을 만들거임
	foreign_field INT,
    CONSTRAINT foreign_key_1
    FOREIGN KEY (foreign_field)
    REFERENCES Referenced_Table (primary_key)
);

-- ALTER
CREATE TABLE Foreign_Table2 (
	Foreign_field INT
);

ALTER TABLE Foreign_Table2
ADD CONSTRAINT foreign_key_1
FOREIGN KEY (foreign_field)
REFERENCES Referenced_Table (primary_key)

