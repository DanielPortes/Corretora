
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
    /*
    MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
    DANIEL FAGUNDES PORTES FERNANDES 201965574C
    */

@Data
@AllArgsConstructor
public class Corretora
{
    private String nome;
    private List<Carteira> carteiras;

    public Corretora()
    {
        this.carteiras = new ArrayList<Carteira>();
        this.nome = Parametros.getNomeCorretora();
    }

    public double montanteInvestido()
    {
        double montante = 0.0d;
        for (Carteira carteira :
                carteiras)
        {
            montante += carteira.getInvestimento();
        }
        return montante;
    }

    public void cadastrarCliente(Carteira carteira)
    {
        if (!this.carteiras.contains(carteira))
        {
            this.carteiras.add(carteira);
        }
        if (carteira != null)
        {
            carteira.setCorretora(this);
        }
    }

    public void cancelarRegistro(Carteira carteira)
    {
        this.carteiras.remove(carteira);
        carteira.cancelarCadastro();
    }

    public boolean verificaExistenciaCarteira(Carteira carteira)
    {
        return this.carteiras.contains(carteira);
    }
}

    /*
    MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
    DANIEL FAGUNDES PORTES FERNANDES 201965574C
    */