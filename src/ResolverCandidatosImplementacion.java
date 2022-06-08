import java.util.ArrayList;
import java.util.List;

public class ResolverCandidatosImplementacion implements ResolverCandidatosInterface {

    private ArrayList<Resultado> resultados;
    private Resultado resultado = new Resultado();

    @Override
    public ArrayList<Resultado> obtenerCandidatos(
            ArrayList<Vacante> vacantes,
            ArrayList<Candidato> candidatos,
            int maxCombinaciones
    ) {
        resultados = new ArrayList<>();
        resultado.puestosCubiertos = new ArrayList<>();

        encontrarCandidatos(vacantes, candidatos, vacantes.size());

        return resultados;
    }

    private void encontrarCandidatos(List<Vacante> vacantes, List<Candidato> candidatos, int totalVacantes) {
        for (Vacante vacante : vacantes) {
            for (Candidato candidato : candidatos) {
                if (candidato.calificacion >= vacante.califMinima) {
                    List<Vacante> v = new ArrayList<>(List.copyOf(vacantes));
                    List<Candidato> c = new ArrayList<>(List.copyOf(candidatos));

                    v.remove(vacante);
                    c.remove(candidato);

                    PuestoCubierto puesto = agregarPuestoCubierto(vacante, candidato);

                    if (resultado.puestosCubiertos.size() == totalVacantes) {
                        resultados.add(resultado);
                    }

                    encontrarCandidatos(v, c, totalVacantes);

                    reducirPuestosCubiertos(puesto);
                }
            }
        }
    }

    private PuestoCubierto agregarPuestoCubierto(Vacante vacante, Candidato candidato) {
        PuestoCubierto puesto = new PuestoCubierto();
        puesto.calificacionCandidato = candidato.calificacion;
        puesto.idCandidato = candidato.idCandidato;
        puesto.nombreVacante = vacante.nombreVacante;
        puesto.califVacante = vacante.califMinima;
        resultado.idResultado = resultados.size();
        resultado.puestosCubiertos.add(puesto);
        return puesto;
    }

    private void reducirPuestosCubiertos(PuestoCubierto puesto) {
        ArrayList<PuestoCubierto> aux = new ArrayList<>(List.copyOf(resultado.puestosCubiertos));
        resultado = new Resultado();
        aux.remove(puesto);
        resultado.puestosCubiertos = aux;
    }
}
