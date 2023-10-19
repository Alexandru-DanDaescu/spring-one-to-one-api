package ro.alex.springonetooneapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.alex.springonetooneapi.models.entities.Computer;


@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
