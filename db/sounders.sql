-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2024 a las 18:23:47
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sounders`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL,
  `content` text NOT NULL,
  `date` date DEFAULT NULL,
  `hour` time DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comments`
--

INSERT INTO `comments` (`id`, `content`, `date`, `hour`, `author_id`, `post_id`) VALUES
(1, 'Gracias', '2024-01-23', '18:28:00', 1, 3),
(2, 'Tema del año y todavía estamos en Enero', '2024-01-23', '22:09:00', 2, 4),
(3, 'La culeo, un taladrador', '2024-01-23', '22:10:00', 2, 2),
(4, 'Mejora poco a poco, pero flojito', '2024-01-23', '23:54:00', 2, 5),
(5, 'Like y comparto', '2024-01-23', '23:54:00', 1, 5),
(6, 'Muy flojo', '2024-01-23', '23:54:00', 1, 5),
(7, 'Ya tenemos la canción del año y estamos en Enero 🔥🚒', '2024-01-24', '00:00:00', 2, 1),
(8, 'Dislike', '2024-01-24', '00:01:00', 2, 6),
(11, '\r\nLa percepción de que Bad Bunny está sobrevalorado puede basarse en la simplicidad lírica y musical de su estilo, en comparación con otros artistas contemporáneos. Su omnipresencia mediática también puede contribuir a esta impresión, sugiriendo que su relevancia puede estar inflada. Sin embargo, es importante reconocer que la valoración de un artista es subjetiva y depende de los gustos individuales. A pesar de las críticas, Bad Bunny ha dejado una marca significativa en la música contemporánea y ha desafiado las convenciones del género de manera impactante.', '2024-01-24', '00:04:00', 1, 6),
(12, 'Que dices', '2024-01-24', '11:46:00', 4, 6),
(13, '🍃🍃🍃', '2024-01-24', '11:48:00', 1, 8),
(14, 'Vaya temita', '2024-01-24', '11:48:00', 4, 9),
(15, '🐐🐐🐐', '2024-01-24', '12:17:00', 2, 11),
(16, 'Yo con 3 más, eso son bros 🤝', '2024-01-24', '12:18:00', 2, 9),
(17, 'Que buen post', '2024-01-24', '12:18:00', 1, 11),
(18, 'DEP 🐐', '2024-01-24', '12:19:00', 1, 10),
(19, 'Dior dior', '2024-01-24', '12:19:00', 4, 10),
(20, 'Rompió', '2024-01-24', '12:20:00', 3, 11),
(21, 'Infravaloradisimo Sacra JR', '2024-01-24', '12:23:00', 3, 4),
(22, 'El estribillo es clave: Only if u want it, yes, I really want it', '2024-01-24', '12:27:00', 3, 13),
(23, 'Palo transcendental si me preguntan', '2024-01-24', '12:27:00', 1, 13),
(24, 'Esta cuenta solo trae temazos', '2024-01-24', '12:27:00', 2, 13),
(25, 'Agradesido por tenerte conmigo en este camino 🙌', '2024-01-24', '12:29:00', 4, 13),
(26, 'Menudo jodidísimo palo. 10/10', '2024-01-24', '12:40:00', 2, 15),
(27, 'Historia', '2024-01-24', '12:41:00', 1, 15),
(28, 'DEP 🐐🕊️', '2024-01-24', '12:42:00', 3, 15),
(29, 'Soy fan', '2024-01-24', '12:42:00', 4, 15),
(30, 'La recomendamos 100%!', '2024-01-24', '12:42:00', 5, 15),
(31, 'Ik been dar it!', '2024-01-24', '12:43:00', 7, 15),
(32, 'Palito', '2024-01-24', '13:03:00', 8, 16),
(33, 'No', '2024-01-24', '13:09:00', 1, 18),
(34, 'HOTTEST.YOUNG.MEN.in.BIZNESS de Abhir Hathi y Cruz Cafune, es top', '2024-01-24', '13:09:00', 3, 18),
(35, 'Barrio de MilK G Y la Pera MC', '2024-01-24', '13:10:00', 4, 18),
(36, 'El palo es curioso, me alegra que hayan firmado con Warner', '2024-01-24', '13:25:00', 2, 20),
(37, 'Gracias!', '2024-01-24', '13:25:00', 1, 20),
(38, 'Yo cambiaría una parte de la letra', '2024-01-24', '13:25:00', 4, 20),
(39, 'Efectivo o cash', '2024-01-24', '13:26:00', 3, 20),
(40, 'Enrique checks ✅', '2024-01-24', '13:29:00', 10, 21),
(41, 'Gracias!', '2024-01-24', '13:29:00', 1, 21),
(42, '🪵🪵🪵', '2024-01-24', '13:29:00', 2, 21),
(43, 'Chingando tenemos un pacto?', '2024-01-24', '13:33:00', 8, 22),
(44, 'Que gueno', '2024-01-24', '13:36:00', 1, 24),
(45, 'JU AN JE LAS', '2024-01-24', '13:36:00', 1, 23),
(46, 'Che pive', '2024-01-24', '13:36:00', 4, 21),
(47, 'Leyenda', '2024-01-24', '13:39:00', 6, 25),
(48, 'Respeta boludo', '2024-01-24', '13:39:00', 9, 26),
(49, 'Pero bueno', '2024-01-24', '13:40:00', 1, 26),
(50, 'Una basura, con respeto', '2024-01-24', '13:41:00', 2, 27),
(51, 'Está guapa pero yo cambiaría algunas letras', '2024-01-24', '13:41:00', 4, 27),
(52, 'EWPÑGIOLERHUJGOLIERHGIOLERHGE', '2024-01-24', '13:41:00', 3, 27),
(53, 'FORZA FERRARI', '2024-01-24', '13:42:00', 7, 27),
(54, 'bizarrap petardo', '2024-01-24', '13:47:00', 3, 32),
(55, 'a mi me gusta', '2024-01-24', '13:48:00', 3, 31),
(56, 'autolike', '2024-01-24', '13:48:00', 3, 30),
(57, 'ES GOD', '2024-01-24', '13:48:00', 8, 32),
(58, 'La mejor sesión hasta la fecha, los demás son haters', '2024-01-24', '13:48:00', 8, 31),
(59, 'Y no hay ni que roncal', '2024-01-24', '13:49:00', 8, 28),
(60, 'Dale biza', '2024-01-24', '13:49:00', 4, 32),
(61, 'Que locura que la produjese Eminem', '2024-01-24', '13:50:00', 2, 25),
(62, 'Hola', '2024-01-24', '19:47:00', 2, 32),
(63, 'eeee', '2024-01-24', '20:25:00', 2, 33);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message`
--

CREATE TABLE `message` (
  `id` bigint(20) NOT NULL,
  `content` text DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `receiver_id` bigint(20) DEFAULT NULL,
  `sender_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `message`
