package committee.nova.nbtreader.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Goulixiaoji
 */
public class MatchBracket {
    protected Map<Character,Character> pair = new HashMap<>();

    public MatchBracket(Map<Character, Character> pairIn){
        this.pair = pairIn;
    }

    public MatchBracket(){
        pair.put(')', '(');
        pair.put(']','[');
        pair.put('}', '{');
    }

    public boolean isMatch(String str){
        Stack<Character> sc = new Stack<>();
        for (int g=0;g < str.length();g++){
            Character ch = str.charAt(g);
            if (pair.containsValue(ch)){
                sc.push(ch);
            } else if (pair.containsKey(ch)){
                if (sc.empty()){
                    return false;
                }
                if (sc.peek().equals(pair.get(ch))){
                    sc.pop();
                } else {
                    return false;
                }
            }
        }
        return sc.empty();
    }
}
