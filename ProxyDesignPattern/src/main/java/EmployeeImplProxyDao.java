public class EmployeeImplProxyDao implements EmployeeDao{

    EmployeeDao employeeDaoObj;

    public EmployeeImplProxyDao() {
        this.employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo obj) {
        if(client.equals("ADMIN")){
            employeeDaoObj.create(client, obj);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) {
        if(client.equals("ADMIN") || client.equals("USER")){
            return employeeDaoObj.get(client, employeeId);
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public EmployeeDo remove(String client, int employeeId) {
        if(client.equals("ADMIN")){
            return employeeDaoObj.remove(client, employeeId);
        }
        throw new RuntimeException("Access Denied");
    }
}
