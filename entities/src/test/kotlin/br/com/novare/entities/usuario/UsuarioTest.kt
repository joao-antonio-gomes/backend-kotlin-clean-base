package br.com.novare.entities.usuario

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

class UsuarioTest {

    @Test
    fun `deve criar um usuario`() {
        UsuarioEntity(
            id = null,
            nome = "Teste",
            email = "teste@email.com",
            senha = "Teste@123",
            admin = false,
            status = UsuarioStatus.ATIVO,
            avatarUrl = null,
            dataCriacao = LocalDateTime.now()
        )
    }

    @Test
    fun `deve lancar exception quando nome for vazio`() {
        val exception = assertThrows<UsuarioInvalidoException> {
            UsuarioEntity(
                id = null,
                nome = "",
                email = "teste@email.com",
                senha = "Teste@123",
                admin = false,
                status = UsuarioStatus.ATIVO,
                avatarUrl = null,
                dataCriacao = LocalDateTime.now()
            )
        }
        Assertions.assertEquals("Nome não pode ser vazio", exception.message)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "TESTE@1111",
            "teste@123456",
            "testeEEEEEEEEE",
            "Teste@1",
        ]
    )
    fun `deve lancar exception quando senha for invalida`(senha: String) {
        val exception = assertThrows<UsuarioInvalidoException> {
            UsuarioEntity(
                id = null,
                nome = "Teste",
                email = "teste@email.com",
                senha = senha,
                admin = false,
                status = UsuarioStatus.ATIVO,
                avatarUrl = null,
                dataCriacao = LocalDateTime.now()
            )
        }
        Assertions.assertEquals(
            "Senha deve conter ao menos 1 letra maiúscula, 1 letra minúscula, 1 número ou 1 caractere especial e possuir pelo menos 8 caracteres",
            exception.message
        )
    }
}
