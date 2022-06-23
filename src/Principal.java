import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        /*imprimirResultados("Ejemplo 1", ejemplo1());
        System.out.println("---------------------------");
        imprimirResultados("Ejemplo 2", ejemplo2());
        System.out.println("---------------------------");*/
        imprimirResultados("Ejemplo 3", ejemplo3());
        //System.out.println("---------------------------");
        //imprimirResultados("Ejemplo 4", ejemplo4());
    }

    public static ArrayList<Resultado> ejemplo1() {
        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();
        ArrayList<Vacante> vacantes = crearVacantes1();
        ArrayList<Candidato> candidatos = crearCandidatos1();
        int maxCombinaciones = 4;

        return encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);
    }

    private static ArrayList<Vacante> crearVacantes1() {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        vacantes.add(crearVacante("A", 10));
        vacantes.add(crearVacante("B", 0));
        vacantes.add(crearVacante("C", 0));
        return vacantes;
    }

    private static ArrayList<Candidato> crearCandidatos1() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(crearCandidato(1, 15));
        candidatos.add(crearCandidato(2, 12));
        candidatos.add(crearCandidato(3, 9));
        return candidatos;
    }


    public static ArrayList<Resultado> ejemplo2() {
        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();
        ArrayList<Vacante> vacantes = crearVacantes2();
        ArrayList<Candidato> candidatos = crearCandidatos2();
        int maxCombinaciones = 4;

        return encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);
    }

    private static ArrayList<Vacante> crearVacantes2() {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        vacantes.add(crearVacante("A", 10));
        vacantes.add(crearVacante("B", 0));
        vacantes.add(crearVacante("C", 0));
        vacantes.add(crearVacante("D", 0));
        return vacantes;
    }

    private static ArrayList<Candidato> crearCandidatos2() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(crearCandidato(1, 9));
        candidatos.add(crearCandidato(2, 4));
        candidatos.add(crearCandidato(3, 5));
        candidatos.add(crearCandidato(4, 8));
        candidatos.add(crearCandidato(5, 1));
        return candidatos;
    }

    /*
     * Crea 120 combinacion
     * 60 son combinaciones validas
     * Las 2 mejores tienen calificacion 24 y 24 puntos
     * (Falla)
     */
    public static ArrayList<Resultado> ejemplo3() {
        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();
        ArrayList<Vacante> vacantes = crearVacantes3();
        ArrayList<Candidato> candidatos = crearCandidatos3();
        int maxCombinaciones = 6;

        return encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);
    }

    private static ArrayList<Vacante> crearVacantes3() {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        vacantes.add(crearVacante("A", 10));
        vacantes.add(crearVacante("B", 0));
        vacantes.add(crearVacante("C", 0));
        return vacantes;
    }

    private static ArrayList<Candidato> crearCandidatos3() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(crearCandidato(1, 12));
        candidatos.add(crearCandidato(2, 4));
        candidatos.add(crearCandidato(3, 8));
        candidatos.add(crearCandidato(4, 15));
        candidatos.add(crearCandidato(5, 9));
        candidatos.add(crearCandidato(6, 17));
        return candidatos;
    }


    public static ArrayList<Resultado> ejemplo4() {
        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();
        ArrayList<Vacante> vacantes = crearVacantes4();
        ArrayList<Candidato> candidatos = crearCandidatos4();
        int maxCombinaciones = 6;

        return encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);
    }

    private static ArrayList<Vacante> crearVacantes4() {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        vacantes.add(crearVacante("A", 10));
        vacantes.add(crearVacante("B", 0));
        vacantes.add(crearVacante("C", 0));
        return vacantes;
    }

    private static ArrayList<Candidato> crearCandidatos4() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(crearCandidato(1, 15));
        candidatos.add(crearCandidato(2, 12));
        candidatos.add(crearCandidato(3, 9));
        candidatos.add(crearCandidato(4, 4));

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

    static void imprimirResultados(String titulo, ArrayList<Resultado> resultados) {
        System.out.println(titulo);
        System.out.println();

        if (!resultados.isEmpty()) {
            for (Resultado resultado : resultados) {
                System.out.println("Resultado " + resultado.idResultado);

                for (PuestoCubierto puesto : resultado.puestosCubiertos) {
                    System.out.print("[" + puesto.nombreVacante + "]");
                }
                System.out.println();
                for (PuestoCubierto puesto : resultado.puestosCubiertos) {
                    System.out.print("[" + puesto.idCandidato + "]");
                }
                System.out.println();
                for (PuestoCubierto puesto : resultado.puestosCubiertos) {
                    System.out.print("[" + puesto.calificacionCandidato + "]");
                }
                System.out.println();
                int total = ResolverCandidatosImplementacion.calificacionTotal(resultado);
                System.out.println("Puntuacion total: " + total);
                System.out.println();
            }
        } else {
            System.out.println("No hay resultados.");
        }
    }
}

