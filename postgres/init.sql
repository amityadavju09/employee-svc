-- Create schema
CREATE SCHEMA IF NOT EXISTS employee AUTHORIZATION postgres;

-- Create sequence for employee_id
CREATE SEQUENCE IF NOT EXISTS employee.emp_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Create table
CREATE TABLE IF NOT EXISTS employee.emp
(
    employee_id BIGINT NOT NULL,
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

ALTER TABLE employee.emp
    ALTER COLUMN employee_id SET DEFAULT nextval('employee.emp_employee_id_seq');

-- Optional: Add indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_emp_last_name ON employee.emp(last_name);
CREATE INDEX IF NOT EXISTS idx_emp_phone_number ON employee.emp(phone_number);
