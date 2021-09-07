import lombok.Getter;

import java.util.List;

@Getter
public class Parametros
{
    private static final String nomeCorretora = "InvesteFacil";
    private static final double cotacaoDolar = 5.13d;
    private static final double cotacaoBTC = 50000.0d;
    private static List<Empresa> empresas;

    public static double getCotacaoDolar()
    {
        return cotacaoDolar;
    }

    public static double getCotacaoBTC()
    {
        return cotacaoBTC;
    }

    public static double getCotacaoEmpresa(Investimento investimento)
    {
        return ((Empresa) investimento).getValorAcao();
    }

    public static String getNomeCorretora()
    {
        return nomeCorretora;
    }
}
