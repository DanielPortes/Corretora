import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorretoraTest
{
    @Test
    void deveAdicionarCliente()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");

        Cliente cliente = new Cliente("Daniel",corretora);
        corretora.cadastrarCliente(cliente);
        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());
        assertEquals(true, corretora.verificaExistenciaCliente(cliente));
    }

    @Test
    void deveRemoverCliente()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel",corretora);
        corretora.cadastrarCliente(cliente);
        corretora.cancelarRegistro(cliente);
        assertEquals(false, corretora.verificaExistenciaCliente(cliente));
    }
}



