import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarteiraCriptomoeda implements Carteira
{
    private Cliente cliente;
    private List<Criptomoeda> criptomoedas;
    private double investimento;

    public CarteiraCriptomoeda()
    {
        criptomoedas = new ArrayList<Criptomoeda>();
    }

    @Override
    public List getInvestimentos()
    {
        return criptomoedas;
    }


    @Override
    public void setInvestimentos(List investimentos)
    {
        if (investimentos == null)
        {
            throw new IllegalArgumentException("Ativos obrigatorios");
        }
        this.criptomoedas = investimentos;
    }

    @Override
    public double comprar(Investimento investimento, int qtd)
    {
        Compra compra = new Compra(investimento, Parametros.getCotacaoBTC(), qtd, this);
        return compra.valorTotalCompra();
    }

    @Override
    public double vender(Investimento investimento, int qtd)
    {
        Venda venda = new Venda(investimento, Parametros.getCotacaoBTC(), qtd, this);
        return venda.valorTotalVenda();
    }

    @Override
    public void setCliente(Cliente cliente)
    {
        if(cliente == null){
            throw new IllegalArgumentException("Cliente valido deve ser informado");
        }

        if (this.cliente != cliente)
        {
            if (this.cliente != null)
            {
                this.cliente.setNullCarteira();
            }
            this.cliente = cliente;
            if (this.cliente != null && this.cliente.getCarteira() != this)
            {
                this.cliente.setCarteira(this);
            }
        }
    }

    public void setNullCliente()
    {
        this.cliente = null;
    }

    public void creditarCompra(Investimento investimento, int qtd)
    {
        if (!verificaExistenciaInvestimento(investimento))
        {
            criptomoedas.add(((Criptomoeda) investimento));
        }
        this.investimento += (Parametros.getCotacaoBTC() * qtd);
    }

    public void creditarVenda(Investimento investimento, int qtd)
    {
        if (verificaExistenciaInvestimento(investimento))
        {
            criptomoedas.remove(((Criptomoeda) investimento));
        }
        this.investimento -= (Parametros.getCotacaoBTC() * qtd);
    }


    @Override
    public boolean verificaExistenciaInvestimento(Investimento investimento)
    {
        return getInvestimentos().contains(investimento);
    }
}
