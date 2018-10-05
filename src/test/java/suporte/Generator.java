package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String dataHoraAtual () {
        Timestamp time = new Timestamp(System.currentTimeMillis());  //método System.currentTimeMillis retorna a hora atual em milissegundos
        return new SimpleDateFormat("yyyyMMddhhmmss").format(time); //formatar data
    }
}
