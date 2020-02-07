package sunwell.repository;

import org.springframework.data.repository.CrudRepository;
import sunwell.entity.GameDev;

public interface GameDevRepository extends CrudRepository<GameDev, Integer>
{
}
