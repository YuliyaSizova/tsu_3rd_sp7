package w1;


/**
 * Примечание: в этой задаче не рекомендуется использовать контейнеры.
 * Попробуйте вместо этого воспользоваться сортировкой и работать уже с отсортированным массивом.
 * Разрешается использовать библиотечные методы для сортировки, а не писать свои.
 */
public class Task1 {
    /**
     * Метод вычисляет количество уникальных чисел в массиве "array"
     * @param array массив
     * @return количество уникальных чисел
     */
    public int numberOfUniqueNumbers(int[] array) {
        int c = 0;

        java.util.Arrays.sort(array);
        for (int i = 0; i < array.length; ++i) {
            if ((i == 0 || array[i] > array[i - 1])){
                c++;
            }
        }

        return c;
    }

    /**
     * Самое часто встречающееся число. Если таковых несколько, то возвращает любое из них
     * @param array массив
     * @return самое часто встречающееся число (или одно из, если таковых несколько)
     */
    public int mostFrequentNumber(int[] array) {
           int c = 0;
        int k = 0;
        int x = 0;
        int m = 0;
       
            java.util.Arrays.sort(array);

            k = 1;
            x = array[0];
            m = 1;
            for (int i = 1; i < array.length; i++) 
                
                if (array[i - 1] == array[i]) {
                    m++;
                } else{ 
                    if (m > k) {
                    k = m;
                    x = array[i - 1];
                }
            
                m = 1;
            }                
            
              if (m > k) {
                k = m;
                x = array[array.length-1];
            }  
            return x;

    }
    }

