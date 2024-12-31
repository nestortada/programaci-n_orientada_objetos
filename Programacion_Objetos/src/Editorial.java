public class Editorial {
    private String name;
    private  String city;
    private String address;
    private int phone;

    public Editorial() {

    }

    public Editorial(String name) {
        this.name = name;
    }

    public Editorial(String name, String city, String address, int phone) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return "hola";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
