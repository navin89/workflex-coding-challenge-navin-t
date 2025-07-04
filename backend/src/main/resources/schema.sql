CREATE TABLE workation (
   workation_id BIGINT PRIMARY KEY,
   employee VARCHAR(255),
   origin VARCHAR(255),
   destination VARCHAR(255),
   start DATE,
   "end" DATE,
   working_days INT,
   risk VARCHAR(50)
);