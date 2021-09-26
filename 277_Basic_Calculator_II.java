class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new  Stack<>();
        
        int num = 0;
        int sum = 0;
        char last_op = '+';

        s = s.trim();
        s = s.replace(" ", "");
        
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if(!Character.isDigit(s.charAt(i))||i == s.length() - 1)
            {
                if(last_op == '-') {
                    stack.push(-num);
                }
                if(last_op == '+') {
                    stack.push(num);
                }
                if(last_op == '*') {
                    int last_element = stack.pop();
                    stack.add(last_element * num);
                }
                if(last_op == '/') {
                    int last_element = stack.pop();
                    stack.add(last_element / num);
                }
                last_op = s.charAt(i);
                num = 0;
            }
        }
        for(Integer el : stack) {
            sum += el;
        }
        return sum;   
    }
}
