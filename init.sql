-- Create schema
CREATE SCHEMA IF NOT EXISTS employee AUTHORIZATION postgres;

-- Create table
CREATE TABLE IF NOT EXISTS employee.emp
(
    employee_id BIGINT NOT NULL DEFAULT nextval('employee.emp_employee_id_seq'::regclass),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT emp_pkey PRIMARY KEY (employee_id),
    CONSTRAINT emp_email_key UNIQUE (email)
    );

ALTER TABLE IF EXISTS employee.emp OWNER TO postgres;
