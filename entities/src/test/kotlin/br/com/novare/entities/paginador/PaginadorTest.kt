package br.com.novare.entities.paginador

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class PaginadorTest {

    @Test
    fun `deve retornar uma excecao quando o limit for menor que zero`() {
        val limit = -1
        val offset = 0
        val excecao = assertThrows(PaginadorInvalidoException::class.java) {
            PaginadorEntity(limit, offset)
        }
        assertEquals("Limit deve ser maior ou igual a zero", excecao.message)
    }
}
