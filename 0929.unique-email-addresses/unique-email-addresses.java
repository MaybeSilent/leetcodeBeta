class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> mailSet = new HashSet<String>();
        for(String mailaddr : emails){
            mailSet.add(getMail(mailaddr));
        }
        
        return mailSet.size();
    }
    private String getMail(String mailaddr){
        StringBuilder strb = new StringBuilder();
        boolean added = false;
        for(int i = 0 ; i < mailaddr.length() ; i ++){
            if(mailaddr.charAt(i) == '.') continue;
            if(mailaddr.charAt(i) == '+') added = true;
            if(mailaddr.charAt(i) == '@'){
                return strb.toString() + mailaddr.substring(i);
            }
            if(!added) strb.append(mailaddr.charAt(i));
        }
        return null;
    }
}