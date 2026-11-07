CREATE TABLE IF NOT EXISTS employee_skills (
    employee_id UUID NOT NULL,
    code VARCHAR(60) NOT NULL,
    name VARCHAR(120) NOT NULL,
    proficiency VARCHAR(12) NOT NULL CHECK (proficiency IN ('BEGINNER', 'INTERMEDIATE', 'ADVANCED', 'EXPERT')),
    PRIMARY KEY (employee_id, code)
);
