CREATE TABLE passwordless_user
(
    id         varchar      not null default uuid_generate_v4()
        constraint pk_users primary key,
    created_at timestamp without time zone not null default now_utc(),
    updated_at timestamp without time zone
        constraint cc_users__create_before_update check (created_at <= updated_at),
    email      varchar(255) not null
        constraint uc_users__email unique
) WITHOUT OIDS;