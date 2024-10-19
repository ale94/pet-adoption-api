package ar.com.ale94.pet_adoption_api.services;

import java.util.List;

public interface ICrudService<RQ, RS, ID> {

    List<RS> read();

    RS readById(ID id);

    RS save(RQ request);

    RS update(RQ request, ID id);

    void delete(ID id);

}
