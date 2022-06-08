import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ResolverCandidatosImplementacion encontrarCandidatos = new ResolverCandidatosImplementacion();
        ArrayList<Vacante> vacantes = crearVacantes();
        ArrayList<Candidato> candidatos = crearCandidatos();
        int maxCombinaciones = 4;

        ArrayList<Resultado> resultados = encontrarCandidatos.obtenerCandidatos(vacantes, candidatos, maxCombinaciones);

        // USAR ESTE PARA VER TODOS LOS RESULTADOS VALIDOS
        imprimirResultados(resultados);

        // USAR ESTE PARA VER RESULTADOS VALIDOS SIN REPETIDOS
        //imprimirResultadosSinRepetidos(resultados);
    }

    private static void imprimirResultados(ArrayList<Resultado> resultados) {
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
            System.out.println();
        }
    }

    private static void imprimirResultadosSinRepetidos(ArrayList<Resultado> resultados) {
        for (Resultado resultado : resultados) {
            boolean valid = true;
            for(int i = 0; i < resultado.puestosCubiertos.size(); i++) {
                if (i == 0 && !resultado.puestosCubiertos.get(i).nombreVacante.equals("A")) {
                    valid = false;
                }
                if (i == 1 && !resultado.puestosCubiertos.get(i).nombreVacante.equals("B")) {
                    valid = false;
                }
                if (i == 2 && !resultado.puestosCubiertos.get(i).nombreVacante.equals("C")) {
                    valid = false;
                }
            }
            if (valid) {
                System.out.println("Resultado " + resultado.idResultado);

                for (PuestoCubierto puesto : resultado.puestosCubiertos) {
                    System.out.print("[" + puesto.nombreVacante + "]");
                }
                System.out.println();
                for (PuestoCubierto puesto : resultado.puestosCubiertos) {
                    System.out.print("[" + puesto.idCandidato + "]");
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    private static ArrayList<Vacante> crearVacantes() {
        ArrayList<Vacante> vacantes = new ArrayList<>();
        vacantes.add(crearVacante("A", 10));
        vacantes.add(crearVacante("B", 0));
        vacantes.add(crearVacante("C", 0));
        return vacantes;
    }

    private static Vacante crearVacante(String nombreVacante, int califMinima) {
        Vacante vacante = new Vacante();
        vacante.nombreVacante = nombreVacante;
        vacante.califMinima = califMinima;
        return vacante;
    }

    private static ArrayList<Candidato> crearCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(crearCandidato(1, 15));
        candidatos.add(crearCandidato(2, 12));
        candidatos.add(crearCandidato(3, 9));
        return candidatos;
    }

    private static Candidato crearCandidato(int idCandidato, int calificacion) {
        Candidato candidato = new Candidato();
        candidato.idCandidato = idCandidato;
        candidato.calificacion = calificacion;
        return candidato;
    }
}

