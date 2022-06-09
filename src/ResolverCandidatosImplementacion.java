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

        encontrarCandidatos(vacantes, candidatos, 0);

        return resultados;
    }

    private void encontrarCandidatos(List<Vacante> vacantes, List<Candidato> candidatos, int nivel) {
        for (Candidato candidato : candidatos) {
            if (candidato.calificacion >= vacantes.get(nivel).califMinima) {
                List<Candidato> c = new ArrayList<>(List.copyOf(candidatos));

                c.remove(candidato);

                PuestoCubierto puesto = agregarPuestoCubierto(vacantes.get(nivel), candidato);

                if (resultado.puestosCubiertos.size() == vacantes.size()) {
                    resultados.add(resultado);
                }

                if (nivel < vacantes.size() - 1) {
                    encontrarCandidatos(vacantes, c, nivel + 1);
                }

                reducirPuestosCubiertos(puesto);
            }
        }
    }

    private PuestoCubierto agregarPuestoCubierto(Vacante vacante, Candidato candidato) {
        PuestoCubierto puesto = new PuestoCubierto();
        puesto.calificacionCandidato = candidato.calificacion;
        puesto.idCandidato = candidato.idCandidato;
        puesto.nombreVacante = vacante.nombreVacante;
        puesto.califVacante = vacante.califMinima;
        resultado.idResultado = resultados.size() + 1;
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
