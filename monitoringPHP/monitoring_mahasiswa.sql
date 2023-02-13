-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Feb 2023 pada 00.20
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `monitoring_mahasiswa`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_image`
--

CREATE TABLE `tbl_image` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `nis` int(11) NOT NULL,
  `jam` varchar(50) NOT NULL,
  `kegiatan` varchar(50) NOT NULL,
  `lokasi` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `tgl` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_image`
--

INSERT INTO `tbl_image` (`id`, `name`, `nis`, `jam`, `kegiatan`, `lokasi`, `user`, `tgl`) VALUES
(19, 'cherrybeats0ue.jpg', 0, '', '', '', '', ''),
(20, 'ukuran 3x4 warna-removebg-preview (1).jpg', 0, '', '', '', '', ''),
(21, 'circuit_diagram_door_lock_qKMpyoVA8K.png', 12434, '12:12', 'kegiatan', 'lokasi', 'user', '12-12-2012'),
(22, 'Screenshot (1).png', 0, '', '', '', '', '12-12-2012'),
(23, '', 0, '', '', '', '', ''),
(24, 'IMG796385731.jpg', 0, '', '', '', '', ''),
(25, '', 0, '', '', '', '', ''),
(26, '', 0, '', '', '', '', ''),
(27, 'IMG1757136950.jpg', 0, '', '', '', '', ''),
(28, 'IMG458328180.jpg', 272, 'd', 'sd', 'hshs', 'ddd', 'shsjs'),
(29, 'IMG120891105.jpg', 123, 'jam', 'kegiatan', 'lokasi', 'nama', 'percobaan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_image`
--
ALTER TABLE `tbl_image`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_image`
--
ALTER TABLE `tbl_image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
