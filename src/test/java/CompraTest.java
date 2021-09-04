import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompraTest
{
    @Test
    void deveRealizarCompra()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");
        Empresa empresa = new Empresa("p", 20, 0.15, null);
        Cliente cliente = new Cliente("Daniel", corretora);
        corretora.cadastrarCliente(cliente);
        Compra compra = new Compra(empresa, 13, 2, cliente.getCarteira());

        assertEquals(26, compra.valorTotalCompra());
    }

}