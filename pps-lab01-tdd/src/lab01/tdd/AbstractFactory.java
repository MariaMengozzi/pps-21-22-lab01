package lab01.tdd;

public abstract interface AbstractFactory {
    /**abstract method to get the selected strategy
     * @param strategyType type of strategy choosen
     * @param number reference number
     * */
    public abstract SelectStrategy getStrategy(StrategyTypes strategyType, Integer number);
}
