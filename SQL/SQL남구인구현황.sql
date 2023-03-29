-- Namgu 테이블에서 전체 데이터 검색
SELECT * FROM hotel.namgu;

-- Namgu 테이블에서 구분, 세대수, 면적 필드 검색
SELECT 구분, 세대수, 면적
FROM Namgu;

-- Namgu 테이블에서 구분, 세대수, 면적 필드 중 중복을 제거하여 검색 (3개 모두가 같아야 제거)
SELECT DISTINCT 면적, 구분, 세대수
FROM Namgu;

SELECT * FROM Namgu WHERE 구분 = '문현2동 ';
SELECT * FROM Namgu WHERE 구성비 = 3;

SELECT * FROM Namgu WHERE 구분 LIKE '문현%';
SELECT * FROM Namgu WHERE 구분 LIKE '%문현%';

SELECT * FROM Namgu WHERE 세대수 >= 10000;
SELECT * FROM Namgu WHERE 세대수 <= 5000;

SELECT * FROM Namgu WHERE 세대수 <= 10000 AND 세대수 >= 5000;
SELECT * FROM Namgu WHERE 세대수 <= 10000 && 세대수 >= 5000;
SELECT * FROM Namgu WHERE 세대수 BETWEEN 5000 AND 10000;

SELECT * FROM Namgu WHERE 통 IN(21, 22, 23);
SELECT * FROM Namgu WHERE 통 NOT IN(21, 22, 23);

-- Namgu 테이블에서 
-- 인구수가 10000명 이상이면서 18세이상인구수 12000명 이하인 
-- 레코드 중 전체 필드 검색
SELECT * 
FROM Namgu 
WHERE 인구수 >= 10000 
AND 18세이상인구수 <= 12000;

-- Namgu 테이블에서
-- 통이 20 이상 이거나 반이 100 이하인 
-- 레코드 중 구분, 세대수, 인구, 통, 반 필드를 검색
SELECT 구분, 세대수, 인구수namgu, 통, 반
FROM Namgu 
WHERE 통 >= 20 OR 반 <= 100;

-- Namgu 테이블에서 
-- 인구수가 10000명 이상인 레코드 중
-- 18세이상인구수 12000명 이하이거나 반이 100이하인
-- 레코드 중 전체 필드 검색
SELECT * FROM Namgu 
WHERE 인구수 >= 10000 
AND (18세이상인구수 <= 12000 OR 반 >= 100);custom

