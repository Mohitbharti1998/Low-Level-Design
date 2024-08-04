public class ProxyDesignPattern {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeImplProxyDao();
        try {
            employeeDao.create("USER", new EmployeeDo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
