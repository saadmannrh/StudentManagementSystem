public class student
{
    private String name;
    private int id;
    private String dept;
    private String address;

    public student(String name, int id,String dept, String address)
    {
        this.name = name;
        this.id = id;
        this.address = address;
        this.dept = dept;
    }

    public student()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDept()
    {
        return dept;
    }

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", dept='" + dept + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
