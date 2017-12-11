CREATE TABLE users (
id VARCHAR(15) PRIMARY KEY,
username VARCHAR (225) UNIQUE,
password VARCHAR (225) NOT NULL,
nama VARCHAR (225) NOT NULL,
role VARCHAR(15) NOT NULL,
enabled TINYINT(1) NOT NULL DEFAULT 1);

CREATE TABLE mata_kuliah (
kode_mk VARCHAR (15) PRIMARY KEY,
nama VARCHAR (225) NOT NULL,
kuota int DEFAULT NULL,
periode VARCHAR (15) NOT NULL,
sks int NOT NULL);

CREATE TABLE nilai_mk (
id int PRIMARY KEY AUTO_INCREMENT,
npm VARCHAR (15) NOT NULL,
kode_mk VARCHAR (15) NOT NULL,
nilai double DEFAULT NULL,
FOREIGN KEY (npm) REFERENCES users(id),
FOREIGN KEY (kode_mk) REFERENCES mata_kuliah(kode_mk));

CREATE TABLE statistik_nilai_mk (
id int PRIMARY KEY AUTO_INCREMENT,
kode_mata_kuliah VARCHAR (15) NOT NULL,
nilai_tertinggi double NOT NULL,
nilai_terendah double NOT NULL,
nilai_average double NOT NULL,
std_deviasi double NOT NULL,
FOREIGN KEY (kode_mata_kuliah) REFERENCES mata_kuliah(kode_mk));

CREATE TABLE mk_users (
id VARCHAR (15) NOT NULL,
kode_mk VARCHAR(15) NOT NULL,
PRIMARY KEY (id,kode_mk),
FOREIGN KEY (id) REFERENCES users(id),
FOREIGN KEY (kode_mk) REFERENCES mata_kuliah(kode_mk));

INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('1234567890', 'alberto', 'inialberto', 'Alberto Stevanus', 'ROLE_MAHASISWA', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('1234567891', 'hera', 'inihera', 'Hera Mentari', 'ROLE_MAHASISWA', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('1234567892', 'radit', 'iniradit', 'Raditya Nurfadillah', 'ROLE_MAHASISWA', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('1234567893', 'saras', 'inisaras', 'Saraswati', 'ROLE_MAHASISWA', true);

INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543210', 'qorib', 'iniqorib', 'Qorib Munajat', 'ROLE_DOSEN', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543211', 'samuel', 'inisamuel', 'Samuel Louvan', 'ROLE_DOSEN', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543212', 'nurfitriah', 'ininurfitriah', 'Nur Fitriah Ayuning Budi', 'ROLE_DOSEN', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543213', 'rizal', 'inirizal', 'Rizal Fathoni Aji', 'ROLE_DOSEN', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543214', 'ave', 'iniave', 'Ave Adriana Pinem', 'ROLE_DOSEN', true);
INSERT INTO users (id, username, password, nama, role, enabled)
VALUES ('9876543215', 'harry', 'iniharry', 'Harry Budi Santoso', 'ROLE_DOSEN', true);

INSERT INTO mata_kuliah (kode_mk, nama, kuota, periode, sks)
VALUES ('CSC120', 'Arsitektur dan Pemrograman Aplikasi Perusahaan', '45', '2017/2018 Gasal', '4');
INSERT INTO mata_kuliah (kode_mk, nama, kuota, periode, sks)
VALUES ('CSC121', 'Analisa dan Perancangan Sistem', '40', '2017/2018 Gasal', '3');
INSERT INTO mata_kuliah (kode_mk, nama, kuota, periode, sks)
VALUES ('CSC122', 'Jaringan Komunikasi Data', '60', '2017/2018 Gasal', '3');
INSERT INTO mata_kuliah (kode_mk, nama, kuota, periode, sks)
VALUES ('CSC123', 'Manajemen Proyek TI', '50', '2017/2018 Gasal', '3');
INSERT INTO mata_kuliah (kode_mk, nama, kuota, periode, sks)
VALUES ('CSC124', 'Sistem Interaksi', '55', '2017/2018 Gasal', '3');

INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567890', 'CSC120', '90');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567890', 'CSC121', '85');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567890', 'CSC122', '80');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567890', 'CSC123', '75');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567890', 'CSC124', '70');

INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567891', 'CSC120', '85');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567891', 'CSC121', '80');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567891', 'CSC122', '75');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567891', 'CSC123', '70');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567891', 'CSC124', '90');

INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567892', 'CSC120', '80');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567892', 'CSC121', '75');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567892', 'CSC122', '70');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567892', 'CSC123', '90');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567892', 'CSC124', '85');

INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567893', 'CSC120', '75');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567893', 'CSC121', '70');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567893', 'CSC122', '90');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567893', 'CSC123', '85');
INSERT INTO nilai_mk (npm, kode_mk, nilai)
VALUES ('1234567893', 'CSC124', '80');

INSERT INTO statistik_nilai_mk (kode_mata_kuliah, nilai_tertinggi, nilai_terendah, nilai_average, std_deviasi)
VALUES ('CSC120', '90', '75', '82.5', '6.45');
INSERT INTO statistik_nilai_mk (kode_mata_kuliah, nilai_tertinggi, nilai_terendah, nilai_average, std_deviasi)
VALUES ('CSC121', '85', '70', '77.5', '6.45');
INSERT INTO statistik_nilai_mk (kode_mata_kuliah, nilai_tertinggi, nilai_terendah, nilai_average, std_deviasi)
VALUES ('CSC122', '90', '70', '78.75', '8.53');
INSERT INTO statistik_nilai_mk (kode_mata_kuliah, nilai_tertinggi, nilai_terendah, nilai_average, std_deviasi)
VALUES ('CSC123', '90', '70', '82', '9.12');
INSERT INTO statistik_nilai_mk (kode_mata_kuliah, nilai_tertinggi, nilai_terendah, nilai_average, std_deviasi)
VALUES ('CSC124', '90', '70', '81.25', '8.53');

INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567890', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567890', 'CSC121');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567890', 'CSC122');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567890', 'CSC123');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567890', 'CSC124');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567891', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567891', 'CSC121');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567891', 'CSC122');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567891', 'CSC123');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567891', 'CSC124');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567892', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567892', 'CSC121');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567892', 'CSC122');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567892', 'CSC123');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567892', 'CSC124');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567893', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567893', 'CSC121');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567893', 'CSC122');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567893', 'CSC123');
INSERT INTO mk_users (id, kode_mk)
VALUES ('1234567893', 'CSC124');

INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543210', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543211', 'CSC120');
INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543212', 'CSC121');
INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543213', 'CSC122');
INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543214', 'CSC123');
INSERT INTO mk_users (id, kode_mk)
VALUES ('9876543215', 'CSC124');