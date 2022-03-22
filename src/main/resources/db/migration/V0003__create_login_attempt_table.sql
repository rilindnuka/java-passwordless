CREATE TABLE login_attempt
(
    id         varchar      not null default uuid_generate_v4()
        constraint pk_login_attempts primary key,
    created_at timestamp without time zone not null default now_utc(),
    updated_at timestamp without time zone
        constraint cc_login_attempts__create_before_update check (created_at <= updated_at),
    email      varchar not null
        constraint uc_login_attempts__email unique,
    code      varchar(255) not null
) WITHOUT OIDS;