class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        Arrays.sort(nums);
        recursion(results,new ArrayList<>(),nums,new boolean[nums.length]);
        return results;  
    }
    public void recursion(List<List<Integer>> results,List<Integer> tempResult,int[] nums, boolean[] used)
    {
        if (tempResult.size() == nums.length)
        {
            results.add(new ArrayList<>(tempResult));
        }
        else
        {
            for (int i=0;i<nums.length;i++)
            {
                if (used[i]||i>0&&nums[i]==nums[i-1]&&!used[i-1])
                {
                    continue;
                }
                used[i] = true;
                tempResult.add(nums[i]);
                recursion(results, tempResult, nums, used);
                used[i]=false;
                tempResult.remove(tempResult.size()-1);
            }
        }
    }
}
