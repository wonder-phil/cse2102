public class PostgresDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL Database.");
    }
}
