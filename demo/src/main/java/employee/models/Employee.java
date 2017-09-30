package employee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yohoos on 5/5/17.
 */
@Entity
@XmlRootElement
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private boolean active;

    public Employee() {

    }

    public Employee(String name, String lastName, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
