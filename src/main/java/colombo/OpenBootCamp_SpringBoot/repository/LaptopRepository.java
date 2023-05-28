package colombo.OpenBootCamp_SpringBoot.repository;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
