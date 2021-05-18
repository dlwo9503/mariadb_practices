-- join

-- 예제 1
-- employees 테이블과 titles 테이블을 join하여 직원의 이름과 직책을 모두 출력하세요.

select * from employees, titles where employees.emp_no = titles.emp_no; -- join condition

select a.emp_no, a.first_name, b.title from employees a, titles b where a.emp_no = b.emp_no;

-- 예제 2
-- employees 테이블과 titles 테이블를 join하여 직원의 이름과 직책을 출력하되 여성 엔지니어만 출력하세요. 
select a.emp_no, a.first_name, b.title, a.gender from employees a, titles b where a.emp_no = b.emp_no and a.gender = 'F' and b.title = 'engineer';

-- ANSI / ISO SQL1999 JOIN 표준 문법

-- 1) natural join
-- 두 테이블에 공통 컬럼이 있으면 별다른 조건없이 묵시적으로 조인됨
-- 쓸일이 없음
select a.first_name, b.title from employees a join titles b;
-- on a.emp_no = b.emp_no; 이거는 생략됨

-- 2) join ~ using
select a.first_name, b.title from employees a join titles b using(emp_no);

-- 3) join ~ on
select a.first_name, b.title from employees a join titles b on a.emp_no = b.emp_no;