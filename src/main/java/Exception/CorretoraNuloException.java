package Exception;

public class CorretoraNuloException extends RuntimeException
{

    public CorretoraNuloException()
    {
        super();
    }

    public CorretoraNuloException(String mensagem)
    {
        super(mensagem);
    }

    public CorretoraNuloException(String mensagem, Throwable causa)
    {
        super(mensagem, causa);
    }

    public CorretoraNuloException(Throwable causa)
    {
        super(causa);
    }

}
