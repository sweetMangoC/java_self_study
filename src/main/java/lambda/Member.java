package lambda;


import lombok.Data;
import lombok.Getter;

public class Member {
    @Getter
    private String name;

    @Getter
    private Integer age;

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
