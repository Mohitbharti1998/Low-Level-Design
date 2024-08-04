public class EmployeeDo {
    String id;
    String department;
    String position;
    String payScale;

    public String getId() {
        return id;
    }

    public EmployeeDo setId(String id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeDo setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeDo setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getPayScale() {
        return payScale;
    }

    public EmployeeDo setPayScale(String payScale) {
        this.payScale = payScale;
        return this;
    }
}
