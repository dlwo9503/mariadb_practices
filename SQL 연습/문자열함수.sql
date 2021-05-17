-- 함수 : 문자열 함수

-- upper
select upper('buSan'), upper('busan'), upper('Douzone');
select upper(first_name) from employees;

-- lower
select lower('buSan'), lower('busan'), lower('Douzone');
select lower(first_name) from employees;

-- substring
select substring('Happy Day', 3, 2); -- 문장, 시작 인덱스, 길이

-- DB는 0말고 1부터 시작하는 경우가 많다.

-- 예제 )1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date from employees where 1989 = substring(hire_date, 1, 4);

-- lpad, rpad ( l : 오른쪽, r : 왼쪽) (반대로라서 헷갈리면 ㄴㄴ)
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');
-- 예제) 직원들의 월급을 오른쪽으로 정렬( 빈공간은 * )
select emp_no, lpad(salary, 10, '*') from salaries where from_date like '2001-%';

-- trim, ltrim, rtrim
select ltrim('  hello  ');
select rtrim('  hello  ');
select concat('---', ltrim('  hello  '), '---') ltrim, concat('---', rtrim('  hello  '), '---') rtrim,
	concat('---', trim(both ' ' from '  hello  '), '---') trim;
