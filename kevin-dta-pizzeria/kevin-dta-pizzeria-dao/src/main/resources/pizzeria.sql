



CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,
  `libelle` varchar(150) NOT NULL,
  `reference` varchar(100) NOT NULL,
  `prix` double NOT NULL,
  `categ_pizza` varchar(255) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
);


INSERT INTO `pizza` (`id`, `libelle`, `reference`, `prix`, `categ_pizza`, `url_image`) VALUES
(1, 'margerita', 'MAR', 11, 'SANS_VIANDE', 'http'),
(2, 'peperoni', 'PEP', 12.5, 'VIANDE', 'http'),
(3, 'reine', 'REI', 13, 'VIANDE', 'http'),
(4, '4 fromage', 'FRO', 13, 'VIANDE', 'http'),
(5, 'cannibale', 'CAN', 13.5, 'VIANDE', 'http'),
(6, 'orientale', 'ORI', 13, 'VIANDE', 'http'),
(7, 'indienne', 'IND', 13, 'VIANDE', 'http'),
(8, 'savoyarde', 'SAV', 13, 'VIANDE', 'http'),
(10, 'forestiere', 'FOR', 13, 'VIANDE', 'http'),
(18, 'calzone', 'CAL', 13, 'VIANDE', NULL),
(19, 'hareng', 'HAR', 13.5, 'POISSON', NULL),
(20, 'kebab', 'KEB', 16, 'VIANDE', NULL),
(21, 'merguez', 'MER', 13, 'VIANDE', NULL),
(22, 'pêcheur', 'PEC', 13, 'POISSON', NULL),
(23, 'royale', 'ROY', 13.5, 'VIANDE', NULL),
(24, 'pizzaTest', 'PTEST1483628273293', 9.99, 'POISSON', NULL),
(25, 'pizzaTest', 'PTEST1483629135798', 9.99, 'POISSON', 'test');


