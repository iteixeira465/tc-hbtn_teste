import java.time.*;
import java.util.*;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        setName(name);
        setSurname(surname);
        setBirthDate(birthDate);
        setAnotherCompanyOwner(anotherCompanyOwner);
        setPensioner(pensioner);
        setPublicServer(publicServer);
    }

    public String fullName() {
        return String.format("%s %s", getName(), getSurname());
    }

    public float calculateYearlySalary() {
        return getSalary() * 12;
    }

    public boolean isMEI() {
        return calculateYearlySalary() < 130000 && calculateAge(getBirthDate()) >= 18 && !isAnotherCompanyOwner() && !isPensioner() && !isPublicServer();
    }

    public static int calculateAge(Date bDate) {
        LocalDate date = bDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        if (date != null) {
            return Period.between(date, currentDate).getYears();
        } else {
            return 0;
        }
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }

    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public boolean isPublicServer() {
        return publicServer;
    }

    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
