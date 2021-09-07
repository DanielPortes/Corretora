import org.junit.jupiter.api.Test;
import Exception.InvestimentoNuloException;

import static org.junit.jupiter.api.Assertions.*;
/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/
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
        } catch (InvestimentoNuloException e)
        {
            assertEquals(e.getMessage(), "Investimento valido deve ser informado");
        }
    }

    @Test
    void deveRetornarExcecaoAtivosBolsaObrigatorios()
    {
        try
        {
            Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());
            carteira.setInvestimentos(null);

            fail();
        } catch (InvestimentoNuloException e)
        {
            assertEquals(e.getMessage(), "Investimento valido deve ser informado");
        }
    }








}