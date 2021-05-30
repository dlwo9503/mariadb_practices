-- update pet set death = '2000-01-01' where name='Bowser';
select * from pet;

-- 테이블 삭제하기
drop table pet;

-- 테이블 만들기
create table pet (
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);
-- scheme 확인
desc pet;

-- 조회
select name, owner, species, gender from pet;

-- 데이터 넣기(생성, create)
insert into pet values ('성탄이','안대혁','dog','m','2018-12-25', 'null');

-- 데이터 삭제(delete) where를 안해주면 다 지우기때문에 조심할 것
delete from pet where name='성탄이';

-- 조회 연습1 : where 연습
-- 1990년 이후에 태어난 아이들은?
select * from pet where birth > '1990-12-31';
-- Gwen과 함께 사는 아이들은?
select * from pet where owner = 'gwen';

-- null 다루기1 : 사망하지 않은 애들은?
select * from pet where death is null;

-- null 다루기1 : 죽은 애들은?
select * from pet where death is not null;

-- like 검색(패턴매칭) : 이름이 b로 시작하는 아이들 중에 이름이 6자인 애는?
select * from pet where name like 'b_____%';

-- 조회 연습2 : order by (asc / desc) (오름, 내림)
-- 나이가 어린순으로 정렬하기 (생일이 같으면 ,name asc; 이런식으로 두번째 정렬 조건을 걸어줄 수 있음
select * from pet order by birth desc, name asc;

-- 집계(통계) 함수
select count(*) from pet;

select count(death) from pet; -- death가 null 값이 아닌거의 개수를 카운트
select count(*) from pet where death is not null; -- 윗줄과 같은 결과가 나옴