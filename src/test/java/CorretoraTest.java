import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorretoraTest
{
    @Test
    void deveCriarCliente()
    {
        Corretora corretora = new Corretora();
        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);
        assertEquals("InvesteFacil", carteira.getDescricaoCorretora());
        assertEquals("Daniel", carteira.getNome());
        assertEquals(carteira, carteira.getCarteira());
        assertEquals(true, corretora.verificaExistenciaCarteira(carteira));
    }




    @Test
    void deveAdicionarCliente()
    {
        Corretora corretora = new Corretora();
        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);
//        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
//        corretora.cadastrarCliente(cliente);
        assertEquals(corretora, carteira.getCorretora());
        assertEquals(true, corretora.verificaExistenciaCarteira(carteira));
    }


    @Test
    void deveAdicionarCliente2()
    {
        Corretora corretora = new Corretora();

        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);
        Carteira carteira2 = new CarteiraCriptomoeda("Joao", corretora);

        assertEquals(corretora, carteira.getCorretora());
        assertEquals(corretora, carteira2.getCorretora());
        assertEquals(true, corretora.verificaExistenciaCarteira(carteira));
        assertEquals(true, corretora.verificaExistenciaCarteira(carteira2));
    }
//
    @Test
    void deveRemoverCliente()
    {
        Corretora corretora = new Corretora();
        Corretora corretora2 = new Corretora();
        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);

        corretora.cancelarRegistro(carteira);
        assertEquals(false, corretora.verificaExistenciaCarteira(carteira));
        assertNull(carteira.getCorretora());
    }

    @Test
    void deveRemoverCliente2()
    {
        Corretora corretora = new Corretora();

        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);
        Carteira carteira2 = new CarteiraCriptomoeda("Daniel", corretora);


        corretora.cancelarRegistro(carteira);
        corretora.cancelarRegistro(carteira2);
        assertEquals(null, carteira.getCorretora());
        assertEquals(null, carteira2.getCorretora());
        assertEquals(false, corretora.verificaExistenciaCarteira(carteira));
        assertEquals(false, corretora.verificaExistenciaCarteira(carteira2));
    }

    @Test
    void deveRetornarMontanteInvestidoDiferenteZero(){
        Corretora corretora = new Corretora();
        Carteira carteira = new CarteiraCriptomoeda("Daniel", corretora);

        Criptomoeda criptomoeda = new Criptomoeda("btc");

        carteira.comprarInvestimento(criptomoeda, 1);

        assertEquals(50000.0d,corretora.montanteInvestido());
    }

    @Test
    void deveRetornarMontanteInvestidoZerado(){
        Corretora corretora = new Corretora();

        assertEquals(0,corretora.montanteInvestido());
    }


}



