package sk.domain.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.domain.application.PeopleService;
import sk.domain.domain.entity.People;
import sk.domain.domain.repository.PeopleRepository;
import sk.domain.presentation.dto.res.PeopleDetailRes;
import sk.domain.presentation.dto.res.SearchRes;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    @Override
    public List<SearchRes> searchPeopleByName(String query) {
        List<SearchRes> result = new ArrayList<>();
        List<People> findPeoples = peopleRepository.findByNameContainingIgnoreCase(query);
        for (People people : findPeoples) {
            result.add(SearchRes.of(people));
        }

        return result;
    }

    @Override
    public List<PeopleDetailRes> getPeopleDetailsByName(String name) {
        List<PeopleDetailRes> result = new ArrayList<>();

        List<People> findPeoples = peopleRepository.findAllByName(name);

        for (People people : findPeoples) {
            result.add(PeopleDetailRes.of(people));
        }

        return result;


    }
}
