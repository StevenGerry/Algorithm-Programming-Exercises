class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder strBuilder = new StringBuilder(s);
        if (shifts.length == 1)
        {
            if (shifts[0] >= 26)
            {
                shifts[0] = (shifts[0]+26) % 26;
            }
        }
        for(int i=shifts.length - 1; i > 0; i--)
        {
            shifts[i-1] = shifts[i] + shifts[i-1];
            if (shifts[i-1] >= 26)
            {
                shifts[i-1] = (shifts[i-1]+26) % 26;
            }
            if (shifts[i] >= 26)
            {
                shifts[i] = (shifts[i]+26) % 26;
            }
        }
        for(int i=0; i<s.length(); i++)
        {
            String temp = s.substring(i,i+1);
            char[] arr = temp.toCharArray();
            int asc = (int)arr[0];
            if ((asc + shifts[i]) > 122)
                arr[0] = (char) ('a' + (asc + shifts[i] - 122) - 1);
            else
                arr[0] = (char) (arr[0] + shifts[i]);
            strBuilder.setCharAt(i, arr[0]);
        }
        s = strBuilder.toString();
        return s;
    }
}
