package sk.domain.application;

import sk.domain.presentation.dto.res.PeopleDetailRes;
import sk.domain.presentation.dto.res.SearchRes;

import java.util.List;

public interface PeopleService {
    List<SearchRes> searchPeopleByName(String query);

    List<PeopleDetailRes> getPeopleDetailsByName(String name);
}
