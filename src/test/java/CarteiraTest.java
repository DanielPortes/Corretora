import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteiraTest
{
    @Test
    void deveRetornarCliente()
    {
        Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraBolsa());
        Carteira carteira = cliente.getCarteira();

        assertEquals(carteira, cliente.getCarteira());
        assertEquals(cliente,carteira.getCliente());
    }
    @Test
    void deveRetornarClienteNuloCarteiraCripto()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraCriptomoeda());
            Carteira carteira = cliente.getCarteira();
            carteira.setCliente(null);
            assertNull(carteira.getCliente());
        } catch (IllegalArgumentException e)
        {
            assertEquals("Cliente valido deve ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarClienteNuloCarteiraBolsa()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora(), new CarteiraBolsa());
            Carteira carteira = cliente.getCarteira();
            carteira.setCliente(null);
            assertNull(carteira.getCliente());
        } catch (IllegalArgumentException e)
        {
            assertEquals("Cliente valido deve ser informado", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAtivosCriptoObrigatorios()
    {
        try
        {
            Cliente cliente = new Cliente("Daniel", new Corretora(),new CarteiraCriptomoeda());
            Carteira carteira = cliente.getCarteira();
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
            Cliente cliente = new Cliente("Daniel", new Corretora(),  new CarteiraBolsa());
            Carteira carteira = cliente.getCarteira();
            carteira.setInvestimentos(null);
            fail();
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Ativos obrigatorios");
        }
    }








}