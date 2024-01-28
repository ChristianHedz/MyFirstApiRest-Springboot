package org.chris.myfirstapirest.api.repositories;


import org.chris.myfirstapirest.api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
