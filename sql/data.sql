INSERT INTO `learning_center`.`students`(`first_name`, `last_name`, `phone_number`, `email`)
VALUES ('Stepan', 'Zorin', '89876651515', 'zorin@email.com');
INSERT INTO `learning_center`.`students`(`first_name`, `last_name`, `phone_number`, `email`)
VALUES ('Anna', 'Grushina', '89888351987', 'grushina@email.com');
INSERT INTO `learning_center`.`students`(`first_name`, `last_name`, `phone_number`, `email`)
VALUES ('Egor', 'Bulgakov', '89606651515', 'bulgakov@email.com');
INSERT INTO `learning_center`.`students`(`first_name`, `last_name`, `phone_number`, `email`)
VALUES ('Elena', 'Krasnova', '89870001515', 'krasnova@email.com');
INSERT INTO `learning_center`.`students`(`first_name`, `last_name`, `phone_number`, `email`)
VALUES ('Aleksandr', 'Gorin', '89873351515', 'gorin@email.com');

INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (4, 1);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (5, 2);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (6, 3);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (7, 4);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (8, 5);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (5, 5);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (6, 4);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (11, 1);
INSERT INTO `learning_center`.`students_programs` (`student_id`,`program_id`)
VALUES (12, 2);

INSERT INTO `learning_center`.`users` (`username`, `password`, `enabled`)
VALUES ('annagrushina', '$10$SITkFVuREtSPgeTByXh4V.PLJcPPJtbs8UbRX7afZ9lG9ldekALYW', 1);
INSERT INTO `learning_center`.`users` (`username`, `password`, `enabled`)
VALUES ('egorsidorov', '$10$1ASm5jcXoSys4Ve5RzW1Pu9lnCjYvaG9Z7W/bzd8vDZlghVs1CpXK', 1);
INSERT INTO `learning_center`.`users` (`username`, `password`, `enabled`)
VALUES ('maratsafin', '$10$nmRQJ/GoNLg1M/QtcPiVY.hMv/RhOTJsBPlcYHtBUJH4QZj6NU9b6', 1);
INSERT INTO `learning_center`.`users` (`username`, `password`, `enabled`)
VALUES ('stepanzorin', '$10$Fa4z6mNVRSnWxNzVe6Ve5OqUSbLj95nBIfLYvGvH1xRDhFBJEOet.', 1);

INSERT INTO `learning_center`.`authorities` (`username`,`authority`)
VALUES ('annagrushina', 'ROLE_STUDENT');
INSERT INTO `learning_center`.`authorities` (`username`,`authority`)
VALUES ('egorsidorov', 'ROLE_TEACHER');
INSERT INTO `learning_center`.`authorities` (`username`,`authority`)
VALUES ('maratsafin', 'ROLE_TEACHER');
INSERT INTO `learning_center`.`authorities` (`username`,`authority`)
VALUES ('stepanzorin', 'ROLE_STUDENT');

INSERT INTO `learning_center`.`balances` (`student_id`, `amount`)
VALUES (4, 1400);
INSERT INTO `learning_center`.`balances` (`student_id`, `amount`)
VALUES (5, 1000);
INSERT INTO `learning_center`.`balances` (`student_id`, `amount`)
VALUES (6, 2200);
INSERT INTO `learning_center`.`balances` (`student_id`, `amount`)
VALUES (7, 3000);
INSERT INTO `learning_center`.`balances` (`student_id`, `amount`)
VALUES (8, 6000);

INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (4, 1, 100);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (4, 2, 80);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (4, 3, 70);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (4, 4, 75);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (5, 5, 70);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (5, 6, 60);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (6, 9, 65);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (6, 10, 90);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (6, 11, 50);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (7, 13, 100);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (7, 14, 90);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (7, 15, 80);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (7, 16, 75);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (8, 17, 70);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (8, 18, 70);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (5, 7, 90);
INSERT INTO `learning_center`.`marks`(`student_id`, `module_id`, `mark_value`)
VALUES (8, 19, 80);

INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (1, 'first_module_java', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (1, 'second_module_java', 144);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (1, 'third_module_java', 48);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (1, 'fourth_module_java', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (2, 'first_module_javascript', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (2, 'second_module_javascript', 144);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (2, 'third_module_javascript', 48);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (2, 'fourth_module_javascript', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (3, 'first_module_.net', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (3, 'second_module_.net', 144);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (3, 'third_module_.net', 48);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (3, 'fourth_module_.net', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (4, 'first_module_python', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (4, 'second_module_python', 144);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (4, 'third_module_python', 48);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (4, 'fourth_module_python', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (5, 'first_module_qa', 72);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (5, 'second_module_qa', 144);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (5, 'third_module_qa', 48);
INSERT INTO `learning_center`.`modules` (`program_id`, `name`, `duration`)
VALUES (5, 'fourth_module_qa', 72);

INSERT INTO `learning_center`.`programs` (`name`)
VALUES ('Java');
INSERT INTO `learning_center`.`programs` (`name`)
VALUES ('JavaScript');
INSERT INTO `learning_center`.`programs` (`name`)
VALUES ('.Net');
INSERT INTO `learning_center`.`programs` (`name`)
VALUES ('Python');
INSERT INTO `learning_center`.`programs` (`name`)
VALUES ('QA');
