package br.com.novare.usecase.usuario.cadastrar

interface UsuarioCadastroBoundary {
    fun cadastrar(usuario: UsuarioCadastroInputData): Long
}
