package nl.hkstwk.demo.a.echo;

public class BetaEchoService implements EchoService {
    @Override
    public String echo() {
        return "Hello beta";
    }
}
