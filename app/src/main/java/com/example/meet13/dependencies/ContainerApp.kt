package com.example.meet13.dependencies

import com.example.meet13.repository.MahasiswaRepository

interface AppContainer {
    val kontakRepository: MahasiswaRepository
}

