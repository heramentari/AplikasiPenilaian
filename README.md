# Aplikasi Penilaian


API List:
* api/getNilaiKuliah/[npm]/[kode_mk]
* api/getDaftarNilaiKuliah/[kode_mk]
* api/getStatistikNilaiKuliah/[kode_mk]

## api/getNilaiKuliah/[npm]/[kode_mk]

Mengembalikan nilai suatu mata kuliah dari seorang mahasiswa

**URL** : `api/getNilaiKuliah/[npm]/[kode_mk]`

**Method** : `GET`

### Success Response

**Contoh Request**: api/getNilaiKuliah/15041412/CSC123

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

**Contoh Request**: api/getNilaiKuliah/123/213

```json
{"status":404,"msg":"Mahasiswa dan atau mata kuliah tidak ditemukan"}
```

## api/getDaftarNilaiKuliah/[kode_mk]

Mengembalikan daftar peserta dan nilai suatu mata kuliah

**URL** : ` api/getDaftarNilaiKuliah/[kode_mk]`

**Method** : `GET`

### Success Response

**Contoh Request**: api/getDaftarNilaiKuliah/CSC123

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

**Contoh Request**: api/getDaftarNilaiKuliah/123

```json
{"status":404,"msg":"Mata Kuliah tidak ditemukan"}
```

## api/getStatistikNilaiKuliah/[kode_mk]

Mengembalikan data statistik dari suatu mata kuliah

**URL** : `api/getStatistikNilaiKuliah/[kode_mk]`

**Method** : `GET`

### Success Response
**Contoh Request**: api/getStatistikNilaiKuliah/CSC123

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

**Contoh Request**: api/getStatistikNilaiKuliah/123

```json
{"status":404,"msg":"Mata Kuliah tidak ditemukan"}
```
--
