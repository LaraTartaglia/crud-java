package com.mercadolibre.demo.service;

import com.mercadolibre.demo.model.SuperHeroe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperHeroeService {

    private List<SuperHeroe> superHeroeList;

    public SuperHeroeService() {
        superHeroeList = new ArrayList<>();
        superHeroeList.add(new SuperHeroe(1,"batman","murcielago",true));
        superHeroeList.add(new SuperHeroe(2,"spiderman","araña",false));
        superHeroeList.add(new SuperHeroe(3,"ant-man","hormiga",false));
    }

    public List<SuperHeroe> list() {
        return superHeroeList;
    }

    //buscar superheroe
    public SuperHeroe find(int id) {
        for (SuperHeroe superHeroe: superHeroeList) {
            if (superHeroe.getId() == id) {
                return superHeroe;
            }
        }
        return null;
    }

    //guardar superheroe
    public SuperHeroe save(SuperHeroe superHeroe) {
        superHeroeList.add(superHeroe);
        return superHeroe;
    }

    public SuperHeroe update(int id, SuperHeroe superHeroe) {
        int i = 0;
        for (SuperHeroe j: superHeroeList) {
            if (j.getId() == id) {
                superHeroe.setId(id);
                superHeroeList.set(i, superHeroe);
            }
            i++;
        }
        return superHeroe;
    }

    public boolean delete(int id) {
        for (SuperHeroe j: superHeroeList) {
            if (j.getId() == id) {
                return superHeroeList.remove(j);
            }
        }
        return false;
    }
}
