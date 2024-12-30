package com.example.meet13.model

import kotlinx.serialization.*

@Serializable
data class Mahasiswa (
    val nama: String,
    val nim: String,
    val alamat: String,

    @SerialName("jenis_kelamin")
    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)