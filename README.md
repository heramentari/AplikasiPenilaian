# Aplikasi Penilaian


API List:
* getNilaiKuliah/[npm]/[kode_mk]
* getDaftarNilaiKuliah/[kode_mk]
* getStatistikNilaiKuliah/[kode_mk]

## getNilaiKuliah/[npm]/[kode_mk]

Mengembalikan nilai suatu mata kuliah dari seorang mahasiswa

**URL** : `/getNilaiKuliah/[npm]/[kode_mk]`

**Method** : `GET`

### Success Response

**Contoh Request**: /getNilaiKuliah/15041412/CSC123

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "nilai_mk": {
      "id": 1,
      "npm": "1234567890",
      "kode_mk": "CSC123",
      "nilai": 76.25
  }
}
```
### Error Response

**Condition** :  Jika npm dan atau kode_mk tidak valid.

**Contoh Request**: /getNilaiKuliah/123/213

```json
{"status":404,"msg":"Mahasiswa dan atau mata kuliah tidak ditemukan"}
```

## getDaftarNilaiKuliah/[kode_mk]

Mengembalikan daftar peserta dan nilai suatu mata kuliah

**URL** : ` /getDaftarNilaiKuliah/[kode_mk]`

**Method** : `GET`

### Success Response

**Contoh Request**: /getDaftarNilaiKuliah/CSC123

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "kode_mk": "CSC123",
    "mahasiswa": [
      {
        "npm": "1502424149",
        "nama": "Aji",
       "nilai": 76.25
      },
      {
        "npm": "1506689420",
        "nama": "Hera",
        "nilai": 99.99
      }
    ]
  }
}
```
### Error Response

**Condition** :  Jika kode_mk tidak valid.

**Contoh Request**: /getDaftarNilaiKuliah/123

```json
{"status":404,"msg":"Mata Kuliah tidak ditemukan"}
```

## getStatistikNilaiKuliah/[kode_mk]

Mengembalikan data statistik dari suatu mata kuliah

**URL** : `/getUniversitasList/[id_univ]/[id_fakultas]`

**Method** : `GET`

### Success Response
**Contoh Request**: /getStatistikNilaiKuliah/CSC123

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "statistik_nilai_mk": {
      "id": "CSC123",
      "nilai_tertinggi": 93.34,
      "nilai_terendah": 45.32,
      "nilai_average": 73.25,
      "std_deviasi": 34.32
    }
  }
}
```

### Error Response

**Condition** : Jika kode_mk tidak valid.

**Contoh Request**: /getStatistikNilaiKuliah/123

```json
{"status":404,"msg":"Mata Kuliah tidak ditemukan"}
```
--
