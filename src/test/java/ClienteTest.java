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
        Carteira carteira = new CarteiraBolsa("Daniel", corretora);

        assertEquals("InvesteFacil", carteira.getDescricaoCorretora());
        assertTrue(corretora.verificaExistenciaCarteira(carteira));
    }

    @Test
    void deveRemoverCorretora()
    {
        Corretora corretora = new Corretora();
        Carteira carteira = new CarteiraBolsa("Daniel", corretora);


        carteira.cancelarCadastro();
        assertNull(carteira.getCorretora());
    }

    @Test
    void deveRetornarCorretora()
    {
        Corretora corretora = new Corretora();
        Carteira carteira = new CarteiraBolsa("Daniel", corretora);
        assertEquals("InvesteFacil", carteira.getDescricaoCorretora());
    }

    @Test
    void deveRetornarExcecaoCorretoraNull()
    {
        try
        {
            Carteira carteira = new CarteiraBolsa("Daniel", null);
            fail();
        } catch (CorretoraNuloException e)
        {
            assertEquals("Corretora valida deve ser informada", e.getMessage());
        }
    }

    @Test
    void deveComprarAcaoEmpresa()
    {
        Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);

        carteira.comprarInvestimento(empresa, 1);
        assertEquals(true, carteira.verificaExistenciaInvestimento(empresa));
        assertEquals(true, empresa.verificarExistenciaAcionista((Acionista) carteira.getCliente()));
    }

    @Test
    void deveComprarAcaoEmpresa2()
    {
        Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        Empresa empresa2 = new Empresa("Bradesco", 15.0d, 1.0d);


        carteira.comprarInvestimento(empresa, 1);
        carteira.comprarInvestimento(empresa2, 1);
        assertEquals(true, carteira.verificaExistenciaInvestimento(empresa));
        assertEquals(true, carteira.verificaExistenciaInvestimento(empresa2));
        assertEquals(true, empresa.verificarExistenciaAcionista((Acionista) carteira.getCliente()));
    }

    @Test
    void deveComprarCriptomoeda()
    {
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());

        Criptomoeda criptomoeda = new Criptomoeda();

        carteira.comprarInvestimento(criptomoeda, 1);
        assertEquals(true, carteira.verificaExistenciaInvestimento(criptomoeda));
    }

    @Test
    void deveComprarCriptomoeda2()
    {
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());

        Criptomoeda criptomoeda = new Criptomoeda();
        Criptomoeda criptomoeda2 = new Criptomoeda();

        carteira.comprarInvestimento(criptomoeda, 1);
        carteira.comprarInvestimento(criptomoeda2, 1);
        assertEquals(true, carteira.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(true, carteira.verificaExistenciaInvestimento(criptomoeda2));
    }

    @Test
    void deveVenderAcaoEmpresa()
    {
        Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        carteira.comprarInvestimento(empresa, 1);

        carteira.venderInvestimento(empresa, 1);
        assertEquals(false, carteira.verificaExistenciaInvestimento(empresa));
    }
    @Test
    void deveVenderAcaoEmpresa2()
    {
        Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());

        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);
        Empresa empresa2 = new Empresa("Microsoft", 400.0d, 3.0d);
        carteira.comprarInvestimento(empresa, 1);
        carteira.comprarInvestimento(empresa2, 1);

        carteira.venderInvestimento(empresa, 1);
        carteira.venderInvestimento(empresa2, 1);
        assertEquals(false, carteira.verificaExistenciaInvestimento(empresa));
        assertEquals(false, carteira.verificaExistenciaInvestimento(empresa2));
    }

    @Test
    void deveVenderCriptomoeda()
    {
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());

        Criptomoeda criptomoeda = new Criptomoeda();
        carteira.comprarInvestimento(criptomoeda, 1);

        carteira.venderInvestimento(criptomoeda, 1);
        assertEquals(false, carteira.verificaExistenciaInvestimento(criptomoeda));
    }
    @Test
    void deveVenderCriptomoeda2()
    {
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());
        Criptomoeda criptomoeda = new Criptomoeda();
        Criptomoeda criptomoeda2 = new Criptomoeda();
        carteira.comprarInvestimento(criptomoeda, 1);
        carteira.comprarInvestimento(criptomoeda2, 1);

        carteira.venderInvestimento(criptomoeda, 1);
        carteira.venderInvestimento(criptomoeda2, 1);
        assertEquals(false, carteira.verificaExistenciaInvestimento(criptomoeda));
        assertEquals(false, carteira.verificaExistenciaInvestimento(criptomoeda2));
    }

    @Test
    void deveRetornarClienteInativo()
    {
        Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());

        assertEquals("Inativo", carteira.getDescricaoStatus());
    }

    @Test
    void deveRetornarClienteAtivo()
    {
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());

        Criptomoeda criptomoeda = new Criptomoeda();

        carteira.comprarInvestimento(criptomoeda, 1);
        assertEquals("Ativo", carteira.getDescricaoStatus());
    }

}