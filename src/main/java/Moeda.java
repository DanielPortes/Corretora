import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Moeda implements Investimento
{
    static double cotacao;
    String nome;


}
