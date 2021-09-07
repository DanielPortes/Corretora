import lombok.Getter;
import lombok.Setter;

/*
MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
DANIEL FAGUNDES PORTES FERNANDES 201965574C
*/
@Getter
@Setter
public class Venda extends Transacao
{
    private double precoUnit;

    public Venda(Investimento investimento, double precoUnit, int qtd, Carteira carteira)
    {
        super(investimento, qtd);
        this.precoUnit = precoUnit;
        carteira.creditarVenda(investimento, qtd);
    }

    public double valorTotalVenda()
    {
        return precoUnit * getQtdAcoes();
    }

}