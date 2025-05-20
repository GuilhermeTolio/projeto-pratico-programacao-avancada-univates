package entity;

public class peopleEntity {

    public peopleEntity() {
    }

    public peopleEntity(int id, String name, String cpfCnpj, String telephone, String email, String type, String historic, boolean isVolunteer) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.telephone = telephone;
        this.email = email;
        this.type = type;
        this.historic = historic;
        this.isVolunteer = isVolunteer;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    public boolean isVolunteer() {
        return isVolunteer;
    }

    public void setVolunteer(boolean volunteer) {
        isVolunteer = volunteer;
    }

    private int id;
    private String name;
    private String cpfCnpj;
    private String telephone;
    private String email;
    private String type;
    private String historic;
    private boolean isVolunteer;

    public void printattributes(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(cpfCnpj);
        System.out.println(telephone);
        System.out.println(email);
        System.out.println(type);
        System.out.println(historic);
        System.out.println(isVolunteer);
    }
}
