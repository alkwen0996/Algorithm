-- 코드를 입력하세요

select ii.flavor
from first_half fh join icecream_info ii on fh.flavor = ii.flavor
where fh.total_order > 3000 and ii.ingredient_type = 'fruit_based';
