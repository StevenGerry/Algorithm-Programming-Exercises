class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        list.add(0);
        
        for(int i =1;i<=n;i++){
            for(int j =0;j<list.size();j++){
                int val = list.get(j)<<1;
                ans.add(val);
            }

            for(int j =list.size()-1;j>=0;j--){
                int val = (list.get(j)<<1) + 1;
                ans.add(val);
            }
            
            list = ans;
            ans = new ArrayList();
        }
        
        return list;
    }
}
