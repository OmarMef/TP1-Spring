package pres;
import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.util.Scanner;

public class Pres2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("config.txt"));
        //DaoImpl d = new DaoImpl();   cette instanciation est statique & les 3 lignes dinamique

        String dcn = sc.nextLine();    //demande le nom de la classe
        Class cDao = Class.forName(dcn);  //chercher la classe si existe la charger en memoire
        IDao dao = (IDao) cDao.getConstructor().newInstance();  //creation d objet de cette classe


        //IMetier metier = new MetierImpl(dao);   Instanciation statique const avec parametre

        String mcn = sc.nextLine();
        Class cMetier = Class.forName(mcn);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao); //constru par parametres
        System.out.println("RES= " + metier.calcul());
    }

}
