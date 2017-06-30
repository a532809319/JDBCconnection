package dto;

/**
 * Created by hukai on 2017/6/30.
 */
public class Address extends IdEntry {
    private String city;
    private  String country;
    private Long uer_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getUer_id() {
        return uer_id;
    }

    public void setUer_id(Long uer_id) {
        this.uer_id = uer_id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", uer_id=" + uer_id +
                '}';
    }
}
