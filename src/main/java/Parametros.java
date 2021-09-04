import lombok.Data;

import java.util.List;

@Data
public class Parametros
{
    private static double cotacaoDolar = 5.13;
    private static double cotacaoBTC = 50000;
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

}
