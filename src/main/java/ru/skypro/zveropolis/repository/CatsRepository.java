package ru.skypro.zveropolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.zveropolis.model.Cat;

public interface CatsRepository extends JpaRepository <Cat, Long> {
}
