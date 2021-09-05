import lombok.Getter;
import lombok.Setter;

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