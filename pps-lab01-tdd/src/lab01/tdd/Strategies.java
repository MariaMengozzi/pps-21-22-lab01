package lab01.tdd;

public class Strategies implements AbstractFactory {

    @Override
    public SelectStrategy getStrategy(StrategyTypes strategyType, Integer number) {
        switch (strategyType){
            case EVEN_STRATEGY:
                return new EvenStrategy();
            case MULTIPLE_OF_STRATEGY:
                return new MultipleOfStrategy(number);
            case EQUAL_STRATEGY:
                return new EqualsStrategy(number);
            default:
                return null;
        }
    }
}
