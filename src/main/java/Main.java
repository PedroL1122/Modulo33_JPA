import com.example.entity.Acessorio;
import com.example.entity.Carro;
import com.example.entity.Marca;
import dao.GenericDAO;

import java.util.ArrayList;

public class Main {
    public static  void main(String[] args){
        GenericDAO genericDAO = new GenericDAO("demo");

        Marca marca = new Marca();
        marca.setNome("Corsa");

        Carro carro = new Carro();
        carro.setModelo("Corsa Wind");
        carro.setMarca(marca);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("roda");

        carro.setAcessorios(new ArrayList<>());
        carro.getAcessorios().add(acessorio);
        acessorio.getCarros().add(carro);

        genericDAO.save(marca);
        genericDAO.save(carro);
        genericDAO.save(acessorio);

        genericDAO.commit();

        genericDAO.close();
    }
}
