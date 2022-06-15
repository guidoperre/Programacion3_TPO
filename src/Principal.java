import java.util.ArrayList;

public class Principal {

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

