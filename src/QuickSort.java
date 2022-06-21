public class QuickSort {

    public void quickSort(Resultado[] arr, int begin, int end, int n) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            if (partitionIndex < n) {
                quickSort(arr, partitionIndex + 1, end, n);
            } else if (partitionIndex > n) {
                quickSort(arr, begin, partitionIndex - 1, n);
            }
        }
    }

    private int partition(Resultado[] arr, int begin, int end) {
        Resultado pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (ResolverCandidatosImplementacion.calificacionTotal(arr[j]) <= ResolverCandidatosImplementacion.calificacionTotal(pivot)) {
                i++;

                Resultado swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Resultado swapTemp = arr[i+1];

        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
