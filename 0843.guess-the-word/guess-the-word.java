/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    private static int StrLength = 6;
    public void findSecretWord(String[] wordlist, Master master) {
        ArrayList<String> resultArray = new ArrayList<String>(Arrays.asList(wordlist));
        Random random = new Random();
        while(resultArray.size() != 0){
        	String tryStr = resultArray.get(random.nextInt(resultArray.size()));

        	int tryNum = master.guess(tryStr);
        	if(tryNum == StrLength){
        		//System.out.println("YES");
        		break;
        	}
        	for(int i = 0 ; i < resultArray.size() ; i++){
        		if(compareString(resultArray.get(i),tryStr) != tryNum){
        			resultArray.remove(i); i --;
        		}
        	}
        }
    }
    private int compareString(String s1,String s2){
        int count = 0;
        for(int i = 0 ; i < StrLength ; i++){
            if(s1.charAt(i) == s2.charAt(i)){
                count ++;
            }
        }
        return count;
    }
}