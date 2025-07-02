package sk.domain.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.domain.domain.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {

    // 이름에 특정 문자열이 포함된 사람들을 조회
    List<People> findByNameContainingIgnoreCase(String keyword);


    // 이름 2명 이상일 경우 있음
    List<People> findAllByName(String name);
}
