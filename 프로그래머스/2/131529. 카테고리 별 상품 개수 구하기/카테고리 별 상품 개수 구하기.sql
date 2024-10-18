select substring(PRODUCT_CODE,1,2) category, count(PRODUCT_ID) products
from PRODUCT
group by substring(PRODUCT_CODE,1,2)
order by PRODUCT_CODE
