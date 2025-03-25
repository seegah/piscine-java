public class Context {
    private OperationStrategy operationStrategy;
    
    public Context() {
        this.operationStrategy = new AddStrategy();
    }

    public void changeSTrategy(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public int executeOperation(int a, int b) {
        return operationStrategy.execute(a, b);
    }
}