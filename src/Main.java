import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {

        /*Отличительные черты функционального программирования в этой программе:
        1. Отсутствуют побочные эффекты, кроме строчки с выводом коллекции на экран;
        2. Использую реализацию интерфейся Function, результат его работы детерменированный, т.к.
                результат зависит только от входных параметров;
        3. Кроме того сам интерфейс Function даёт возможность писать детерменированные и чистые функции;
        4. Использую монады (Stream Api)*/

        List<String> aboriginalPhrases = new ArrayList<>();
        aboriginalPhrases.add("Присивесет яся асабосарисигесен Виситасалисий!");
        aboriginalPhrases.add("Яся исиз солёного плесемесениси");
        aboriginalPhrases.add("Аса тысы?");
        aboriginalPhrases.add("Мысы тесебяся несе особисидисим!");

        Function<List<String>, List<String>> dictionaryGenerator = x ->
                x.stream()
                        .flatMap(word -> Arrays.stream(word.split(" ")))
                        .map(String::toLowerCase)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList());

        System.out.println(dictionaryGenerator.apply(aboriginalPhrases));
    }
}