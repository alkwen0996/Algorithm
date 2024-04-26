SELECT ugb.TITLE, ugb.BOARD_ID, ugr.REPLY_ID, ugr.WRITER_ID, ugr.CONTENTS, date_format(ugr.CREATED_DATE, '%Y-%m-%d')
from USED_GOODS_BOARD ugb, USED_GOODS_REPLY ugr
where ugb.BOARD_ID = ugr.BOARD_ID and ugb.CREATED_DATE like '2022-10-%'
order by ugr.CREATED_DATE, ugb.TITLE;