package HW1;


public class HeapSort {
  
    public void heapSort(int[] array) {
        int n = array.length;
 
        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
 
        // По одному извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
 
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
 
    void heapify(int[] array, int n, int i) {
        int largest = i; 
        int leftChild = 2 * i + 1; 
        int rightChild = 2 * i + 2; 
 

        if (leftChild < n && array[leftChild] > array[largest])
            largest = leftChild;
 
    
        if (rightChild < n && array[rightChild] > array[largest])
            largest = rightChild;
 
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
 
            
            heapify(array, n, largest);
        }
    }
 
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
 
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");
    }
}