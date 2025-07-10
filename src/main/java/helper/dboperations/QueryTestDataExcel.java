package helper.dboperations;
import model.DataSheetType;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import utils.excelOperations.ExcelOperations;

import java.util.List;

public class QueryTestDataExcel {

    private final Logger log = LoggerFactory.getLogger(QueryTestDataExcel.class);
    SoftAssert softAssert = new SoftAssert();
    /*
     * Retrives the user
     */

    public User retrieveUserObj(User user) {
        if (user == null) {
            return null;
        }

        List<User> userList = new ExcelOperations<User>().get(DataSheetType.USERS);
        for (User curr : userList) {
            if (curr.getUserrole().equalsIgnoreCase(user.getUserrole()) &&
                    curr.getEnvironment().contains(user.getEnvironment())) {
                return curr;
            }
        }
        log.error("Record not found:retrieveUserObj");
        return null;
    }

}
