import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResolverCandidatosImplementacion implements ResolverCandidatosInterface {

    private ArrayList<Resultado> resultados;
    private Resultado resultado = new Resultado();
    private int indiceValorMaximo = 0;

    @Override
    public ArrayList<Resultado> obtenerCandidatos(
            ArrayList<Vacante> vacantes,
            ArrayList<Candidato> candidatos,
            int maxCombinaciones
    ) {
        resultados = new ArrayList<>();
        resultado.puestosCubiertos = new ArrayList<>();

        encontrarCandidatos(vacantes, candidatos, maxCombinaciones, 0);

        return resultados;
    }

    private void encontrarCandidatos(List<Vacante> vacantes, List<Candidato> candidatos, int maxCombinaciones, int nivel) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).calificacion >= vacantes.get(nivel).califMinima) {
                PuestoCubierto puesto = agregarPuestoCubierto(vacantes.get(nivel), candidatos.get(i));

                if (resultado.puestosCubiertos.size() == vacantes.size()) {
                    intentarAgregar(maxCombinaciones);
                } else if (
                    vacantes.size() - resultado.puestosCubiertos.size() < candidatos.size() &&
                    !(
                        resultados.size() == maxCombinaciones &&
                        calificacionTotal(resultado) > calificacionTotal(resultados.get(indiceValorMaximo))
                    )
                ) {
                    List<Candidato> c = new ArrayList<>(List.copyOf(candidatos));
                    c.remove(candidatos.get(i));
                    encontrarCandidatos(vacantes, c, maxCombinaciones, nivel + 1);
                }

                reducirPuestosCubiertos(puesto);
            }
        }
    }

    private void intentarAgregar(int maxCombinaciones) {
        int resultadoTotal = calificacionTotal(resultado);
        if (resultados.size() >= maxCombinaciones) {
            resultados.set(indiceValorMaximo, resultado);
            int valorMaximo = 0;
            int aux = -1;
            for (int i = 0; i < resultados.size(); i++) {
                int iTotal = calificacionTotal(resultados.get(i));
                if (iTotal > valorMaximo) {
                    valorMaximo = iTotal;
                    aux = i;
                }
            }
            indiceValorMaximo = aux;
        } else {
            resultados.add(resultado);
            if (resultadoTotal > calificacionTotal(resultados.get(indiceValorMaximo))) {
                indiceValorMaximo = resultados.size() - 1;
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

    public static int calificacionTotal(Resultado resultado) {
        int total = 0;
        for (PuestoCubierto puesto : resultado.puestosCubiertos) {
            total += puesto.calificacionCandidato;
        }
        return total;
    }
}
