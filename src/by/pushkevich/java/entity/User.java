package entity;

import role.FamilyStatus;
import role.WorkStatus;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private WorkStatus workStatus;
    private FamilyStatus familyStatus;
    private Set<Long> phoneNumbers;

    public User(int id, String firstName, String lastName, String email, WorkStatus workStatus, FamilyStatus familyStatus, Set<Long> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.workStatus = workStatus;
        this.familyStatus = familyStatus;
        this.phoneNumbers = phoneNumbers;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }

    public Set<Long> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addPhoneNumber(Long number){
        phoneNumbers.add(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id " + id +
                " имя " + firstName +
                " фамилия " + lastName +
                " email " + email +
                " занятость " + workStatus +
                " семейное положение " + familyStatus +
                " номера: " + phoneNumbers;
    }
}
