import com.example.demo.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByUserId(Long userId);
}
