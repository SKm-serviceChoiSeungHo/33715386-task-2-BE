package sk.domain.presentation.dto.res;

import sk.domain.domain.entity.People;

public record SearchRes(
        String name

) {
    public static SearchRes of(People person) {
        return new SearchRes(
                person.getName()

        );
    }
}