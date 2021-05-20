-- 서브쿼리(SUBQUERY) SQL 문제입니다. (혼합)

-- 문제1. (count)
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
-- select avg(b.salary) from employees a, salaries b where a.emp_no = b.emp_no and b.to_date = '9999-01-01';
select count(*) from employees a, salaries b  
where a.emp_no = b.emp_no 
and b.salary > (select avg(b.salary) from employees a, salaries b where a.emp_no = b.emp_no and b.to_date = '9999-01-01');

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
-- select a.emp_no, max(c.salary) from employees a, dept_emp b, salaries c where a.emp_no = b.emp_no and a.emp_no = c.emp_no and b.to_date = '9999-01-01' and c.to_date = '9999-01-01' group by b.dept_no;
select a.emp_no, a.first_name, b.max_salary
from employees a
, (select a.emp_no, max(c.salary) as max_salary from employees a, dept_emp b, salaries c
where a.emp_no = b.emp_no and a.emp_no = c.emp_no and b.to_date = '9999-01-01' and c.to_date = '9999-01-01' group by b.dept_no) b
where a.emp_no = b.emp_no order by b.max_salary desc;

-- 문제3. //
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
-- select b.emp_no, b.dept_no, avg(a.salary) from salaries a, dept_emp b
-- where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by b.dept_no;
select a.emp_no, a.first_name, b.salary, c.dept_name from employees a, salaries b , departments c, dept_emp d ,
(select c.dept_name as dep_name, avg(b.salary) as sal from dept_emp a, salaries b, departments c where a.emp_no = b.emp_no and a.dept_no = c.dept_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by c.dept_name) e
where a.emp_no = b.emp_no and b.emp_no = d.emp_no and c.dept_no = d.dept_no and e.dep_name = c.dept_name and b.salary > e.sal and b.to_date = '9999-01-01' and d.to_date = '9999-01-01';

-- 문제4. //
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
-- select a.emp_no, a.first_name, b.dept_no, c.dept_name from employees a, dept_manager b, departments c
-- where a.emp_no = b.emp_no and b.dept_no = c.dept_no and b.to_date = '9999-01-01';
select a.emp_no, a.first_name, b.first_name, b.dept_name
from (select e.emp_no, e.first_name, de.dept_no from employees e, dept_emp de where e.emp_no = de.emp_no and de.to_date > current_date()) a,
(select dm.dept_no, e.first_name, d.dept_name from dept_manager dm, departments d, employees e where dm.to_date > current_date() and dm.emp_no = e.emp_no
and dm.dept_no = d.dept_no) b where a.dept_no = b.dept_no;

-- 문제5. (부서 이름, 평균연봉)
-- 평균 연봉이 가장 높은 부서는? 
-- select avg(a.salary) from salaries a, dept_emp b where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by b.dept_no;
select b.dept_name, max(a.avg_salary)
from (select b.dept_no as no, avg(a.salary) as avg_salary from salaries a, dept_emp b 
where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by b.dept_no) a
, departments b
where a.no = b.dept_no;

-- 문제6. //
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select a.dept_no, b.dept_name, a.avg_salary from (select de.dept_no, avg(s.salary) as avg_salary from dept_emp de, salaries s
where de.to_date > current_date() and s.emp_no = de.emp_no and s.to_date > current_date() group by de.dept_no
order by 2 desc limit 1)a, departments b where a.dept_no = b.dept_no;

-- 문제7.
-- 평균 연봉이 가장 높은 직책?
-- select b.title as ti, avg(a.salary) from salaries a, titles b where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by b.title;
select a.ti as '직책', max(a.avg_salary) as '평균 연봉'
from (select b.title as ti, avg(a.salary) as avg_salary from salaries a, titles b where a.emp_no = b.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01' group by b.title) a;

-- 문제8. //
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select a.dept_name, b.first_name, b.salary, a.first_name, a.salary
from (select dm.dept_no, dm.emp_no, s.salary, e.first_name, d.dept_name from dept_manager dm, salaries s, employees e, departments d
where dm.to_date > current_date() and s.to_date > current_date() and dm.emp_no = s.emp_no and e.emp_no = dm.emp_no and dm.dept_no = d.dept_no) a,
(select de.dept_no, e.first_name, s.salary
from employees e, salaries s, dept_emp de
where e.emp_no = s.emp_no and s.to_date > current_date() and de.to_date > current_date() and e. emp_no = de.emp_no) b
where a.dept_no = b.dept_no and b.salary > a.salary;