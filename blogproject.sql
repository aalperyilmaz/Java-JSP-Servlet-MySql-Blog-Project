-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 Ağu 2021, 08:00:25
-- Sunucu sürümü: 10.4.20-MariaDB
-- PHP Sürümü: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `blogproject`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`aid`, `name`, `email`, `password`) VALUES
(1, 'Erkan Bilsin\n\n', 'erkan@mail.com', '827ccb0eea8a706c4c34a16891f84e7b'),
(2, 'Serkan Bilsin ', 'serkan@mail.com', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Tetikleyiciler `admin`
--
DELIMITER $$
CREATE TRIGGER `insert_trigger_add` BEFORE INSERT ON `admin` FOR EACH ROW INSERT INTO contact VALUES(null,NEW.email,NEW.name)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `contact`
--

CREATE TABLE `contact` (
  `cid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `aid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `contact`
--

INSERT INTO `contact` (`cid`, `name`, `email`, `aid`) VALUES
(1, 'Serkan', 'serkan@mail.com', 2),
(2, 'Erkan bilsin', 'erkan@mail.com', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `content`
--

CREATE TABLE `content` (
  `cidx` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text NOT NULL,
  `aid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `content`
--

INSERT INTO `content` (`cidx`, `title`, `detail`, `aid`) VALUES
(5, 'JAVA', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text\n      ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only\n      five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release\n      of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of\n      Lorem Ipsum.', 1),
(11, 'BİLİM', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text\n      ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only\n      five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release\n      of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of\n      Lorem Ipsum.', 1),
(12, 'YAZILIM  ', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text\n      ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only\n      five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release\n      of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of\n      Lorem Ipsum.', 2),
(14, 'TEKNOLOJİ', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text\n      ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only\n      five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release\n      of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of\n      Lorem Ipsum.', 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`aid`);

--
-- Tablo için indeksler `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `content`
--
ALTER TABLE `content`
  ADD PRIMARY KEY (`cidx`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `contact`
--
ALTER TABLE `contact`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `content`
--
ALTER TABLE `content`
  MODIFY `cidx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
