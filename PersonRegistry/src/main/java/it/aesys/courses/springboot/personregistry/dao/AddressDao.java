package it.aesys.courses.springboot.personregistry.dao;

import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.models.Address;

public interface AddressDao extends Dao<Address> {


    void deleteAddress(Integer index) throws DaoException;

    Address getAddress(Integer index) throws DaoException;

    Integer createAddress(Address address) throws  DaoException;
}
