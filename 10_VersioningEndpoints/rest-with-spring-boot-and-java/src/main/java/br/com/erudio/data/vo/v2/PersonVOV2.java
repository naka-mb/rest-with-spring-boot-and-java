package br.com.erudio.data.vo.v2;

import java.io.Serializable;
import java.util.Date;

public class PersonVOV2 implements Serializable {

    private static final long sefialVesionUID = 1L;

    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    private Date birthDay;


    private Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    public PersonVOV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVOV2 personVO2)) return false;

        if (getId() != null ? !getId().equals(personVO2.getId()) : personVO2.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(personVO2.getFirstName()) : personVO2.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(personVO2.getLastName()) : personVO2.getLastName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(personVO2.getAddress()) : personVO2.getAddress() != null)
            return false;
        if (getGender() != null ? !getGender().equals(personVO2.getGender()) : personVO2.getGender() != null)
            return false;
        return getBirthDay() != null ? getBirthDay().equals(personVO2.getBirthDay()) : personVO2.getBirthDay() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getBirthDay() != null ? getBirthDay().hashCode() : 0);
        return result;
    }
}
