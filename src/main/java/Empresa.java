import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class Empresa implements Investimento
{
    public String nome;
    public double valorAcao;
    public double lucroDividendo;
    public List<Acionista> acionistas;

    public Empresa(String nome, double valorAcao, double lucroDividendo)
    {
        this.nome = nome;
        this.valorAcao = valorAcao;
        this.lucroDividendo = lucroDividendo;
    }

    public void cadastrarAcionista(Acionista acionista, int qtd)
    {
        if (acionista == null)
        {
            throw new NullPointerException("Acionista deve ser informado");
        }
        if (!this.acionistas.contains(acionista))
        {
            this.acionistas.add(acionista);
        }
        if (!acionista.verificaExistenciaInvestimento(null))
        {
            acionista.comprarInvestimento(this, qtd);
        }
    }

}