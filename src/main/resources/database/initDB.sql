CREATE TABLE IF NOT EXISTS t_users
(
    f_id    SERIAL PRIMARY KEY,
    f_name  VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_roles
(
    f_id    SERIAL PRIMARY KEY,
    f_name  VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_users_roles
(
    f_user_id int references t_users(f_id),
	  f_role_id int references t_roles(f_id),
	  constraint id PRIMARY KEY (f_user_id, f_role_id)
);