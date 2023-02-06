package sharedoffice.infra;

import sharedoffice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="officeviews", path="officeviews")
public interface OfficeviewRepository extends PagingAndSortingRepository<Officeview, Long> {

    List<Officeview> findByRsvId(String rsvId);


    void deleteByRsvId(String rsvId);

}
