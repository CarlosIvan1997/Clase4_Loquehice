package poclin.carlos.sesion4.models;

/**
 * Created by Alumno on 1/10/2017.
 */

public class Cliente {

    public static final String TABLE_NAME = "cliente";
    public static final String NAME_FIELD = "name";
    public static final String LASTNAME_FIELD = "lastname";
    public static final String ADDRESS_FIELD = "address";
    public static final String AGE_FIELD = "age";
    public static final String ID_FIELD = "id";

    private Integer id;
    private String name;
    private String lastname;
    private String address;
    private Integer age;

    public Cliente(){}

    public Cliente(String name, String lastname, String address, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
