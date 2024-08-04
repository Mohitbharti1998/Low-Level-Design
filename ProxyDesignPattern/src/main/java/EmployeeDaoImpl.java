public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create(String client, EmployeeDo obj) {
        System.out.println("Created new row in Employee Table");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) {
        System.out.println("fetching data from Employee Table");
        return new EmployeeDo();
    }

    @Override
    public EmployeeDo remove(String client, int employeeId) {
        System.out.println("deleted data from Employee Table");
        return new EmployeeDo();
    }
}
