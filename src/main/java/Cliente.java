import Exception.CarteiraNuloException;
import Exception.CorretoraNuloException;
import Exception.InvestimentoNuloException;
import lombok.Data;

import java.util.List;

/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/
@Data
public class Cliente implements Pessoa, Acionista
{
    private String nome;
    private boolean status;
    private Carteira carteira;
    private Corretora corretora;

    public Cliente(String nome, Corretora corretora, Carteira carteira)
    {
        setCorretora(corretora);
        setCarteira(carteira);
        this.nome = nome;
        this.status = false;
    }

    public String getDescricaoCorretora()
    {
        return corretora.getNome();
    }

    public String getDescricaoStatus()
    {
        this.status = !(this.carteira.getInvestimentos().isEmpty());

        if (isStatus())
        {
            return "Ativo";
        }
        return "Inativo";
    }

    public void setCorretora(Corretora corretora)
    {
        if (corretora == null)
        {
            throw new CorretoraNuloException("Corretora valida deve ser informada");
        }
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
        if (investimento == null)
        {
            throw new InvestimentoNuloException("Investimento valido deve ser informado");
        }

        carteira.comprar(investimento, qtd);
    }

    @Override
    public void venderInvestimento(Investimento investimento, int qtd)
    {
        carteira.vender(investimento, qtd);
    }

    public void setNullCarteira()
    {
        this.carteira = null;
    }

    public void setCarteira(Carteira carteira)
    {
        if (carteira == null)
        {
            throw new CarteiraNuloException("Carteira valida deve ser informada");
        }

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