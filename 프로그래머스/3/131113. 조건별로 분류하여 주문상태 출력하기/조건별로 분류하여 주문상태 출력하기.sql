select ORDER_ID, PRODUCT_ID, date_format(OUT_DATE,'%Y-%m-%d') out_date, 
case 
when out_date <= date('2022-05-01') then '출고완료'
when out_date > date('2022-05-01') then '출고대기'
else '출고미정'
end 출고여부
from FOOD_ORDER
order by ORDER_ID;