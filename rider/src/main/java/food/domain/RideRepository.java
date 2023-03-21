package food.domain;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rides", path = "rides")
public interface RideRepository
    extends PagingAndSortingRepository<Ride, Long> {}
