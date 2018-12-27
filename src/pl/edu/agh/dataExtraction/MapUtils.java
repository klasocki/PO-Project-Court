package pl.edu.agh.dataExtraction;

import pl.edu.agh.model.Judgment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class MapUtils<K, V> {

    private Map<K, Integer> getTopValues(Map<K, Integer> map, int n) {
        return map.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue())).limit(n)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void incrValue(Map<K, Integer> map, K key) {
        map.merge(key, 1, Integer::sum);
    }

    public String getValuesWithMostJudgments(Map<String, Judgment> judgments,
                                             Function<Judgment, K> getKeyValue, int n, String separator) {

        Map<K, Integer> judgmentsKeyCount = new HashMap<>();
        for (var judgment : judgments.values()) {
            incrValue(judgmentsKeyCount, getKeyValue.apply(judgment));
        }
        return topValuesToString(n, separator, judgmentsKeyCount);
    }

    public String topValuesToString(int n, String separator, Map<K, Integer> judgmentsKeyCount) {
        Map<K, Integer> sortedMap = getTopValues(judgmentsKeyCount, n);

        StringBuilder result = new StringBuilder();
        for (var entry : sortedMap.entrySet()) {
            result.append(entry.getKey()).append(separator).append(entry.getValue()).append("\n");
        }
        return result.toString();
    }


}

