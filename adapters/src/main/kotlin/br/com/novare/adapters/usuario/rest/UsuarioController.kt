package br.com.novare.adapters.usuario.rest

import br.com.novare.usecase.usuario.listar.UsuarioListagemBoundary
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val usuarioListagemBoundary: UsuarioListagemBoundary
) {

    @GetMapping
    fun listar(
        @RequestParam("limite", required = false, defaultValue = "10") limite: Int,
        @RequestParam("pagina", required = false, defaultValue = "0") pagina: Long
    ): ResponseEntity<*> {
        val usuarios = usuarioListagemBoundary.listar(limite, pagina)
        return ResponseEntity.ok(usuarios)
    }

    @GetMapping("/possui-permissao/{id}")
    fun possuiPermissao(@PathVariable("id") idUsuario: Long?): ResponseEntity<*> {
        return ResponseEntity.ok("possuiPermissao")
    }
}
