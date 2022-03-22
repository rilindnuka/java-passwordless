CREATE TABLE access_token
(
    id         varchar      not null default uuid_generate_v4()
        constraint pk_access_token primary key,
    created_at timestamp without time zone not null default now_utc(),
    updated_at timestamp without time zone
        constraint cc_login_attempts__create_before_update check (created_at <= updated_at),
    user_id      varchar not null
        constraint fk_access_token_user_id references passwordless_user(id),
    access_token      varchar(255) not null
) WITHOUT OIDS;