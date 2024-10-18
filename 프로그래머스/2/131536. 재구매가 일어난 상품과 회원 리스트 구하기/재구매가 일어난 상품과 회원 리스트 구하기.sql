SELECT USER_ID, PRODUCT_ID
from ONLINE_SALE
group by USER_ID, product_id
having count(product_id) > 1
order by USER_ID, PRODUCT_ID desc;