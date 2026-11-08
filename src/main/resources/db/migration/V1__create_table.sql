CREATE TABLE employee_skill (
    emp_id BIGINT NOT NULL,
    s_id BIGINT NOT NULL,
    years_of_exp INTEGER NOT NULL CHECK (years_of_exp BETWEEN 0 AND 80),
    PRIMARY KEY (emp_id, s_id)
);
