package problem.problem354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        List<Envelopes> envelopesList = new ArrayList<Envelopes>();
        for (int i = 0; i < len; i++) {
            envelopesList.add(new Envelopes(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(envelopesList);
        // 使用动态规划
        // count[]用于存放当前能存放的最大信封数
        int[] count = new int[len];
        int answer = 1;
        Arrays.fill(count, 1);
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopesList.get(j).height < envelopesList.get(i).height) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }


    class Envelopes implements Comparable<Envelopes> {
        int width;
        int height;
        public Envelopes(int w, int h) {
            this.width = w;
            this.height = h;
        }

        @Override
        public String toString() {
            return "Envelopes{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }

        @Override
        public int compareTo(Envelopes o) {
            if (this.width != o.width) {
                return this.width - o.width;
            } else {
                return o.height - this.height;
            }
        }

    }
}

class Test {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {46, 89},
                {50, 53},
                {52, 68},
                {72, 45},
                {77, 81}
        };
        int count = new Solution().maxEnvelopes(envelopes);
        System.out.println(count);
    }
}