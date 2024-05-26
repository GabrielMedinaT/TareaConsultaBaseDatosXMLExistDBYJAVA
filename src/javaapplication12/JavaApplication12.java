
package javaapplication12;


import javax.xml.xquery.*;
import net.xqj.exist.ExistXQDataSource;

public class JavaApplication12 {

    public static void main(String[] args) throws XQException {
        // Crear una fuente de datos para eXist
        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        
        // Establecer una conexión
        XQConnection conn = xqs.getConnection();
        
        // Preparar la expresión XQuery
        XQPreparedExpression xqpe = conn.prepareExpression(
            "/catalogo/obra[@fecha < 1850]/nombre"
        );

        // Ejecutar la consulta
        XQResultSequence rs = xqpe.executeQuery();
        
        // Imprimir los resultados
        while (rs.next()) {
            System.out.println(rs.getItemAsString(null));
        }
        
        // Cerrar la conexión
        conn.close();
    }
}

