import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest
{
    @Test
    void deveRealizarVenda()
    {
        Corretora corretora = new Corretora();
        corretora.setNome("InvesteFacil");
        Empresa empresa = new Empresa("p",20,0.15,null);
        Cliente cliente = new Cliente("Daniel",corretora);
        corretora.cadastrarCliente(cliente);
        Venda venda = new Venda(empresa,13,2);
        assertEquals(26,venda.valorTotalVenda(venda.getQtdAcoes()));
    }
}