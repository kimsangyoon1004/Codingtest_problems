-- 코드를 입력하세요
SELECT first_half.Flavor
from First_half, icecream_info
where first_half.flavor = icecream_info.flavor
and total_order > 3000
and ingredient_type = 'fruit_based'
order by total_order desc