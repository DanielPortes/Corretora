import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Compra extends Transacao
{
    private double precoUnit;

    public Compra(Investimento investimento, double precoUnit, int qtd, Carteira carteira)
    {
        super(investimento, qtd);
        this.precoUnit = precoUnit;
        carteira.creditarCompra(investimento, qtd);
    }

    public double valorTotalCompra()
    {
        return precoUnit * getQtdAcoes();
    }

}