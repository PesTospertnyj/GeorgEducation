package chapter06.twotables;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(
        name = "customer_table",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")}
)
@SecondaryTables
        (
        {
                @SecondaryTable(name = "customer_address"),
                @SecondaryTable(name = "customer_details")
        }
)
//TODO try several columns in secondary table
public class Customer {
    @Id
    private int id;
    private String name;
    @Column(table = "customer_address")
    private String address;

    @Column(table = "customer_address")
    private String city;

    @Column(table = "customer_details")
    private Date birthdate;

    public Customer() {
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (!name.equals(customer.name)) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
