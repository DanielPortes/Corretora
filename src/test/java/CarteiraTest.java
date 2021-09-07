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
        Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());

        assertEquals(carteira, carteira.getCarteira());
        assertEquals("Daniel",carteira.getNome());
    }

    @Test
    void deveRetornarClienteNuloCarteiraCripto()
    {
        try
        {
            Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());
            carteira.setCliente(null);
            carteira.getCliente();
            fail();
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
            Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());
            carteira.setCliente(null);
            carteira.getCliente();
            fail();
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
            Carteira carteira = new CarteiraCriptomoeda("Daniel", new Corretora());
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
            Carteira carteira = new CarteiraBolsa("Daniel", new Corretora());
            carteira.setInvestimentos(null);
            fail();
        } catch (InvestimentoNuloException e)
        {
            assertEquals(e.getMessage(), "Investimento valido deve ser informado");
        }
    }

}