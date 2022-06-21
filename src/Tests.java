import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

    public static void main(String[] args) {
        testPorCandidatos();
    }

    public static void testPorCandidatos() {
        int muestras = 25;
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

    private static void muestra(int muestra, int v, int c){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:ms");
        System.out.println("Inicio muestra " + muestra + " " + formatter.format(new Date()));

        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();

        ArrayList<Vacante> vacantes = crearVacantes(v);
        ArrayList<Candidato> candidatos = createCandidatos(c);

        int maxCombinaciones = 3;

        encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);

        System.out.println("Fin muestra " + muestra + " " + formatter.format(new Date()));
        System.out.println();
    }

    private static ArrayList<Vacante> crearVacantes(int cantidad) {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        int i = 0;
        while (i < cantidad) {
            vacantes.add(crearVacante(String.valueOf(i), ThreadLocalRandom.current().nextInt(0,  11)));
            i++;
        }
        return vacantes;
    }

    private static ArrayList<Candidato> createCandidatos(int cantidad) {
         ArrayList<Candidato> candidatos = new ArrayList<>();
         int i = 0;
         while (i < cantidad) {
             candidatos.add(crearCandidato(i, ThreadLocalRandom.current().nextInt(0,  15)));
             i++;
         }
         return candidatos;
    }

    static Vacante crearVacante(String nombreVacante, int califMinima) {
        Vacante vacante = new Vacante();
        vacante.nombreVacante = nombreVacante;
        vacante.califMinima = califMinima;
        return vacante;
    }

    static Candidato crearCandidato(int idCandidato, int calificacion) {
        Candidato candidato = new Candidato();
        candidato.idCandidato = idCandidato;
        candidato.calificacion = calificacion;
        return candidato;
    }
}
