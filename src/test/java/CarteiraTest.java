import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteiraTest
{
    @Test
    void deveRetornarCliente()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora());
        Carteira carteira = new CarteiraBolsa();
        carteira.setCliente(cliente);

        assertEquals(carteira, cliente.getCarteira());
        assertEquals(cliente,carteira.getCliente());
    }
    @Test
    void deveRetornarClienteNulo()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora());
        Carteira carteira = new CarteiraCriptomoeda();
        assertNull(carteira.getCliente());
    }
    @Test
    void deveRetornarExcecaoAtivosCriptoObrigatorios()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora());
            Carteira carteira = new CarteiraCriptomoeda();
            carteira.setInvestimentos(null);
            fail();
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Ativos obrigatorios");
        }
    }

    @Test
    void deveRetornarExcecaoAtivosBolsaObrigatorios()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora());
            Carteira carteira = new CarteiraBolsa();
            carteira.setInvestimentos(null);
            fail();
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Ativos obrigatorios");
        }
    }





}