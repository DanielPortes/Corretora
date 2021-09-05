
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class CarteiraBolsa implements Carteira
{
    public Cliente cliente;
    public List<Empresa> empresas;
    public double investimento;
    public CarteiraBolsa()
    {
        empresas = new ArrayList<Empresa>();
    }

    public CarteiraBolsa(Cliente cliente)
    {
        this.cliente = cliente;
        empresas = new ArrayList<Empresa>();
        this.investimento = 0.0d;
    }

    @Override
    public List getInvestimentos()
    {
        return empresas;
    }

    @Override
    public double comprar(Investimento investimento, int qtd)
    {
        Compra compra = new Compra(investimento, Parametros.getCotacaoEmpresa(investimento), qtd, this);
        ((Empresa) investimento).cadastrarAcionista(this.cliente);

        return compra.valorTotalCompra();
    }

    @Override
    public double vender(Investimento investimento, int qtd)
    {
        Venda venda = new Venda(investimento, Parametros.getCotacaoEmpresa(investimento), qtd, this);
        return venda.valorTotalVenda();
    }

    @Override
    public void setCliente(Cliente cliente)
    {
        if (cliente == null)
        {
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

    @Override
    public void setInvestimentos(List investimentos)
    {
        if (investimentos == null)
        {
            throw new IllegalArgumentException("Ativos obrigatorios");
        }
        this.empresas = investimentos;
    }

    @Override
    public void creditarCompra(Investimento investimento, int qtd)
    {
        if (!empresas.contains((Empresa) investimento))
        {
            empresas.add(((Empresa) investimento));
        }
        this.investimento += (Parametros.getCotacaoEmpresa(investimento) * qtd);
    }


    public void creditarVenda(Investimento investimento, int qtd)
    {
        if (cliente.verificaExistenciaInvestimento(investimento))
        {
            empresas.remove(((Empresa) investimento));
        }
        this.investimento -= (Parametros.getCotacaoEmpresa(investimento) * qtd);
    }

    @Override
    public boolean verificaExistenciaInvestimento(Investimento investimento)
    {
        return getInvestimentos().contains(investimento);
    }


}