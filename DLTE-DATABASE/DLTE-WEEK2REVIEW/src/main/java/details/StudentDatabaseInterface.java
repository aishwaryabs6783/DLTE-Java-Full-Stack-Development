package details;

import java.sql.SQLException;

public interface StudentDatabaseInterface {

    void displayData()throws SQLException;

    void insertDatabase(StudentDet student) throws SQLException;
}
