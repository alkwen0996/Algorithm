select ii.ITEM_ID, ii.ITEM_NAME
from ITEM_INFO ii join ITEM_TREE it
on ii.item_id = it.item_id
where it.parent_item_id is null
order by ITEM_ID;