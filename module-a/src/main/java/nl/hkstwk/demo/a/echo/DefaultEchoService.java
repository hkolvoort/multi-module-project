package nl.hkstwk.demo.a.echo;

public class DefaultEchoService implements EchoService {
    @Override
    public String echo() {
        return "Hello DefaultBean!";
    }
}
