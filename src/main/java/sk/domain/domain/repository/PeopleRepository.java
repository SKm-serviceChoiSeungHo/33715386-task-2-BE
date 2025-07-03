package sk.domain.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.domain.domain.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {

    // 이름 포함 상위 20명 검색
    List<People> findTop20ByNameContainingIgnoreCase(String keyword);

    // 이름 2명 이상일 경우 있음
    List<People> findAllByName(String name);
}
