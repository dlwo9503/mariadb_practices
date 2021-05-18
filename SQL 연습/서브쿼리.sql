-- subquery
-- 1) from절의 서브쿼리
select now() as n, sysdate() b, 3 + 1 as c;

select s.n, s.b, s.c from (select now() as n, sysdate() b, 3 + 1 as c) s;

-- 2) where
-- 예제 :
-- 현재 Fai Bale이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름을 출력해보세요. 
select b.dept_no from employees a, dept_emp b
where a.emp_no = b.emp_no and b.to_date = '9999-01-01' and concat(a.first_name, ' ', a.last_name) = 'Fai Bale';

select a.emp_no, a.first_name from employees a, dept_emp b where a.emp_no = b.emp_no and b.dept_no = 'd004';

-- 위 두개를 합치면
select a.emp_no, a.first_name from employees a, dept_emp b where a.emp_no = b.emp_no and b.dept_no = (select b.dept_no from employees a, dept_emp b
where a.emp_no = b.emp_no and b.to_date = '9999-01-01' and concat(a.first_name, ' ', a.last_name) = 'Fai Bale');

-- 2-1) where절의 서브쿼리 : 단일행
-- 단일행 연산자 : =, >, <, >=, <=, <>, !=

-- 실습문제 1 :
-- 현재 전체사원의 평균 연봉보다 적은 급여를 받는 사원의  이름, 급여를 나타내세요.
select avg(salary) from salaries b where b.to_date = '9999-01-01';

select a.first_name, b.salary from employees a, salaries b 
where a.emp_no = b.emp_no and salary < (select avg(salary) from salaries where to_date = '9999-01-01') order by b.salary desc;

-- 실습문제 2 : 
-- 현재 가장적은 평균 급여를 받고 있는 직책에해서 평균 급여를 구하세요
-- sol1
-- 1) 직책별 평균급여
select a.title, avg(b.salary) as avg_salary from titles a, salaries b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by a.title order by avg_salary;
-- 2) 가장 적은 평균급여
select min(avg_salary) from 
(select a.title, avg(b.salary) as avg_salary from titles a, salaries b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by a.title order by avg_salary) a;

-- sol2 : top-k
select a.title, avg(b.salary) as avg_salary from titles a, salaries b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by a.title order by avg_salary limit 3; -- order by와 limit을 사용하면 쉽게 해결가능

-- sol3
select a.title, avg(b.salary) as avg_salary from titles a, salaries b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by a.title having round(avg_salary) = 
(select min(avg_salary) from (select a.title, avg(b.salary) as avg_salary from titles a, salaries b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by a.title order by avg_salary) a);

