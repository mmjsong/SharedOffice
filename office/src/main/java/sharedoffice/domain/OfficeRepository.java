package sharedoffice.domain;

import sharedoffice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="offices", path="offices")
public interface OfficeRepository extends PagingAndSortingRepository<Office, Long>{

}
