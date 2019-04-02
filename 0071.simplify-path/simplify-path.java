class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> resultPath = new ArrayList<String>();
        for(int i = 0 ; i < path.length() ; i++){
            if(path.charAt(i) == '/') continue;
            int j = i;
            while(i < path.length() && path.charAt(i) != '/'){
                i ++;
            }
            String s = path.substring(j,i);
            if(s.equals(".")) continue;
            else if(s.equals("..")){
                if(resultPath.size() > 0)
                    resultPath.remove(resultPath.size()-1);
            }
            else resultPath.add(s);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < resultPath.size() ; i++){
            result.append('/');
            result.append(resultPath.get(i));
        }
        if(result.length() == 0) result.append('/');
        return result.toString();
    }
}