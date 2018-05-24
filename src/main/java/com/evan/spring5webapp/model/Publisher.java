package com.evan.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Publisher {
    private String name;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id == publisher.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Publisher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
