package br.com.novare.usecase.categoria.cadastrar;

import br.com.novare.entities.categoria.CategoriaEntityFactory;
import br.com.novare.entities.categoria.CategoriaFactory;
import br.com.novare.entities.categoria.CategoriaInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaCadastroInteractorTest {

    @Mock
    private CategoriaCadastroGateway gateway;

    private CategoriaCadastroInteractor interactor;

    @BeforeEach
    void setUp() {
        CategoriaFactory factory = new CategoriaEntityFactory();
        interactor = new CategoriaCadastroInteractor(gateway, factory);
    }

    @Test
    @DisplayName("Caso nome seja informática e descrição seja produtos de informática, quando cadastrando, deve retornar response dto")
    void casoNomeSejaInformaticaDescricaoSejaProdutosInformatica_quandoCadastrando_deveRetornarResponseDto() {
        doReturn(false).when(gateway).existeComMesmoNome("Informática");
        doReturn(1L).when(gateway).cadastrar(new CategoriaRequestData("Informática", "Produtos de informática"));

        CategoriaRequestDto requestDto = new CategoriaRequestDto("Informática", "Produtos de informática");
        CategoriaResponseDto responseDto = interactor.cadastrar(requestDto);

        assertNotNull(responseDto);
        assertNotNull(responseDto.id());
        assertEquals(1L, responseDto.id());
        assertEquals("Informática", responseDto.nome());
        assertEquals("Produtos de informática", responseDto.descricao());
    }

    @Test
    @DisplayName("Caso nome seja informática e descrição seja produtos de informática, mas já exista categoria com mesmo nome, quando cadastrando, deve lançar exceção")
    void casoNomeSejaInformaticaDescricaoSejaProdutosInformatica_casoExistaCategoriaComMesmoNome_deveLancarExcecao() {
        doReturn(true).when(gateway).existeComMesmoNome("Informática");

        CategoriaRequestDto requestDto = new CategoriaRequestDto("Informática", "Produtos de informática");
        CategoriaInvalidaException exception = assertThrows(CategoriaInvalidaException.class, () -> interactor.cadastrar(requestDto));

        assertEquals("Já existe uma categoria com o nome informado", exception.getMessage());
        verify(gateway, never()).cadastrar(any());
    }


}
