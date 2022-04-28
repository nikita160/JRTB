DROP TABLE IF EXISTS public.tg_user_table;

CREATE TABLE IF NOT EXISTS public.tg_user_table
(
	chat_id VARCHAR(100),
    active BOOLEAN
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tg_user_table
   OWNER to postgres;