package pl.edu.agh.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class MapUtils<K,V> {

    public  Map<K, Integer> getTopValues(Map<K, Integer> judgesJudgementCount, int n) {
        return judgesJudgementCount.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue())).limit(n)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void incrValue(HashMap<K, Integer> map, K key) {
        map.merge(key, 1, Integer::sum);
    }
    public String getStringTopValues(HashMap<K, Integer> judgesJudgementCount, int n, String separator) {
        Map<K, Integer> sortedMap = getTopValues(judgesJudgementCount, n);
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "";
        for (var entry : sortedMap.entrySet()) {
            result+=entry.getKey() + separator + entry.getValue() +"\n";
        }
        return result;
    }

}
