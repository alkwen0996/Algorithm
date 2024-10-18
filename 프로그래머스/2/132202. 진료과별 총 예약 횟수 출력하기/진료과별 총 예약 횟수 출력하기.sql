select mcdp_cd 진료과코드, count(apnt_ymd) 5월예약건수
from APPOINTMENT
where APNT_YMD like '%2022-05%'
group by MCDP_CD
order by 5월예약건수, 진료과코드