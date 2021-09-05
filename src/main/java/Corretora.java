import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Corretora
{
    private String nome;
    private List<Cliente> clientes;

    public Corretora()
    {
        this.clientes = new ArrayList<Cliente>();
        this.nome = Parametros.getNomeCorretora();
    }

    public double montanteInvestido()
    {
        double montante = 0.0d;
        for (Cliente cliente :
                clientes)
        {
            montante += cliente.getCarteira().getInvestimento();
        }
        return montante;
    }

    public void cadastrarCliente(Cliente cliente)
    {
        if (!this.clientes.contains(cliente))
        {
            this.clientes.add(cliente);
        }
        cliente.cadastrar(this);
    }

    public void cancelarRegistro(Cliente cliente)
    {
        this.clientes.remove(cliente);
        cliente.cancelarCadastro();
    }

    public boolean verificaExistenciaCliente(Cliente cliente)
    {
        return this.clientes.contains(cliente);
    }
}