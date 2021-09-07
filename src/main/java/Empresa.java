import Exception.AcionistaNuloException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
        acionistas = new ArrayList<Acionista>();
    }

    public void cadastrarAcionista(Acionista acionista)
    {
        if (acionista == null)
        {
            throw new AcionistaNuloException("Acionista deve ser informado");
        }
        if (!verificarExistenciaAcionista(acionista))
        {
            this.acionistas.add(acionista);
        }
    }

    public boolean verificarExistenciaAcionista(Acionista acionista)
    {
        return getAcionistas().contains(acionista);
    }

}