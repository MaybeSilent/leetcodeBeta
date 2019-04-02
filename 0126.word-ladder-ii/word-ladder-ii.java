class Solution {
    private List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordsSets = new HashSet<String>();
        for(String word : wordList){
            wordsSets.add(word);
        }
        if(!wordsSets.contains(endWord)) return result;
        HashMap<String,Integer> used = new HashMap<String,Integer>();
        used.put(beginWord,0);
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(new Node(beginWord,null,0));
        int resultLevel = Integer.MAX_VALUE;
        while(list.size() != 0){
            Node curNode = list.removeFirst();
            if(curNode.level > resultLevel) break;
            char[] chars = curNode.word.toCharArray();
            for(int i = 0 ; i < chars.length ; i++){
                char before = chars[i];
                for(int j = 0 ; j < 26 ; j++){
                    char after = (char)('a' + j);
                    if(before == after) continue;
                    chars[i] = after;
                    String newstr = String.valueOf(chars);
                    if(wordsSets.contains(newstr)){
                        if(newstr.equals(endWord)){
                            resultLevel = curNode.level;
                            LinkedList<String> subResult = new LinkedList<String>();
                            subResult.addFirst(endWord);
                            Node loop = curNode;
                            while(loop != null){
                                subResult.addFirst(loop.word);
                                loop = loop.prev;
                            }
                            result.add(subResult);
                        } else{
                            //System.out.println(newstr + " " +  curNode.word);
                            if(!used.containsKey(newstr)||used.get(newstr) == curNode.level + 1){
                                Node newNode = new Node(newstr,curNode,curNode.level+1);
                                list.add(newNode);
                                used.put(newstr,curNode.level+1);
                            }
                            
                        }
                    }
                }
                chars[i] = before;
            }
        }
        
        return result;
    }
}
class Node{
    String word;
    Node prev;
    int level;
    public Node(String word,Node prev,int level){
        this.word = word;
        this.level = level;
        this.prev = prev;
    }
}