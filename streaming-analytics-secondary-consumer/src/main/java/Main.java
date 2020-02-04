import db.CassandraRepository;

public class Main {
    public static void main(String[] args) {
        CassandraRepository cr = new CassandraRepository();
        cr.initialize("127.0.0.1", null);
        cr.close();
    }
}
