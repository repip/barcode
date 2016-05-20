/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barcodemag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * comd sql su database
 *
 *
 * @author amm4
 */
public class MySqlAccess {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public MySqlAccess() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://192.168.0.12/DB?"
                            + "user=user&password=passw");
            statement = connect.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CampiDB leggiSigillo(String id) throws SQLException {
        String qta = "";
        CampiDB campi = new CampiDB();
        resultSet = statement
                .executeQuery("select * from SigilliLt where ID=" + id);
        while (resultSet.next()) {
            campi.setId(resultSet.getInt("ID"));
            campi.setQta(resultSet.getInt("QTA"));
            campi.setCod(resultSet.getString("COD"));
            campi.setDes(resultSet.getString("DES"));
            campi.setLotto(resultSet.getString("lotto"));
        }
        return campi;
    }

    public String creaSigillo(String id, int qta) throws SQLException {
        CampiDB campi = new CampiDB();
        campi = cscDecode(id);
        System.out.println(campi.getCod() + " " + campi.getDes() + " " + campi.getLotto());

        return "";

    }

    private CampiDB cscDecode(String id) throws SQLException {
        CampiDB campi = new CampiDB();
        if ("P".equals(id.substring(0, 1))) {
            id = id.substring(1);
            resultSet = statement
                    .executeQuery("SELECT REP, ORDINE, lotto, DATA, COD, DES FROM VERSPRD WHERE ID=" + id);
            while (resultSet.next()) {
                campi.setCod(resultSet.getString("COD"));
                campi.setDes(resultSet.getString("DES"));
                campi.setLotto(resultSet.getString("lotto"));
            }
            if (resultSet.first() == true) {
                campi.setCk(true);
            }
        } else {
            resultSet = statement
                    .executeQuery("SELECT CDCFY9, ORDIY9, CDLTY9, DTARY9, CDARY9, DSARY9 FROM YYCSC99F WHERE NRSEY9=" + id);
            while (resultSet.next()) {
                campi.setCod(resultSet.getString("CDARY9"));
                campi.setDes(resultSet.getString("DSARY9"));
                campi.setLotto(resultSet.getString("CDLTY9"));
            }
            if (resultSet.first() == true) {
                campi.setCk(true);
            } else {
                resultSet = statement
                        .executeQuery("SELECT ID, REP, ORDINE, lotto, DATA, COD, DES FROM VERSPRD WHERE ORDINE='" + id + "'");
                while (resultSet.next()) {
                    campi.setCod(resultSet.getString("COD"));
                    campi.setDes(resultSet.getString("DES"));
                    campi.setLotto(resultSet.getString("lotto"));
                }

            }

        }
        return campi;
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
