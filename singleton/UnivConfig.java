package Patterns.Singleton;

public class UnivConfig {
    protected String name = "UConn Stamford";
    protected String[] CSEProfessors = {"Albert E", "Galileo", "Alan T", "I Newton"};
    private UnivConfig() {}
    private static UnivConfig Instance = new UnivConfig();
    public static UnivConfig getUnivConfig() {
        return Instance;
    }
}
