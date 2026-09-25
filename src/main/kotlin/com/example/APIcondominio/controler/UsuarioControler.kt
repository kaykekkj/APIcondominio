package com.example.condservice.controller

import com.example.APIcondominio.entity.usuario
import com.example.APIcondominio.service.UsuarioService
import org.apache.catalina.connector.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/usuario")
@RestController
class usuariocontroler ( val service: UsuarioService) {

    @PostMapping
    fun cadastrar(@RequestBody usuario: usuario): ResponseEntity<usuario> {
        return ResponseEntity.ok(service.cadastrar(usuario))
    }
    @GetMapping
    fun listar(): ResponseEntity<List<usuario>> {
        return ResponseEntity.ok(service.listar())
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody usuario: usuario
    ): ResponseEntity<usuario> {
        val atualizacao = service.atualizar(id,usuario) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(atualizacao)
    }

    @DeleteMapping("/{id}")
    fun excluir(
        @PathVariable id: Long): ResponseEntity<Void> {

        val excluir = service.excluir(id)
        if (!excluir){
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.noContent().build()
    }
}

