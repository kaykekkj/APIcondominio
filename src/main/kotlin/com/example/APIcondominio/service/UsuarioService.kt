package com.example.APIcondominio.service

import com.example.APIcondominio.entity.usuario
import com.example.APIcondominio.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val repository: UsuarioRepository) {

    fun cadastrar(usuario: usuario): usuario {
        return repository.save(usuario)
    }

    fun listar() : List<usuario> {
        return repository.findAll()
    }

    fun buscar(id: Long) : usuario? {
        return repository.findById(id).orElse(null)
    }

    fun excluir(id: Long) : Boolean{
        if (!repository.existsById(id)){
            return false
        }
        repository.deleteById(id)
        return true
    }

    fun atualizar(id: Long, usuario: usuario) :  usuario?{
        var usuarioexistente = repository.findById(id).orElse(null)?: return null
        usuarioexistente.email = usuario.email
        usuarioexistente.senha = usuario.senha
        return repository.save(usuarioexistente)
    }
}