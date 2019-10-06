package lambda;


import lombok.Getter;

public class Member {
    @Getter
    private String name;

    @Getter
    private Integer age;

    @Getter
    private Address address;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Member(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
