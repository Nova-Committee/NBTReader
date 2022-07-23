package committee.nova.nbtreader.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Goulixiaoji
 */
public class SolveNBT {
    protected static final MatchBracket MATCH_BRACKET = new MatchBracket();

    /**
     * Don't ask me why I use 'g' and 'r' instead of 'i' and 'j', Because it means.
     * @param nbt The nbt is from .serializeNBT().toString()
     * @return The map of it(nbt)
     */
    public static Map<String, String> solveNBT(String nbt){
        Map<String, String> map = new HashMap<>();
        final int useLength = nbt.length()-1;
        int begin = 1;
        int end;
        for (int g=1; g < useLength; ++g){
            if (nbt.charAt(g) == ':'){
                end = useLength;
                for (int r=g+1; r < useLength; ++r){
                    if (nbt.charAt(r) == ',' && MATCH_BRACKET.isMatch(nbt.substring(g+1, r))){
                        end = r;
                        break;
                    }
                }

                String key = nbt.substring(begin, g);
                String value = nbt.substring(g+1, end);
                map.put(key, value);

                begin = end+1;
                g = begin;

                if (end == useLength){
                    break;
                }
            }
        }
        return map;
    }

}
