select ii.INGREDIENT_TYPE INGREDIENT_TYPE, sum(fh.TOTAL_ORDER) TOTAL_ORDER
from FIRST_HALF fh join ICECREAM_INFO ii on fh.flavor = ii.flavor
group by ii.INGREDIENT_TYPE
order by fh.total_order


