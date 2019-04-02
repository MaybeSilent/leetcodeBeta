class Solution {
    private StringBuilder strBuilder = new StringBuilder();
    private int kind ;
    private HashSet<String> visited = new HashSet() ;
    public String crackSafe(int n, int k) {
        if(k == 1 && n == 1) return "0";
        kind = k ;
        StringBuilder start = new StringBuilder();
        for(int i = 0 ; i < n - 1 ; i++){
            start.append('0');
        }
        dfs(start.toString());
        strBuilder.append(start);
        return strBuilder.toString();
    }
    private void dfs(String curString){
        for(int i = 0 ; i < kind ; i++){
            String added = curString + i;
            if(visited.contains(added)) continue;
            //System.out.println(added);
            visited.add(added);
            dfs(added.substring(1));
            strBuilder.append(i);
        }
    }
}