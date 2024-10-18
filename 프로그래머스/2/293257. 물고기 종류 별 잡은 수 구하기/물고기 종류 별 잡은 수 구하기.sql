select count(*) fish_count, fni.fish_name fish_name
from FISH_INFO fi join FISH_NAME_INFO fni on fi.fish_type = fni.fish_type
group by fi.fish_type, fni.fish_name
order by fish_count desc
