package my_spring;

public class CleanerPerformanceImpl extends CleanerImpl {

    @Override
    public void clean() {
        long before = System.nanoTime();
        super.clean();
        long after = System.nanoTime();
        System.out.println("Time spent in clean=" + (after-before));
    }
}
