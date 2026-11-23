package padroescriacionais.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentoPrototipoTest {

    @Test
    void cloneDeveSerOutraInstanciaComMesmoConteudo() {
        Relatorio original = new Relatorio("Mensal", "Vendas");
        Relatorio copia = (Relatorio) original.clonar();
        assertNotSame(original, copia);
        assertEquals(original.descrever(), copia.descrever());
    }

    @Test
    void cloneDeveCopiarListaEmProfundidade() {
        Relatorio original = new Relatorio("Mensal", "Vendas");
        original.adicionarTag("financeiro");
        Relatorio copia = (Relatorio) original.clonar();
        copia.adicionarTag("extra");
        assertEquals(1, original.getTags().size());
        assertEquals(2, copia.getTags().size());
    }

    @Test
    void alterarCopiaNaoDeveAlterarOriginal() {
        Contrato original = new Contrato("Cliente", 500.0);
        Contrato copia = (Contrato) original.clonar();
        copia.setContratante("ACME");
        copia.adicionarClausula("Multa de 10%");
        assertEquals("Cliente", original.getContratante());
        assertTrue(original.getClausulas().isEmpty());
        assertEquals(500.0, copia.getValor());
    }

    @Test
    void registroDeveCriarNovaCopiaACadaChamada() {
        RegistroDocumentos registro = new RegistroDocumentos();
        registro.registrar("contrato", new Contrato("Cliente", 100.0));
        DocumentoPrototipo a = registro.criar("contrato");
        DocumentoPrototipo b = registro.criar("contrato");
        assertNotSame(a, b);
        assertEquals(a.descrever(), b.descrever());
    }

    @Test
    void registroDeveRecusarPrototipoInexistente() {
        RegistroDocumentos registro = new RegistroDocumentos();
        assertThrows(IllegalArgumentException.class, () -> registro.criar("nada"));
    }
}