--

INSERT INTO `message` (`id`, `content`, `date`, `receiver_id`, `sender_id`) VALUES
(1, 'Que onda pive', '2024-01-24 13:53:30', 1, 9),
(2, 'Que pasó', '2024-01-24 13:53:48', 9, 1),
(3, 'Que tal', '2024-01-24 17:24:37', 1, 2),
(4, 'Aqui andamios', '2024-01-24 17:25:05', 2, 1),
(5, 'Tu que tal', '2024-01-24 17:25:40', 2, 1),
(6, 'Si', '2024-01-24 17:25:54', 1, 2),
(7, 'Efectivo o cash', '2024-01-24 17:26:01', 2, 1),
(8, 'Que pasó', '2024-01-24 17:43:31', 2, 9),
(9, 'Que tal', '2024-01-24 17:44:20', 9, 2),
(10, 'Aquí andamos', '2024-01-24 17:44:46', 2, 9),
(11, 'Agusto no?', '2024-01-24 17:59:31', 9, 2),
(12, 'Claro', '2024-01-24 18:11:55', 2, 9),
(13, 'Hola', '2024-01-24 19:59:25', 9, 2),
(14, 'hola', '2024-01-24 20:26:42', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posts`
--

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `hour` time NOT NULL,
  `image_path` text DEFAULT NULL,
  `text` text NOT NULL,
  `author_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `posts`
--

INSERT INTO `posts` (`id`, `date`, `hour`, `image_path`, `text`, `author_id`) VALUES
(1, '2024-01-23', '18:25:00', '/files/2024-01-23T18_25_13.566747400.png', 'SOTY (Song Of The Year)', 1),
(2, '2024-01-23', '18:26:00', '/files/2024-01-23T18_26_03.808861100.png', 'Dracukeo, el empalador', 1),
(3, '2024-01-23', '18:27:00', '/files/2024-01-23T18_27_13.322241900.png', 'Ancara para cara sana insana, vaya palo este', 2),
(4, '2024-01-23', '18:37:00', '/files/2024-01-23T18_37_17.116207600.png', 'Monkey Vibes de Sacra JR producido por Tainy, infravaloradísimo', 1),
(5, '2024-01-23', '22:09:00', NULL, 'El nuevo álbum de Eladio Carrión flojito', 2),
(6, '2024-01-24', '00:01:00', NULL, 'Bad Bunny (el malvado conejo) está sobrevalorado. Este es el post.', 3),
(8, '2024-01-24', '11:45:00', '/files/2024-01-24T11_45_37.258136800.png', 'Los Mas Pegaos 2.0 de Kidd Keo es una locura', 4),
(9, '2024-01-24', '11:47:00', NULL, 'Yo con mi man, esos son 2', 1),
(10, '2024-01-24', '11:52:00', '/files/2024-01-24T11_52_51.385359400.png', '\r\n💥 \"DIOR\" de Pop Smoke hace historia en Spotify 💥 La canción se corona como la más escuchada del drill, marcando un hito para el género. 🔥 Con su distintivo sonido y las líricas afiladas de Pop Smoke, \"DIOR\" se ha convertido en un himno global, trascendiendo fronteras. 🌎🎵 ¡El legado del drill vive en cada reproducción! 🔊', 5),
(11, '2024-01-24', '12:11:00', '/files/2024-01-24T12_11_57.333898500.png', '🔓 ¡Bando Boyz Free 2 de Kidd Keo rompe cadenas en Spotify! 🔥 La canción se corona como el himno del momento, llevando el sonido único de Kidd Keo a la cima. 🚀 Con su estilo inconfundible y ritmo imparable, Keo ha conquistado las listas, haciendo de \"Bando Boyz Free 2\" la más escuchada del género. 🌐🔊 ¡El trap vibra con fuerza! 💪', 5),
(12, '2024-01-24', '12:21:00', NULL, 'Los más pegaos\' en el bloque, \'toy montao ya no hay quien me toque... ', 3),
(13, '2024-01-24', '12:26:00', '/files/2024-01-24T12_26_41.532145200.png', '🎤 Explorando los clásicos: \"Only If You Want It\" de Eazy-E sigue siendo un tesoro del rap. Con la inconfundible entrega de Eazy, esta pista sigue resonando décadas después. 🔥 ¿Cuál es tu verso favorito de esta joya del hip-hop? 🔄', 5),
(15, '2024-01-24', '12:37:00', '/files/2024-01-24T12_37_28.279658200.png', '\"Es épico - Canserbero\". Una de las mejores canciones de la historia 🎶🎶🎶', 6),
(16, '2024-01-24', '13:01:00', NULL, 'Ey, boy a gotta get my cash 🎼🎵🎶', 7),
(17, '2024-01-24', '13:04:00', NULL, 'So won\'t the real Slim Shady please stand up 🎤', 8),
(18, '2024-01-24', '13:09:00', NULL, 'Alguien me recomienda nueva música de trap?', 2),
(19, '2024-01-24', '13:11:00', '/files/2024-01-24T13_11_52.002438300.png', '2PAC la cabra de esto 🐐', 4),
(20, '2024-01-24', '13:24:00', '/files/2024-01-24T13_24_23.514482400.png', '🚒¡ Llamen a los bomberos que esto está que arde!\r\n🚀 ¡Peri.R3 nos sorprende con su flow incomparable en esta pista que promete romper esquemas! La combinación de la destreza lírica de Peri.R3 y la magia de la producción de T3T0N hace que esta canción sea un auténtico viaje auditivo.', 5),
(21, '2024-01-24', '13:28:00', '/files/2024-01-24T13_28_01.992330.png', 'Che pive recién salió mi nueva sesión con PeriR3, vayan a darle un check. ', 9),
(22, '2024-01-24', '13:31:00', '/files/2024-01-24T13_31_11.946491100.png', 'Nuevo palo darle like si os gusta, si os disgusta no deis nada', 11),
(23, '2024-01-24', '13:32:00', '/files/2024-01-24T13_32_53.646397300.png', 'Alguien ha escuchado este palo? Lo recomiendo', 8),
(24, '2024-01-24', '13:35:00', '/files/2024-01-24T13_35_48.329573100.png', 'He tenido el honor de producir este palo, dadle un try', 12),
(25, '2024-01-24', '13:38:00', '/files/2024-01-24T13_38_32.337001400.png', '¡Desata la nostalgia con el clásico \"Loyal to the Game\" de 2Pac, producido por Eminem! 🎤🔥 Una fusión épica que trasciende el tiempo, llevándonos a través de las calles con la lírica inconfundible de 2Pac y los beats magistrales de Eminem. 🕰️✨ ¡Revive la esencia del rap con esta obra maestra! #2Pac #Eminem #LoyalToTheGame #HipHop 🎶🔊', 5),
(26, '2024-01-24', '13:39:00', NULL, 'La nueva sesión de Bizarrap es una mierda, lo digo aquí', 6),
(27, '2024-01-24', '13:41:00', NULL, '¿Qué os ha parecido mi nueva sesión con BZRP? Os leo 👀', 1),
(28, '2024-01-24', '13:42:00', NULL, 'El Rap de Dudu es GOD', 2),
(29, '2024-01-24', '13:43:00', NULL, 'Tu quieres catar pero solo hay 2, una para mi y otra pa\' el doctor... 🎶🎶🎶', 4),
(30, '2024-01-24', '13:44:00', NULL, 'MDPOLLO ON THE RAP KLK', 3),
(31, '2024-01-24', '13:46:00', '/files/2024-01-24T13_46_49.013800300.png', '¡La nueva sesión de Bizarrap con Peri.R3 ha generado revuelo, pero no precisamente positivo. 😬🎤 Los fans expresan su descontento, argumentando que la fusión no resalta lo mejor del artista. ¿Tú qué opinas? Comparte tus pensamientos sobre esta controvertida colaboración. #Bizarrap #PeriR3 #OpinionesMusicales 🤔🎶', 5),
(32, '2024-01-24', '13:47:00', NULL, 'La nueva sesión es GOD. Si no les gusta no la escucharon bien 😎', 9),
(33, '2024-01-24', '19:48:00', '/files/2024-01-24T19_48_21.290615500.png', 'Foto de prueba', 2),
(34, '2024-01-24', '20:26:00', NULL, 'hola', 2),
(35, '2024-01-25', '12:36:00', '/files/2024-01-25T12_36_28.726013jpg', 'PATATUDO', 2),
(36, '2024-01-25', '12:38:00', '/files/2024-01-25T12_38_24.704257500.jpg', 'AAAA', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post_like`
--

CREATE TABLE `post_like` (
  `id` bigint(20) NOT NULL,
  `state` bit(1) NOT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `post_like`
--

INSERT INTO `post_like` (`id`, `state`, `post_id`, `user_id`) VALUES
(1, b'1', 3, 1),
(2, b'1', 5, 2),
(3, b'1', 5, 1),
(4, b'1', 5, 3),
(5, b'1', 4, 1),
(6, b'1', 1, 2),
(7, b'1', 6, 1),
(8, b'1', 5, 4),
(9, b'1', 2, 4),
(10, b'1', 8, 1),
(11, b'1', 9, 4),
(12, b'1', 11, 2),
(13, b'1', 10, 2),
(14, b'1', 9, 2),
(15, b'1', 11, 1),
(16, b'1', 10, 1),
(17, b'1', 11, 4),
(18, b'1', 10, 4),
(19, b'1', 11, 3),
(20, b'1', 9, 3),
(21, b'1', 8, 3),
(22, b'1', 4, 3),
(23, b'1', 13, 1),
(24, b'1', 13, 2),
(25, b'1', 13, 4),
(26, b'1', 13, 3),
(27, b'1', 15, 2),
(28, b'1', 15, 1),
(29, b'1', 15, 3),
(30, b'1', 15, 4),
(31, b'1', 15, 5),
(32, b'1', 15, 7),
(33, b'1', 16, 8),
(34, b'1', 15, 8),
(35, b'1', 18, 3),
(36, b'1', 20, 2),
(37, b'1', 20, 1),
(38, b'1', 20, 4),
(39, b'1', 20, 3),
(40, b'1', 21, 10),
(41, b'1', 21, 1),
(42, b'1', 21, 2),
(43, b'1', 21, 11),
(44, b'1', 22, 8),
(45, b'1', 24, 1),
(46, b'1', 23, 1),
(47, b'1', 24, 4),
(48, b'1', 23, 4),
(49, b'1', 22, 4),
(50, b'1', 21, 4),
(51, b'1', 25, 6),
(52, b'1', 27, 4),
(53, b'1', 31, 3),
(54, b'1', 30, 3),
(55, b'1', 32, 8),
(56, b'1', 31, 8),
(57, b'1', 29, 8),
(58, b'1', 32, 4),
(59, b'1', 32, 2),
(60, b'1', 31, 2),
(61, b'0', 30, 2),
(62, b'0', 27, 2),
(63, b'1', 25, 2),
(64, b'1', 32, 11),
(65, b'1', 31, 11),
(66, b'1', 32, 12),
(67, b'1', 28, 12),
(68, b'1', 1, 9),
(69, b'1', 32, 9),
(70, b'1', 33, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post_like_seq`
--

CREATE TABLE `post_like_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `post_like_seq`
--

INSERT INTO `post_like_seq` (`next_val`) VALUES
(751);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `avatar` text NOT NULL,
  `banner` text NOT NULL,
  `bio` text DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `followed` bigint(20) NOT NULL,
  `followers` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `avatar`, `banner`, `bio`, `email`, `name`, `password`, `username`, `followed`, `followers`) VALUES
(1, '/files/2024-01-23T18_27_46.146333500.png', '/files/2024-01-24T00_00_03.048322400.png', 'Musicólogo con 3 años de experiencia en el sector. Apasionado de la música. Opinions are my own.', 'perikilldead@gmail.com', 'Peri', '$2a$10$czSXB9PlzPzRyJWsyeKoxuoSjpMXV19aZTrpG8EGPuw9l7mXf6GfC', 'PeriR3', 0, 0),
(2, '/files/2024-01-24T20_25_27.904524100.png', '/files/2024-01-24T20_25_38.476635100.png', 'aaa', 'mr.juancg@gmail.com', 'aaa', '$2a$10$gAwHTXfSiWC.7yb4wvyHIOQ3AJmZbX4FGc2PsgpL68/s/qieOsRZq', 'Juancg', 0, 0),
(3, '/files/2024-01-24T18_28_12.386305600.png', '/files/2024-01-24T18_30_13.158660300.png', 'Vengo aquí a ser objetivo', 'dociliano@gmail.com', 'Pedroma', '$2a$10$Mqbmtwk5EFIIsn9sf3iOH.0BfKx0nDHNzm/bzWPMY0L29hZPSA.L6', 'Dociliano', 0, 0),
(4, '/files/2024-01-24T11_45_49.173405900.png', '/files/2024-01-24T11_45_58.170068600.png', 'He venido a hablar', 'jorge@gmail.com', 'Jorge', '$2a$10$l179MhR.PVuT9ebHXvtWXus6KRORDjgeHZz1PXBkniI9HXd6ykx4G', 'jorgemg', 0, 0),
(5, '/files/2024-01-24T12_14_38.238035100.png', '/files/2024-01-24T12_15_15.457996600.png', '🎵 Descubre el mundo de la música con #InfoMusic 🌐✨ Tu fuente confiable para la música', 'infomusic@gmail.com', 'InfoMusic', '$2a$10$aN5w9ii/KhTFZWnUpMxKWeJ/k8wd624GprlT66EDBK5oo9OB.UDSS', 'InfoMusic', 0, 0),
(6, '/files/2024-01-24T12_35_09.359255600.png', '/img/default_banner.png', '¡Soy nuevo en Sounders!', 'slait@gmail.com', 'Slait', '$2a$10$/PySxJmUI3pSexjBarETAeBc6UzQg8BTKV7dazUzNhXZx9N6WNXLe', 'Slait33', 0, 0),
(7, '/files/2024-01-24T13_00_33.471378900.png', '/img/default_banner.png', '¡Soy nuevo en Sounders!', 'chema@gmail.com', 'Chema', '$2a$10$bxMKwKcyuAUTUsK4bmGxBOCF07bXURmsdysaBHlK/FppzSNanLuTe', 'chemafdz', 0, 0),
(8, '/files/2024-01-24T13_03_59.139459700.png', '/img/default_banner.png', 'Mejor una almeja que estar entre rejas #barras', 'comealmejas@gmail.com', 'Juanjo', '$2a$10$tXcA2s5C7mPdriN3nfi0duB2.6uyd/YWEH07SWvWGZae9pbvJFePm', 'ComeAlmejas', 0, 0),
(9, '/files/2024-01-24T13_27_38.605978800.png', '/files/2024-01-24T13_52_56.912431.png', 'prod by bzrp', 'bizarrap@gmail.com', 'BZRP', '$2a$10$O4CB9yWwderhcy8GqbUyXemBuewrygTOgs0qpk/ITv/DSSFcL/.vq', 'bizarrap', 0, 0),
(10, '/files/2024-01-24T13_29_04.603816.png', '/img/default_banner.png', 'Empiricamente', 'enrique@gmail.com', 'Enrique', '$2a$10$P0S0CEfHpWDy13LEcUPAEeFfPXeSfDSor5zOEbPJXG3evlrwLEpaa', 'enriquemouse', 0, 0),
(11, '/files/2024-01-24T13_30_46.805081100.png', '/img/default_banner.png', 'Cantante', 'leches@gmail.com', 'Milk G', '$2a$10$4/QyZHbnpj99p4ahhfMr5OOnbmrN6b3vyTM8NlJ4FMRdANEdAad2K', 'lechesG', 0, 0),
(12, '/files/2024-01-24T13_35_04.973992900.png', '/img/default_banner.png', 'DJ & Producer', 'joseda@gmail.com', 'Joseda', '$2a$10$ly5CG2yeZwqomdn7G40cHe/wsL15JLLLDRNZU7eaWCsJydgci4.CO', 'Jxsedaaa', 0, 0),
(13, '/img/default_avatar.png', '/img/default_banner.png', '¡Soy nuevo en Sounders!', 'prueba@gmail.com', 'prueba', '$2a$10$HkYO1eK31UFSaFQKPJ3F0efUh7deEao/TUShvW0jwiN2zzhPhaVe.', 'Prueba334', 0, 0),
(14, '/img/default_avatar.png', '/img/default_banner.png', '¡Soy nuevo en Sounders!', 'hola@gmail.com', 'hola', '$2a$10$RbfUILoh7vrYkQsyABh1YuHgrKJO3EZGP9XWdzsv9Pj2eZMMVJ0xG', 'hola', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn2na60ukhs76ibtpt9burkm27` (`author_id`),
  ADD KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`);

--
-- Indices de la tabla `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9a25x9o5r7wguarxeon2a9tmr` (`receiver_id`),
  ADD KEY `FKbi5avhe69aol2mb1lnm6r4o2p` (`sender_id`);

--
-- Indices de la tabla `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6xvn0811tkyo3nfjk2xvqx6ns` (`author_id`);

--
-- Indices de la tabla `post_like`
--
ALTER TABLE `post_like`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcf8kqsucxsmplv3xw9gubrql0` (`post_id`),
  ADD KEY `FKijnjmw0imnatadr3agtk0udip` (`user_id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`);

--
-- Indices de la tabla `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  ADD KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT de la tabla `message`
--
ALTER TABLE `message`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `posts`
--
ALTER TABLE `posts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `post_like`
--
ALTER TABLE `post_like`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FKn2na60ukhs76ibtpt9burkm27` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK9a25x9o5r7wguarxeon2a9tmr` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKbi5avhe69aol2mb1lnm6r4o2p` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FK6xvn0811tkyo3nfjk2xvqx6ns` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `post_like`
--
ALTER TABLE `post_like`
  ADD CONSTRAINT `FKcf8kqsucxsmplv3xw9gubrql0` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FKijnjmw0imnatadr3agtk0udip` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
