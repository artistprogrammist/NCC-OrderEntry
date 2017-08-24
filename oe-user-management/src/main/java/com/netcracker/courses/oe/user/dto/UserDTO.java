package com.netcracker.courses.oe.user.dto;

import com.netcracker.courses.oe.user.entity.Gender;

import java.util.Objects;

public class UserDTO implements BaseEntityDTO {

    private long id;
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private long idRole;

    public UserDTO() {
    }

    public UserDTO(long id, String name, String surname, int age, Gender gender, long idRole) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.idRole = idRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id &&
                age == userDTO.age &&
                idRole == userDTO.idRole &&
                Objects.equals(name, userDTO.name) &&
                Objects.equals(surname, userDTO.surname) &&
                gender == userDTO.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, gender, idRole);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", idRole=").append(idRole);
        sb.append('}');
        return sb.toString();
    }
}
