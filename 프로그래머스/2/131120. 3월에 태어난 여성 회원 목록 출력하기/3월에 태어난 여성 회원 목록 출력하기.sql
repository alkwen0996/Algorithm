-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH,'%Y-%m-%d') DATE_OF_BIRTH
from MEMBER_PROFILE
where date_of_birth like '%-03-%' and tlno is not null and gender = 'W'
order by MEMBER_ID asc;