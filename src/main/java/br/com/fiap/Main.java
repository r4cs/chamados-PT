package br.com.fiap;

import br.com.fiap.domain.entity.Area;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();


        boolean salvou = false;

        do {
            Area area = new Area();
            String nome = JOptionPane.showInputDialog("Nome da área");
            String descricao = JOptionPane.showInputDialog("Nome da descrição");

            area.setNome(nome).setDescricao(descricao);
            try {
                manager.getTransaction().begin();
                manager.persist(area);
                manager.getTransaction().commit();
                System.out.println(area);
                salvou = true;
            }
            catch (Exception exception) {
                String erro = """
                    ERRO! 
                    Não foi possível completar a transação:
                    """ + exception.getLocalizedMessage();
            }
        }
        while (salvou == false);

        manager.close();
        factory.close();

    }
}