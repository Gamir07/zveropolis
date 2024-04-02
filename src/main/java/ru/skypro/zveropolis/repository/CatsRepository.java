package ru.skypro.zveropolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.zveropolis.model.Cats;

public interface CatsRepository extends JpaRepository <Cats, Long> {
}
