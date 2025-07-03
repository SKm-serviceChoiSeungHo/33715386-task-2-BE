package sk.domain.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.domain.application.PeopleService;
import sk.domain.presentation.dto.res.PeopleDetailRes;
import sk.domain.presentation.dto.res.SearchRes;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor

public class PeopleController {

    private final PeopleService peopleService;

    // 이름 검색 실시간
    @GetMapping("/search")
    public ResponseEntity<List<SearchRes>> searchPeople(@RequestParam("query") String query) {
        return ResponseEntity.ok(peopleService.searchPeopleByName(query));
    }


    // 이름 상세 정보
    @GetMapping("/detail")
    public ResponseEntity<List<PeopleDetailRes>> getPeopleDetails(@RequestParam("name") String name) {
        return ResponseEntity.ok(peopleService.getPeopleDetailsByName(name));
    }
}