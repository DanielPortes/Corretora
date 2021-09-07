import lombok.Getter;

import java.util.List;

@Getter
public class Parametros
{
    private static final String nomeCorretora = "InvesteFacil";
    private static final double cotacaoBTC = 50000.0d;

    public static double getCotacaoBTC()
    {
        return cotacaoBTC;
    }

    public static String getNomeCorretora()
    {
        return nomeCorretora;
    }
}
