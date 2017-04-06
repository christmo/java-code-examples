package sql.hsqlldb.test;

import java.sql.*;

/**
 * Created by soporte on 4/6/17.
 */
public class DB {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement st	= null;
        String	   sql	= null;
        ResultSet rst1 = null;

        try {
            // Cargamos el controlador JDBC
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (Exception ex){
            System.err.println("Se pa producido un error al cargar el controlador JDBC");
            return;
        }

        // Nos conectamos a la base de datos creándola en caso de que no exista
        //conn = DriverManager.getConnection("jdbc:hsqldb:file:~/usuarios");
        conn = DriverManager.getConnection("jdbc:hsqldb:mem:usuarios","sa","");

        // Creamos la tabla sobre la que trabajaremos
        try {
            st  = conn.createStatement();
            sql = "CREATE TABLE empleados (codEmpleado INTEGER PRIMARY KEY, nombre VARCHAR(100), departamento VARCHAR(40))";
            st.executeUpdate(sql);
        } catch (Exception ex){
            // La tabla ya existía
        }

        //Borramos los empleados que existiesen en la tabla empleados
        st.executeUpdate("DELETE FROM empleados");

        // Añadimos varios empleados de prueba
        st.executeUpdate("INSERT INTO empleados (codEmpleado, nombre, departamento) VALUES (100000, 'Carlos Garcia',  'Desarrollo')");
        st.executeUpdate("INSERT INTO empleados (codEmpleado, nombre, departamento) VALUES (100001, 'Andrea Sanchez', 'Contabilidad')");
        st.executeUpdate("INSERT INTO empleados (codEmpleado, nombre, departamento) VALUES (100002, 'Gema Lopez',	  'Desarrollo')");

        // Realizamos una modificación de un empleado.
        st.executeUpdate("UPDATE empleados SET departamento='Contabilidad' WHERE codEmpleado=100002");

        // Mostramos por pantalla todos los empleados de la tabla
        rst1 = st.executeQuery("SELECT * FROM empleados");
        while (rst1.next()){
            System.out.println(rst1.getInt("codEmpleado") + " " + rst1.getString("nombre") + " " + rst1.getString("departamento") );
        }

        // Liberamos recursos
        rst1.close();

        // Enviamos el comando para que salve todos los datos temporales de forma permanente
        st = conn.createStatement();
        st.executeUpdate("SHUTDOWN");

        // Liberamos recursos y cerramos la conexión
        st.close();
        conn.close();
    }
}
