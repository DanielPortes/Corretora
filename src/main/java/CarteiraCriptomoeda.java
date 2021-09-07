import lombok.Data;
import Exception.CarteiraNuloException;
import Exception.CorretoraNuloException;
import Exception.InvestimentoNuloException;
import java.util.ArrayList;
import java.util.List;

/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/

@Data
public class CarteiraCriptomoeda implements Carteira
{
    private Cliente cliente;
    private List<Criptomoeda> criptomoedas;
    private double investimento;


    public CarteiraCriptomoeda(String nomeCliente, Corretora corretora)
    {
        this.cliente = new Cliente(nomeCliente, corretora);
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
            throw new InvestimentoNuloException("Investimento valido deve ser informado");
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

    @Override
    public void setCliente(Pessoa cliente)
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
            this.cliente = (Cliente) cliente;
            if (this.cliente != null && this.cliente.getCarteira() != this)
            {
                this.cliente.setCarteira(this);
            }
        }
    }

    public void setCorretora(Corretora corretora)
    {
        if (this.cliente != null)
        {
            this.cliente.setCorretora(corretora);
        }
    }

    public void cancelarCadastro()
    {
        if (this.cliente != null)
        {
            this.cliente.corretora = null;
        }
    }

    public String getDescricaoCorretora()
    {
        return cliente.getDescricaoCorretora();
    }

    @Override
    public String getNome()
    {
        return cliente.getNome();
    }

    @Override
    public Carteira getCarteira()
    {
        return cliente.getCarteira();
    }
    @Override
    public Corretora getCorretora()
    {
        return cliente.getCorretora();
    }
    public Carteira auxSetCarteira()
    {
        return this;
    }
    public void comprarInvestimento(Investimento investimento,int qtd)
    {
        cliente.comprarInvestimento(investimento,qtd);
    }
    public void venderInvestimento(Investimento investimento, int qtd)
    {
        this.cliente.venderInvestimento(investimento, qtd);
    }
    public String getDescricaoStatus()
    {
        return this.cliente.getDescricaoStatus();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Data
    private class Cliente implements Pessoa, Acionista
    {
        private String nome;
        private boolean status;
        private Carteira carteira;
        private Corretora corretora;

        public Cliente(String nome, Corretora corretora)
        {
            setCarteira(auxSetCarteira());
            setCorretora(corretora);
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
                    this.corretora.cancelarRegistro(carteira);
                }
                this.corretora = corretora;
                if (this.corretora != null)
                {
                    this.corretora.cadastrarCliente(carteira);
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
}
