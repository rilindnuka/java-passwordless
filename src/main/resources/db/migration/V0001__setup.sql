CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE OR REPLACE FUNCTION now_utc() RETURNS TIMESTAMP AS
$$
SELECT now() AT TIME ZONE 'utc';
$$ LANGUAGE sql;
