-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Albumliste`
--

-- --------------------------------------------------------

--
-- Structure de la table `albumliste`
--

CREATE TABLE `albumliste` (
  `id-album` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `année` int(11) NOT NULL,
  `id-artiste` int(11) NOT NULL,
  `id-genre` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `albumliste`
--

INSERT INTO `albumliste` (`id-album`, `titre`, `année`, `id-artiste`, `id-genre`) VALUES
(4, 'What''s Going On', 1961, 6, 6),
(5, 'Sgt. Pepper''s Lonely Hearts Club Band', 1951, 14, 5),
(7, 'In the Wee Small Hours', 1955, 7, 13),
(8, 'Fresh Cream', 1966, 25, 5),
(11, 'Giant Steps', 1959, 38, 1),
(12, 'Sweet Baby James', 1970, 10, 10),
(13, 'Modern Sounds in Country and Western Music', 1962, 48, 2),
(14, 'Aftermath', 1966, 12, 15),
(15, 'Loaded', 1970, 54, 6),
(16, 'Kind of Blue', 1959, 56, 10),
(17, 'Kind of Blue', 1959, 47, 5),
(18, 'If You Can Believe Your Eyes and Ears', 1966, 8, 16),
(19, 'Disraeli Gears', 1967, 56, 4),
(20, 'The Who Sell Out', 1967, 27, 4),
(21, 'Out of Our Heads', 1965, 35, 2),
(22, 'Layla and Other Assorted Love Songs', 1970, 39, 3),
(23, 'At Last!', 1960, 18, 5),
(24, 'Sweetheart of the Rodeo', 1968, 14, 12),
(25, 'The Velvet Underground & Nico', 1967, 48, 3),
(26, 'Stand!', 1969, 32, 16),
(27, 'Moby Grape', 1967, 17, 2),
(28, 'Younger Than Yesterday', 1967, 8, 13),
(29, 'Abbey Road', 1969, 28, 3),
(30, 'Paranoid', 1970, 7, 2),
(31, 'Are You Experienced', 1967, 41, 4),
(32, 'Live at the Regal', 1965, 42, 1),
(33, 'A Christmas Gift for You From Phil Spector', 1963, 10, 3),
(34, 'Gris-Gris', 1968, 56, 4),
(35, 'Surrealistic Pillow', 1967, 28, 6),
(36, 'Deja vu', 1970, 54, 12);

-- --------------------------------------------------------

--
-- Structure de la table `Artiste`
--

CREATE TABLE `Artiste` (
  `id-artiste` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Artiste`
--

INSERT INTO `Artiste` (`id-artiste`, `nom`) VALUES
(4, 'The Beatles'),
(6, 'The Beach Boys'),
(7, 'Frank Sinatra'),
(8, 'Cream'),
(9, 'John Coltrane'),
(10, 'James Taylor'),
(11, 'Ray Charles'),
(12, 'The Rolling Stones'),
(13, 'The Velvet Underground'),
(14, 'Miles Davis'),
(15, 'The Mamas and the Papas'),
(16, 'The Who'),
(17, 'Derek and the Dominos'),
(18, 'Etta James'),
(19, 'The Byrds'),
(20, 'Sly & The Family Stone'),
(21, 'MobyGrape'),
(22, 'BlackSabbath'),
(23, 'TheJimiHendrixExperience'),
(24, 'B.B.King'),
(25, 'PhilSpect'),
(26, 'Dr. John'),
(27, 'the Night Tripper'),
(28, 'Jefferson Airplane'),
(29, 'Crosby'),
(30, 'Stills'),
(31, ' Nash & Young'),
(32, 'Santana'),
(33, 'Howlin Wolf'),
(34, 'Otis Redding'),
(35, 'Carpenters'),
(36, 'Van Morrison'),
(37, 'The Stooges'),
(38, 'Buffalo Springfield'),
(39, 'Quicksilver Messenger Service'),
(40, 'Elvis Presley'),
(41, 'The Flying Burrito Brothers'),
(42, 'John Mayall & The Bluesbreakers'),
(43, 'Little Walter'),
(44, 'Simon & Garfunkel'),
(45, 'Cat Stevens'),
(46, 'Neil Young & Crazy Horse'),
(47, 'Bobby "Blue" Bland'),
(48, 'The Meters'),
(49, 'John Lennon '),
(50, 'James Brown'),
(51, 'The Mothers of Invention'),
(52, 'The Grateful Dead'),
(53, 'Ornette Coleman'),
(54, 'The Kinks'),
(55, 'Grateful Dead'),
(56, 'Crosby'),
(57, ' Stills & Nash');

-- --------------------------------------------------------

--
-- Structure de la table `Genre`
--

CREATE TABLE `Genre` (
  `id-genre` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Genre`
--

INSERT INTO `Genre` (`id-genre`, `libelle`) VALUES
(1, 'Rock'),
(2, 'Pop'),
(3, 'Funk/ soul'),
(4, 'Blues'),
(5, 'Funk/ soul'),
(6, 'Blues'),
(7, 'Jazz'),
(8, 'Folk'),
(9, 'World'),
(10, '& Country'),
(11, 'Classical'),
(12, 'Stage & Screen'),
(13, 'Reggae'),
(14, 'Hip Hop'),
(15, 'Electronic'),
(16, 'Latin');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `albumliste`
--
ALTER TABLE `albumliste`
  ADD PRIMARY KEY (`id-album`),
  ADD KEY `fk_artiste` (`id-artiste`),
  ADD KEY `fk_genre` (`id-genre`);

--
-- Index pour la table `Artiste`
--
ALTER TABLE `Artiste`
  ADD PRIMARY KEY (`id-artiste`);

--
-- Index pour la table `Genre`
--
ALTER TABLE `Genre`
  ADD PRIMARY KEY (`id-genre`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `albumliste`
--
ALTER TABLE `albumliste`
  MODIFY `id-album` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT pour la table `Artiste`
--
ALTER TABLE `Artiste`
  MODIFY `id-artiste` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT pour la table `Genre`
--
ALTER TABLE `Genre`
  MODIFY `id-genre` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `albumliste`
--
ALTER TABLE `albumliste`
  ADD CONSTRAINT `fk_artiste` FOREIGN KEY (`id-artiste`) REFERENCES `Artiste` (`id-artiste`),
  ADD CONSTRAINT `fk_genre` FOREIGN KEY (`id-genre`) REFERENCES `Genre` (`id-genre`);
