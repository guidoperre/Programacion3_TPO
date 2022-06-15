import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

    @Test
    public void testPorCandidatos() {
        int muestras = 10;
        int candidatos = 10;

        for (int i = 1; i <= muestras; i++) {
            muestra(i, 3, candidatos * i);
        }
    }

//    @Test
//    public void testPorVacantes() {
//        int muestras = 10;
//        int vacantes = 1;
//
//        for (int i = 1; i <= muestras; i++) {
//            muestra(i, vacantes * i, 11);
//        }
//    }

    private void muestra(int muestra, int v, int c){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:ms");
        System.out.println("Inicio muestra " + muestra + " " + formatter.format(new Date()));

        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();

        ArrayList<Vacante> vacantes = crearVacantes(v);
        ArrayList<Candidato> candidatos = createCandidatos(c);

        int maxCombinaciones = 4;

        encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);

        System.out.println("Fin muestra " + muestra + " " + formatter.format(new Date()));
        System.out.println();
    }

    private ArrayList<Vacante> crearVacantes(int cantidad) {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        int i = 0;
        while (i < cantidad) {
            vacantes.add(Principal.crearVacante(String.valueOf(i), ThreadLocalRandom.current().nextInt(0,  11)));
            i++;
        }
        return vacantes;
    }

    private ArrayList<Candidato> createCandidatos(int cantidad) {
         ArrayList<Candidato> candidatos = new ArrayList<>();
         int i = 0;
         while (i < cantidad) {
             candidatos.add(Principal.crearCandidato(i, ThreadLocalRandom.current().nextInt(0,  15)));
             i++;
         }
         return candidatos;
    }
}
