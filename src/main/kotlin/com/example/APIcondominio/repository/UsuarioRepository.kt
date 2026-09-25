package com.example.APIcondominio.repository

import com.example.APIcondominio.entity.usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<usuario, Long> {
}