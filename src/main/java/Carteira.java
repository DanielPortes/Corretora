import java.util.List;

public interface Carteira
{
    double calcularLucro();

    double comprar(Investimento investimento, int qtd);

    double vender();

    Cliente getCliente();

    void setCliente(Cliente cliente);

    void setNullCliente();

    void creditarCompra(Investimento investimento, int qtd);

    List getInvestimentos();

    void setInvestimentos(List<Investimento> investimentos);

}
