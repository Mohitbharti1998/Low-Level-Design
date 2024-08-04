public interface EmployeeDao {
    void create(String client, EmployeeDo obj);
    EmployeeDo get(String client, int employeeId);
    EmployeeDo remove(String client, int employeeId);
}
