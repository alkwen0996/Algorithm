select car_type, count(car_id)
from CAR_RENTAL_COMPANY_CAR
where options like '%열선시트%' or options like '%가죽시트%' or options like '%통풍시트%'
group by car_type
order by car_type
