public class Solution {
    public String simplifyPath(String path) {
        if(path==null || path.length()==0){
            return path;
        }
        Stack<String> stack = new Stack<>();
        
        for(String s : path.split("/")){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!(s.equals("")||s.equals("."))){
                stack.push(s);
            }
        }
        
        StringBuilder sb =  new StringBuilder("/");
        
        for(String s : stack){
            sb.append(s);
            sb.append("/");
        }
        
        if(!stack.isEmpty()){
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}