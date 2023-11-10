# Write your MySQL query statement below
with interim as (
    select product_id,
    new_price as price,
    row_number() over (partition by product_id order by change_date desc) as row_num
    from products
    where change_date <= '2019-08-16'
)

select product_id,
price
from interim
where row_num = 1
UNION
select product_id, 10 as price
from products 
where product_id not in (select distinct product_id from interim) 