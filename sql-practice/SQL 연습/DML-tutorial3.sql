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