package ar.com.ada.spring.demo.model.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DogDTO {

    private long id;
    private String breed;
    private String sex;

    public DogDTO(long id, String breed, String sex) {
        this.id = id;
        this.breed = breed;
        this.sex = sex;
    }

    public DogDTO(String breed, String sex) {
        this.breed = breed;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
