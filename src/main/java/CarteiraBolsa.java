import lombok.Data;

import java.util.List;

@Data
public class CarteiraBolsa implements Carteira
{

    public String codigo;
    public Cliente cliente;
    public List<Empresa> empresas;
    public double investimento;

    public CarteiraBolsa()
    {
    }

    @Override
    public List getInvestimentos()
    {
        return empresas;
    }

    @Override
    public void setInvestimentos(List investimentos){
        if(investimentos == null){
            throw new IllegalArgumentException("Ativos obrigatorios");
        }
        this.empresas = investimentos;
    }

    @Override
    public double calcularLucro()
    {
        return 0;
    }

    @Override
    public double comprar(Investimento investimento, int qtd)
    {
        Compra compra = new Compra(investimento, Parametros.getCotacaoEmpresa(investimento), qtd, this);
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

    @Override
    public void creditarCompra(Investimento investimento, int qtd)
    {
        if (!empresas.contains((Empresa) investimento))
        {
            empresas.add(((Empresa) investimento));
        }
    }

}