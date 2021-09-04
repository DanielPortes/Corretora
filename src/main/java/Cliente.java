import lombok.Data;

import java.util.List;

@Data

public class Cliente implements Pessoa, Acionista
{

    public double investimento;
    public boolean status;
    public Carteira carteira;
    public Corretora corretora;

    public Cliente(String nome, Corretora corretora)
    {
//        super(nome,null);
        cadastrar(corretora);
    }

    public List getInvestimentos()
    {
        return carteira.getInvestimentos();
    }
    public boolean retornaExistenciaInvestimento(Investimento investimento)
    {
        return carteira.getInvestimentos().contains(investimento);
    }


    public String getDescricaoCorretora()
    {
        return corretora.getNome();
    }

    public String getDescricaoStatus()
    {
        if (isStatus())
        {
            return "Ativo";
        }
        return "Inativo";
    }

    public void cadastrar(Corretora corretora)
    {
        if (this.corretora != corretora)
        {
            if (this.corretora != null)
            {
                this.corretora.cancelarRegistro(this);
            }
            this.corretora = corretora;
            if (this.corretora != null)
            {
                this.corretora.cadastrarCliente(this);
            }
        }
    }

    public void cancelarCadastro()
    {
        this.corretora = null;
    }

    @Override
    public boolean verificaExistenciaInvestimento(Investimento investimento)
    {
        return carteira.getInvestimentos().contains(investimento);
    }

    @Override
    public void comprarInvestimento(Investimento investimento, int qtd)
    {
        carteira.comprar(investimento, qtd);
    }

    public void setNullCarteira()
    {
        this.carteira = null;
    }

    public void setCarteira(Carteira carteira)
    {
        if (this.carteira != carteira)
        {
            if (this.carteira != null)
            {
                this.carteira.setNullCliente();
            }
            this.carteira = carteira;
            if (this.carteira != null && this.carteira.getCliente() != this)
            {
                this.carteira.setCliente(this);
            }
        }
    }

}