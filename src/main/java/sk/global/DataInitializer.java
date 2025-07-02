package sk.global;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sk.domain.domain.entity.People;
import sk.domain.domain.repository.PeopleRepository;

import java.util.UUID;
import java.util.stream.IntStream;

//@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final PeopleRepository peopleRepository;

    @PostConstruct
    public void initializeMembers() {
        if (peopleRepository.count() > 0) return;

        IntStream.range(1, 10001).forEach(i -> {
            People person = People.builder()
                    .id(UUID.randomUUID().toString())
                    .name("이름" + i)
                    .gender(i % 2 == 0 ? "남" : "여")
                    .age(String.valueOf(20 + (i % 30)))  // 20 ~ 49세
                    .country(i % 2 == 0 ? "대한민국" : "일본")
                    .build();

            peopleRepository.save(person);
        });

    }

}
