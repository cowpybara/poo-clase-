package test;

import model.Sucursal;
import service.IDAOSucursal;
import service.ImplDAOSucursal;

import java.util.List;

public class Main {

    private static final  IDAOSucursal dao = new ImplDAOSucursal();

    public static Sucursal finById(Integer id){
        Sucursal entity = dao.getById(id);
        System.out.println(entity);
        return entity;
    }

    public static void update(Sucursal entity){
        Sucursal sucursal = dao.update(entity);
        System.out.println(sucursal);
    }

    public static void delete(Sucursal entity){
        dao.remove(entity);

    }

    public static void main(String[] args) {

        List<Sucursal> lista = dao.getAll("Sucursal.All");
        lista.forEach(System.out::println);

        //probar el findById
        Sucursal s = finById(3);

        //probar el update
        s.setNombre("Angie");
        update(s);
        lista.forEach(System.out::println);

        //probar el delete
        delete(s);
        lista.forEach(System.out::println);
    }


}
