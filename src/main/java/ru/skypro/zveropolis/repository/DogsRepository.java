package ru.skypro.zveropolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.zveropolis.model.Dogs;

public interface DogsRepository extends JpaRepository <Dogs, Long> {
}
