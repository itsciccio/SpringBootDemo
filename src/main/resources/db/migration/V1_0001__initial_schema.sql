DROP TABLE IF EXISTS `users_addresses`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `addresses`;
DROP TABLE IF EXISTS `cities`;

CREATE TABLE `cities` (
                          `code` varchar(255) NOT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
                         `id` varchar(255) NOT NULL,
                         `age` int DEFAULT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `addresses` (
                             `id` varchar(255) NOT NULL,
                             `house_number` int DEFAULT NULL,
                             `street` varchar(255) DEFAULT NULL,
                             `city_code` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FK5muj0nkj01jtb99ep3503b3w2` (`city_code`),
                             CONSTRAINT `FK5muj0nkj01jtb99ep3503b3w2` FOREIGN KEY (`city_code`) REFERENCES `cities` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `users_addresses` (
                                   `person_id` varchar(255) NOT NULL,
                                   `addresses_id` varchar(255) NOT NULL,
                                   UNIQUE KEY `UK_fkg2t84ux3d2l2pg8atpsbljx` (`addresses_id`),
                                   KEY `FKoc9mvv5wa2kf45y6t4tmjuna5` (`person_id`),
                                   CONSTRAINT `FKh6foo81uvii75tg3vibdj1mcx` FOREIGN KEY (`addresses_id`) REFERENCES `addresses` (`id`),
                                   CONSTRAINT `FKoc9mvv5wa2kf45y6t4tmjuna5` FOREIGN KEY (`person_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
