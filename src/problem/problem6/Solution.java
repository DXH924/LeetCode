package problem.problem6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 12/21/20209:12 PM
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<Group> groups = new ArrayList<>();
        int offset = 2 * numRows - 2, i;
        for (i = 0; i < s.length() - offset; i += offset) {
            char[] characters = s.substring(i, i + offset).toCharArray();
            groups.add(new Group(characters));
        }
        char[] characters = s.substring(i, s.length()).toCharArray();
        groups.add(new Group(characters));
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < numRows; index++) {
            for (Group g : groups) {
                Character c = g.getChar(index);
                if (c != null) {
                    sb.append(g.getChar(index));
                }
                if (index != 0 && index != (numRows - 1)) {
                    c = g.getChar(offset - index);
                    if (c != null) {
                        sb.append(g.getChar(offset - index));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("A" ,1));
    }
}

class Group {
    private List<Character> chars = new ArrayList<>();
    public Group(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            chars.add(characters[i]);
        }
    }

    public Character getChar(int index) {
        return index >= chars.size() ? null : chars.get(index);
    }
}