package lab01.tdd;

public class MultOfStrategy implements SelectStrategy {
    private final int number;

    public MultOfStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return element%number == 0;
    }
}
