CREATE TABLE appointments
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    doctor VARCHAR(255),
    concern VARCHAR(255),
    conclusion VARCHAR(255),
    prescription VARCHAR(255),
    sicknote VARCHAR(255)
);