public class MySqlDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL Database.");
    }
}
