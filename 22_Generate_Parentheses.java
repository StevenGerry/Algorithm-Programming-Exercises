class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }
    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
        System.out.println(out);
    }
}

/* Official Solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
*/
