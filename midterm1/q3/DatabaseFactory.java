public class DatabaseFactory {
    public static Database getDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql": return new MySqlDatabase();
            case "postgresql": return new PostgresDatabase();
            default: return null;
        }
    }
}

