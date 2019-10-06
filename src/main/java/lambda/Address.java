package lambda;

import lombok.Getter;

public class Address {
    @Getter
    private String country;
    @Getter
    private String city;

    public Address(String country, String city) {
        this.city = city;
        this.country = country;
    }
}
