import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorretoraTest
{
    @Test
    void deveAdicionarCliente()
    {
        Corretora corretora = new Corretora();

        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
        corretora.cadastrarCliente(cliente);
        assertEquals(corretora, cliente.getCorretora());
        assertEquals(true, corretora.verificaExistenciaCliente(cliente));
    }
    @Test
    void deveAdicionarCliente2()
    {
        Corretora corretora = new Corretora();

        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
        Cliente cliente2 = new Cliente("Joao",corretora, new CarteiraCriptomoeda());
        corretora.cadastrarCliente(cliente);

        assertEquals(corretora, cliente.getCorretora());
        assertEquals(true, corretora.verificaExistenciaCliente(cliente));
        assertEquals(true, corretora.verificaExistenciaCliente(cliente2));
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
    void deveRemoverCliente2()
    {
        Corretora corretora = new Corretora();

        Cliente cliente = new Cliente("Daniel",corretora, new CarteiraCriptomoeda());
        Cliente cliente2 = new Cliente("Joao",corretora, new CarteiraCriptomoeda());
        corretora.cadastrarCliente(cliente);
        corretora.cadastrarCliente(cliente2);

        corretora.cancelarRegistro(cliente);
        corretora.cancelarRegistro(cliente2);
        assertEquals(null, cliente.getCorretora());
        assertEquals(null, cliente2.getCorretora());
        assertEquals(false, corretora.verificaExistenciaCliente(cliente));
        assertEquals(false, corretora.verificaExistenciaCliente(cliente2));
    }

    @Test
    void deveRetornarMontanteInvestidoDiferenteZero(){
        Carteira carteira = new CarteiraBolsa();
        Corretora corretora = new Corretora();
        Cliente cliente = new Cliente("Daniel", corretora, carteira);
        Empresa empresa = new Empresa("Bradesco", 15.0d, 1.0d);

        cliente.comprarInvestimento(empresa, 1);

        assertEquals(15,corretora.montanteInvestido());
    }

    @Test
    void deveRetornarMontanteInvestidoZerado(){
        Corretora corretora = new Corretora();

        assertEquals(0,corretora.montanteInvestido());
    }


}



