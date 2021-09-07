package Exception;

public class InvestimentoNuloException extends RuntimeException {

    public InvestimentoNuloException() {
        super();
    }

    public InvestimentoNuloException(String mensagem) {
        super(mensagem);
    }


    public InvestimentoNuloException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }


    public InvestimentoNuloException(Throwable causa) {
        super(causa);
    }

}
