package br.uff.compiladores.lexica;

import lombok.var;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsRemover {

    public Map<Integer, String> remove(List<String> code){
        return createMap(
                code
                    .stream()
                    .filter(this::removeCommentsAndBlankSpaces)
                    .map(this::removeTabs)
                    .collect(Collectors.toList())
        );
    }

    private String removeTabs(String x){
        return x.replaceAll("\\t", "");
    }

    private Boolean removeCommentsAndBlankSpaces(String x){
        return !(
                x.equals(" ") ||
                x.equals("\\n") ||
                x.matches("//(.)*") ||
                x.matches("/*(.)*\\*/")
        );
    }

    private Map<Integer, String> createMap(List<String> list){
        Map<Integer, String> map = new HashMap<>();

        for(int i = 1; i <= list.size(); i++){
            map.put(i, list.get(i - 1));
        }

        return map;
    }
}
