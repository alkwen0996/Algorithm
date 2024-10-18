-- 코드를 입력하세요
SELECT animal_id, name
FROM ANIMAL_INS
WHERE animal_type = 'Dog' and name like '%EL%' 
order by name