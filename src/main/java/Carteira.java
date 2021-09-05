import java.util.List;
/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/
public interface Carteira
{
    double comprar(Investimento investimento, int qtd);

    double vender(Investimento investimento, int qtd);

    Cliente getCliente();

    void setCliente(Cliente cliente);

    void setNullCliente();

    void creditarCompra(Investimento investimento, int qtd);

    List getInvestimentos();

    void setInvestimentos(List<Investimento> investimentos);

    void creditarVenda(Investimento investimento, int qtd);

    boolean verificaExistenciaInvestimento(Investimento investimento);

    double getInvestimento();


}
