import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/
class ClienteTest
{
    @Test
    void deveAdicionarCorretora()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora, new CarteiraCriptomoeda());
        corretora.setNome("InvesteFacil");

        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());
        assertTrue(corretora.verificaExistenciaCliente(cliente));
    }

    @Test
    void deveRemoverCorretora()
    {
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora, new CarteiraBolsa());

        cliente.cancelarCadastro();
        assertNull(cliente.getCorretora());
    }

    @Test
    void deveRetornarCorretora()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");
        Cliente cliente = new Cliente("Daniel", corretora, new CarteiraBolsa());
        assertEquals("InvesteFacil", cliente.getDescricaoCorretora());
    }

    @Test
    void deveRetornarExcecaoCorretoraNull()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", null, new CarteiraCriptomoeda());
            fail();
        } catch (IllegalArgumentException e)
        {
            assertEquals("Corretora valida deve ser informada", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoCarteiraNull()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora(), null);
            fail();
        } catch (IllegalArgumentException e)
        {
            assertEquals("Carteira valida deve ser informada", e.getMessage());
        }
    }

    @Test
    void deveRetornarCarteira()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraBolsa());
        Carteira carteira = cliente.getCarteira();
        carteira.setCliente(cliente);
        assertEquals(carteira, cliente.getCarteira());
    }

    @Test
    void deveComprarAcaoEmpresa()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(),new CarteiraBolsa());
        Carteira carteira = cliente.getCarteira();
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        cliente.setCarteira(carteira);

        cliente.comprarInvestimento(empresa, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(true, empresa.verificarExistenciaAcionista(cliente));
    }

    @Test
    void deveComprarCriptomoeda()
    {
        CarteiraCriptomoeda carteiraCriptomoeda = new CarteiraCriptomoeda();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteiraCriptomoeda);
        carteiraCriptomoeda.setCliente(cliente);
        Criptomoeda criptomoeda = new Criptomoeda();

        cliente.comprarInvestimento(criptomoeda, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(true, carteiraCriptomoeda.verificaExistenciaInvestimento(criptomoeda));
    }

    @Test
    void deveVenderAcaoEmpresa()
    {
        Carteira carteira = new CarteiraBolsa();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);

        cliente.comprarInvestimento(empresa, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(true, carteira.verificaExistenciaInvestimento(empresa));

        cliente.venderInvestimento(empresa, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(false, carteira.verificaExistenciaInvestimento(empresa));
    }

    @Test
    void deveVenderCriptomoeda()
    {
        Carteira carteira = new CarteiraCriptomoeda();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);

        Criptomoeda criptomoeda = new Criptomoeda();

        cliente.comprarInvestimento(criptomoeda, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(true, carteira.verificaExistenciaInvestimento(criptomoeda));

        cliente.venderInvestimento(criptomoeda, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(false, carteira.verificaExistenciaInvestimento(criptomoeda));
    }

    @Test
    void deveRetornarCLienteInativo()
    {
        Carteira carteira = new CarteiraCriptomoeda();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        assertEquals("Inativo", cliente.getDescricaoStatus());
    }

    @Test
    void deveRetornarCLienteAtivo()
    {
        Carteira carteira = new CarteiraCriptomoeda();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        Criptomoeda criptomoeda = new Criptomoeda();
        cliente.comprarInvestimento(criptomoeda, 1);
        assertEquals("Ativo", cliente.getDescricaoStatus());
    }

}