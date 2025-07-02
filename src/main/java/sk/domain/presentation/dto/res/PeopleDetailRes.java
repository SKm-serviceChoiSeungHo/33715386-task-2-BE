package sk.domain.presentation.dto.res;

import sk.domain.domain.entity.People;

public record PeopleDetailRes(

        String name,
        String gender,
        String age,
        String country
) {
    public static PeopleDetailRes of(People person) {
        return new PeopleDetailRes(
                person.getName(),
                person.getGender(),
                person.getAge(),
                person.getCountry()
        );
    }
}