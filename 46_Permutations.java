class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        recursion(results,new ArrayList<>(),nums);
        return results;
    }
    public void recursion(List<List<Integer>> results,List<Integer> tempResult,int[] nums)
    {
        if (tempResult.size() == nums.length)
        {
            results.add(new ArrayList<>(tempResult));
        }
        else
        {
            for (int i=0;i<nums.length;i++)
            {
                if (tempResult.contains(nums[i]))
                {
                    continue;
                }
                else
                {
                    tempResult.add(nums[i]);
                    recursion(results, tempResult, nums);
                    System.out.println(tempResult);
                    tempResult.remove(tempResult.size()-1);
                }
            }
        }
    }
}
