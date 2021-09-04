import lombok.Data;

import java.util.List;

@Data
public class CarteiraCriptomoeda implements Carteira
{
    public String codigo;
    public Cliente cliente;
    public List<Moeda> moedas;
    public double valorInvestido;

    @Override
    public List getInvestimentos()
    {
        return moedas;
    }
    @Override
    public void setInvestimentos(List investimentos){
        if(investimentos == null){
            throw new IllegalArgumentException("Ativos obrigatorios");
        }
        this.moedas = investimentos;
    }

    @Override
    public double calcularLucro()
    {
        return 0;
    }

    @Override
    public double comprar(Investimento investimento, int qtd)
    {
        Compra compra = new Compra(investimento, Parametros.getCotacaoBTC(), qtd,this);
        return compra.valorTotalCompra();
    }

    @Override
    public double vender()
    {
        return 0;
    }

    @Override
    public void setCliente(Cliente cliente)
    {
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
        if (!moedas.contains((Moeda) investimento))
        {
            moedas.add(((Moeda) investimento));
        }
    }



}
