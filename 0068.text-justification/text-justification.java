class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        List<String> result = new ArrayList<String>();
        while(index < words.length){
            int curLength = 0;
            int count = 0;
            StringBuilder strb = new StringBuilder();
            while(curLength < maxWidth && index + count < words.length){
                if(curLength != 0){
                    strb.append(' ');
                    curLength ++;
                }
                curLength += words[index+count].length();
                strb.append(words[index+count]);
                count ++;
            }
            if(curLength == maxWidth){
                result.add(strb.toString());
                index = index + count;
            } else if(curLength > maxWidth){
                //System.out.println(strb.length() + " " + strb.lastIndexOf(" "));
                int spaceLength = maxWidth - strb.lastIndexOf(" ") + count - 2;
                //System.out.println(spaceLength);
                int[] nums = new int[count - 2];
                if(count == 2){
                    StringBuilder resultstrb = new StringBuilder();
                    resultstrb.append(words[index]);
                    while(resultstrb.length() != maxWidth){
                        resultstrb.append(' ');
                    }
                    result.add(resultstrb.toString());
                    index += 1;
                    continue;
                }
                int less = spaceLength%(count - 2);
                //System.out.println(less + " " + (count-2));
                int numSpac = spaceLength/(count - 2);
                //System.out.println(numSpac);
                for(int i = 0 ; i < nums.length ; i++) nums[i] = numSpac;
                for(int i = 0 ; i < less ; i++) nums[i] += 1;
                StringBuilder resultstrb = new StringBuilder();
                for(int i = 0 ; i < count - 1 ; i ++){
                    resultstrb.append(words[index+i]);
                    if(i != count - 2){
                        for(int j = 0 ; j < nums[i] ; j++) resultstrb.append(' ');
                    }
                }
                result.add(resultstrb.toString());
                index = index + count - 1;
            } else {
                while(strb.length() != maxWidth){
                    strb.append(' ');
                }
                result.add(strb.toString());
                index += count;
            }
        }
        return result;    
    }
}