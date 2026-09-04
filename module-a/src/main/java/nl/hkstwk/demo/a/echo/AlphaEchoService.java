package nl.hkstwk.demo.a.echo;

public class AlphaEchoService implements EchoService {
    @Override
    public String echo() {
        return "Hello alpha";
    }
}
