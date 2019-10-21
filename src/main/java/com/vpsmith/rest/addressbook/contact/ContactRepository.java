package com.vpsmith.rest.addressbook.contact;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ContactRepository extends
        CrudRepository<ContactEntity, Integer> {
}
