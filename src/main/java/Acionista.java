public interface Acionista
{
    boolean verificaExistenciaInvestimento(Investimento investimento);

    void comprarInvestimento(Investimento investimento, int qtd);

}