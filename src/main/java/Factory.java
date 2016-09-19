import model.EmployeeDao;

public class Factory {

    private static EmployeeDao employeeDao;

    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }


    public static EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public static void setEmployeeDao(EmployeeDao employeeDao) {
        Factory.employeeDao = employeeDao;
    }
}
