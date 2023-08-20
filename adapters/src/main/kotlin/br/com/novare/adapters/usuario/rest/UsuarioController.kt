package br.com.novare.adapters.usuario.rest

import br.com.novare.usecase.usuario.cadastrar.UsuarioCadastroBoundary
import br.com.novare.usecase.usuario.cadastrar.UsuarioCadastroInputData
import br.com.novare.usecase.usuario.listar.UsuarioListagemBoundary
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val usuarioListagemBoundary: UsuarioListagemBoundary,
    val usuarioCadastroBoundary: UsuarioCadastroBoundary
) {

    @GetMapping
    fun listar(
        @RequestParam("limite", required = false, defaultValue = "10") limite: Int,
        @RequestParam("pagina", required = false, defaultValue = "0") pagina: Long
    ): ResponseEntity<*> {
        val usuarios = usuarioListagemBoundary.listar(limite, pagina)
        return ResponseEntity.ok(usuarios)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody usuario: UsuarioCadastroInputData,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): ResponseEntity<*> {
        val id = usuarioCadastroBoundary.cadastrar(usuario)
        val requestURL = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri().toASCIIString()
        val uri = "$requestURL/$id"
        response.setHeader("Location", uri)
        return ResponseEntity.created(URI(uri)).build<Any>()
    }

    @GetMapping("/possui-permissao/{id}")
    fun possuiPermissao(@PathVariable("id") idUsuario: Long?): ResponseEntity<*> {
        return ResponseEntity.ok("possuiPermissao")
    }
}
