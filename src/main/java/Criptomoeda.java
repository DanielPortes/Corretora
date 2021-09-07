import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criptomoeda implements Investimento
{
    static double cotacao;
    String nome;

    public Criptomoeda()
    {
        this.nome = "BTC";
        cotacao = Parametros.getCotacaoBTC();
    }
    public double getPreco(){
        return this.cotacao;
    }
}
