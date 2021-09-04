import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda extends Transacao
{
    private double precoUnit;

    public Venda(Empresa empresa, double precoUnit, int quantidadeAcoes)
    {
        super(empresa, quantidadeAcoes);
        this.precoUnit = precoUnit;
    }

    public double valorTotalVenda(int quantidadeAcoes)
    {
        return precoUnit * quantidadeAcoes;
    }

}