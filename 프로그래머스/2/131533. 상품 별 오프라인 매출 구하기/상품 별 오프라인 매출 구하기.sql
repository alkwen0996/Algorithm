-- 코드를 입력하세요
select p.product_code, sum(p.price * os.sales_amount) sales
from product p join offline_sale os using (product_id)
group by p.product_code
order by sales desc, p.product_code;