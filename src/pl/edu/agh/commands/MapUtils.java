package pl.edu.agh.commands;

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
}
