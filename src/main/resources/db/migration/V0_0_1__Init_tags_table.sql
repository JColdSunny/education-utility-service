CREATE TABLE tags
(
    id   SERIAL,
    name VARCHAR UNIQUE NOT NULL,
    CONSTRAINT pk_tags_id PRIMARY KEY (id)
);

INSERT INTO tags (id, name)
VALUES (1, 'ReactJS'),
       (2, 'JavaScript Core'),
       (3, 'Redux'),
       (4, 'Spring Framework'),
       (5, 'Spring Boot'),
       (6, 'String Data R2DBC'),
       (7, 'Spring Data JPA'),
       (8, 'Spring Security'),
       (9, 'Java Core');