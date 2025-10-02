
public class Main {
    public static void main(String[] args) {
        Database db1 = DatabaseFactory.getDatabase("mysql");
        db1.connect();

        Database db2 = DatabaseFactory.getDatabase("postgresql");
        db2.connect();
    }
}
