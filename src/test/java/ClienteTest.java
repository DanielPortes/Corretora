import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest
{
    @Test
    void deveComprarEmpresa()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora());
        Carteira carteira = new CarteiraBolsa();
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        cliente.comprarInvestimento(empresa, 1);

        assertEquals(true, cliente.retornaExistenciaInvestimento(empresa));
    }

    @Test
    void deveAdicionarCorretora()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora);
        corretora.setNome("InvesteFacil");

        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());
        assertTrue(corretora.verificaExistenciaCliente(cliente));

    }

    @Test
    void deveRemoverCorretora()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora);
        cliente.cadastrar(corretora);
        cliente.cancelarCadastro();
        assertNull(cliente.getCorretora());
    }

    @Test
    void deveDevolverCorretora()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");
        Cliente cliente = new Cliente("Daniel", corretora);
        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());

    }

    @Test
    void deveRetornarCarteira()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora());
        Carteira carteira = new CarteiraBolsa();
        carteira.setCliente(cliente);
        assertEquals(carteira, cliente.getCarteira());

    }

    @Test
    void deveRetornarCarteiraNula()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora());
        Carteira carteira = new CarteiraCriptomoeda();
        assertNull(cliente.getCarteira());
    }

}