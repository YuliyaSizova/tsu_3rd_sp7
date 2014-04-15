package w2and3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Вы знаете, что такое "множество". В java для работы со множествами используют классы, реализующие
 * интерфейс "Set" (например, HashSet и TreeSet).
 * Вашей задачей будет реализовать мультимноджество, т.е. множество, содержащее одинаковые элементы.
 * (а точнее, все методы этого класса). Для упрощения задачи мультимножество будет содержать только
 * целые числа (Integer).
 */
public class IntegerMultiset {
     List<Integer> multiset = new ArrayList<>();

    public boolean add(Integer e) {
        ListIterator<Integer> it = multiset.listIterator();
        Integer amount = 0;
        while (it.hasNext()) {
            if (it.next().equals(e)) {
                amount++;
            }
        }
        if (amount == 0) {
            multiset.add(e);
            return false;
        } else {
            multiset.add(e);
            return true;
        }
    }

    /**
     * Есть ли элемент "e"?
     *
     * @param e
     * @return true, если элемент "e" присутствует в мультимножестве и false
     * иначе
     */
    public boolean contains(Integer e) {
        return multiset.contains(e);
    }

    /**
     * Удаляет один элемент "e"
     *
     * @param e
     * @return true, если удаление имело место (т.е. "e" был в мультимножестве
     * перед удалением) и false иначе
     */
    public boolean pop(Integer e) {
        if (multiset.contains(e) == false) {
            return false;
        } else {
            ListIterator<Integer> it = multiset.listIterator();
            while (it.hasNext()) {
                if (it.next().equals(e)) {
                    it.remove();
                    break;
                }
            }

            return true;
        }

    }

    /**
     * Удаляет все элементы, равные "e".
     *
     * @param e
     * @return true, если удаление имело место и false иначе
     */
    public boolean remove(Integer e) {
        if (multiset.contains(e) == false) {
            return false;
        } else {
            ListIterator<Integer> it = multiset.listIterator();
            while (it.hasNext()) {
                if (it.next().equals(e)) {
                    it.remove();
                }
            }

            return true;
        }
    }
}
