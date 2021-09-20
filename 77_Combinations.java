class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = combine(1,n,k);
        return list;
    }
    
    private List<List<Integer>> combine(int start, int n , int k){
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if( k == 1 ){
            for (int i = start; i<= n; i++){
                List<Integer> subList = new ArrayList();
                subList.add(i);
                list.add(subList);
            }
        }

        else{
            for(int i=start;  i<= n-k+1 ; i++){
                List<List<Integer>> subCombinations =  combine(i+1, n, k-1);
                for( List<Integer> subCombination : subCombinations){
                    subCombination.add(i);
                }
                list.addAll(subCombinations);
            }
        }
        return list;
    }
}
