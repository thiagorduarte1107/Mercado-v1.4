package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final DecimalFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String dateParaString(java.util.Date data) {
        return sdf.format(data);
    }

    public static String doubleParaString(Double valor) {
        return nf.format(valor);
    }

    public static void pausar(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            System.out.println("Erro ao pausar: " + e.getMessage());
        }
    }

    public static class DatabaseConnection {
        private static final String URL = "jdbc:sqlite:C:/Users/LAB-BABY/Desktop/Dev/Mercado/Mercado-v1.2/mercado.db";

        public static Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL);
                System.out.println("Conexão com SQLite estabelecida.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }
    }
}
