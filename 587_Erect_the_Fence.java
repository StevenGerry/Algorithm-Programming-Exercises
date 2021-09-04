class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                return p[0] == q[0] ? q[1] - p[1] : p[0] - q[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < trees.length; i++){
            int[] next = {trees[i][0],trees[i][1]};
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2), stack.peek(), next) > 0) {
                stack.pop();
            }
            stack.push(next);
        }
        stack.pop();
        for (int i = trees.length - 1; i >= 0; i--){
            int[] next = {trees[i][0],trees[i][1]};
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2), stack.peek(), next) > 0) {
                stack.pop();
            }
            stack.push(next);
        }
        int count = 0;
        int dup_count = 0;
        int[][] res = new int[stack.size()][];
        for (int i = 0; i < stack.size(); i++)
        {
            int[] temp = stack.get(i);
            res[count] = new int[2];
            res[count][0] = temp[0];
            res[count][1] = temp[1];
            if (count >= 1)
            {
                int flag = 0;
                for (int j = 0; j < count; j++)
                {
                    if (temp[0] == res[j][0] && temp[1] == res[j][1])
                        flag = 1;
                }
                if (flag != 1)
                    count++;
                else
                    dup_count++;
            }
            else
            {
                count++;
            }
        }
        int[][] resAns = new int[count][];
        for (int i = 0; i < count; i++)
        {
            resAns[i] = new int[2];
            resAns[i][0] = res[i][0];
            resAns[i][1] = res[i][1];
        }
        return resAns;
    }
    
    public int orientation(int[] p, int[] q, int[] r)
    {
        return (q[1] - p[1]) * (r[0] - p[0]) - (q[0] - p[0]) * (r[1] - p[1]);
    }
}
