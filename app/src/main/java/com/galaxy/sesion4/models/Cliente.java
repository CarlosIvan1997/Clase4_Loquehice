package com.galaxy.sesion4.models;

/**
 * Created by Alumno on 1/10/2017.
 */

public class Cliente {

    public static final String TABLE_NAME = "cliente_table";
    public static final String ID_FIELD = "id";
    public static final String NAME_FIELD = "name";
    public static final String LASTNAME_FIELD = "lastname";
    public static final String ADDRESS_FIELD = "address";
    public static final String AGE_FIELD = "age";

    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private Integer age;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
