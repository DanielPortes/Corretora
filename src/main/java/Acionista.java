public interface Acionista
{
    /*
    MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
    DANIEL FAGUNDES PORTES FERNANDES 201965574C
    */

    boolean verificaExistenciaInvestimento(Investimento investimento);

    void comprarInvestimento(Investimento investimento, int qtd);

    void venderInvestimento(Investimento investimento, int qtd);

}