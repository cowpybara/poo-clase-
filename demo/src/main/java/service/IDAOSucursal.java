package service;

import model.Sucursal;

import java.util.List;

public interface IDAOSucursal {

     List<Sucursal> getAll(String nameQuery);

     void insert(Sucursal entity);

     Sucursal getById(Integer id);

     void remove(Sucursal entity);

     Sucursal update(Sucursal entity);
}
