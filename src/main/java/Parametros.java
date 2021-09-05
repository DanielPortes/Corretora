import lombok.Getter;

import java.util.List;

@Getter
public class Parametros
{
    private static String nomeCorretora = "CorretorasNames";
    private static double cotacaoDolar = 5.13d;
    private static double cotacaoBTC = 50000.0d;
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
