import org.junit.jupiter.api.Test;
import Exception.CorretoraNuloException;
import Exception.CarteiraNuloException;


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
        } catch (CorretoraNuloException e)
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
        } catch (CarteiraNuloException e)
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
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);

        cliente.comprarInvestimento(empresa, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(true, empresa.verificarExistenciaAcionista(cliente));
    }
    @Test
    void deveComprarAcaoEmpresa2()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(),new CarteiraBolsa());
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        Empresa empresa2 = new Empresa("Bradesco", 15.0d, 1.0d);


        cliente.comprarInvestimento(empresa, 1);
        cliente.comprarInvestimento(empresa2, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(true, cliente.verificaExistenciaInvestimento(empresa2));
        assertEquals(true, empresa.verificarExistenciaAcionista(cliente));
    }

    @Test
    void deveComprarCriptomoeda()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
        Carteira carteira = cliente.getCarteira();
        Criptomoeda criptomoeda = new Criptomoeda();

        cliente.comprarInvestimento(criptomoeda, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(criptomoeda));
    }
    @Test
    void deveComprarCriptomoeda2()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
        Carteira carteira = cliente.getCarteira();
        Criptomoeda criptomoeda = new Criptomoeda();
        Criptomoeda criptomoeda2 = new Criptomoeda();

        cliente.comprarInvestimento(criptomoeda, 1);
        cliente.comprarInvestimento(criptomoeda2, 1);
        assertEquals(true, cliente.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(true, cliente.verificaExistenciaInvestimento(criptomoeda2));
    }

    @Test
    void deveVenderAcaoEmpresa()
    {
        Carteira carteira = new CarteiraBolsa();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        cliente.comprarInvestimento(empresa, 1);

        cliente.venderInvestimento(empresa, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(empresa));
    }
    @Test
    void deveVenderAcaoEmpresa2()
    {
        Carteira carteira = new CarteiraBolsa();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        Empresa empresa2 = new Empresa("Microsoft", 400.0d, 3.0d);
        cliente.comprarInvestimento(empresa, 1);
        cliente.comprarInvestimento(empresa2, 1);

        cliente.venderInvestimento(empresa, 1);
        cliente.venderInvestimento(empresa2, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(empresa));
        assertEquals(false, cliente.verificaExistenciaInvestimento(empresa2));
    }

    @Test
    void deveVenderCriptomoeda()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
        Criptomoeda criptomoeda = new Criptomoeda();
        cliente.comprarInvestimento(criptomoeda, 1);

        cliente.venderInvestimento(criptomoeda, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(criptomoeda));
    }
    @Test
    void deveVenderCriptomoeda2()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
        Criptomoeda criptomoeda = new Criptomoeda();
        Criptomoeda criptomoeda2 = new Criptomoeda();
        cliente.comprarInvestimento(criptomoeda, 1);
        cliente.comprarInvestimento(criptomoeda2, 1);

        cliente.venderInvestimento(criptomoeda, 1);
        cliente.venderInvestimento(criptomoeda2, 1);
        assertEquals(false, cliente.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(false, cliente.verificaExistenciaInvestimento(criptomoeda2));
    }

    @Test
    void deveRetornarClienteInativo()
    {
        Carteira carteira = new CarteiraCriptomoeda();
        Cliente cliente = new Cliente("Daniel", new Corretora(), carteira);
        assertEquals("Inativo", cliente.getDescricaoStatus());
    }

    @Test
    void deveRetornarClienteAtivo()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
        Criptomoeda criptomoeda = new Criptomoeda();

        cliente.comprarInvestimento(criptomoeda, 1);
        assertEquals("Ativo", cliente.getDescricaoStatus());
    }

}