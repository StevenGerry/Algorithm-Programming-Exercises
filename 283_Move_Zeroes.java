class Solution {
    public void moveZeroes(int[] nums) {
        LinkedList<Integer> ans = new LinkedList();
        LinkedList<Integer> zero = new LinkedList();
        LinkedList<Integer> nozero = new LinkedList();
        int sizeofzero = 0;
        int sizeofnozero = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 0)
            {
                zero.push(nums[i]);
                sizeofzero++;
            }
            else
            {
                nozero.push(nums[i]);
                sizeofnozero++;
            }
        }
        for(int i=0;i<sizeofzero;i++){
            int out = zero.pop();
            ans.push(out);
        }
        for(int i=0;i<sizeofnozero;i++){
            int out = nozero.pop();
            ans.push(out);
        }
        for(int i=0;i<(sizeofnozero+sizeofzero);i++){
            nums[i] = ans.pop();
        }
    }
}
