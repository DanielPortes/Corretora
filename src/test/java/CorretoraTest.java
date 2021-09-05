import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorretoraTest
{
    @Test
    void deveAdicionarCliente()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");

        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
        corretora.cadastrarCliente(cliente);
        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());
        assertEquals(true, corretora.verificaExistenciaCliente(cliente));
    }

    @Test
    void deveRemoverCliente()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
        corretora.cadastrarCliente(cliente);
        corretora.cancelarRegistro(cliente);
        assertEquals(false, corretora.verificaExistenciaCliente(cliente));
        assertNull(cliente.getCorretora());
    }

    @Test
    void deveRetornarMontanteInvestidoZero(){
        Corretora corretora = new Corretora();

        assertEquals(0,corretora.montanteInvestido());
    }
    @Test
    void deveRetornarMontanteInvestido(){
        Carteira carteira = new CarteiraBolsa();
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora, carteira);
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);

        cliente.comprarInvestimento(empresa, 1);

        assertEquals(15,corretora.montanteInvestido());
    }


}



