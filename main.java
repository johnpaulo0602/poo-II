// Singleton
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Simulando instancia única
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Conexao com banco de dados!");
    }
}

// Factory
public interface Connection {
    void connect();
}

public class MySqlConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("Conexao com MySQL");
    }
}

public class PostgresConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("Conexao com PostgreSQL");
    }
}

public class ConnectionFactory {
    public static Connection createConnection(String type) {
        if (type.equalsIgnoreCase("MySQL")) {
            return new MySqlConnection();
        } else if (type.equalsIgnoreCase("Postgres")) {
            return new PostgresConnection();
        } else {
            throw new IllegalArgumentException("Tipo de conexão desconhecido");
        }
    }
}

// Classe Principal
public class Main {
    public static void main(String[] args) {
        // Singleton
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.connect();

        // Factory
        Connection mySqlConnection = ConnectionFactory.createConnection("MySQL");
        mySqlConnection.connect();

        Connection postgresConnection = ConnectionFactory.createConnection("Postgres");
        postgresConnection.connect();
    }
}
