class Solution {
    public String simplifyPath(String path) {
        //parse string to initial tokens
        String[] vals = path.split("/");
        //start iterating on path segments using stack to store results. Most tokens we can simply ignore
        Stack<String> s = new Stack();
        for (String p : vals) {
            //these cases refer to current dir and multiple "/"
            if (p.length() == 0 || p.equals("."))
                continue;
            //in case we have to go back - just pop from stack
            else if (p.equals("..")) {
                if (!s.isEmpty())
                    s.pop();
            }
            //all other cases - push to stack
            else
                s.push(p);
        }
        //no build the final path string
        String res = "";
        while (!s.isEmpty()) {
            res = "/" + s.pop() + res;
        }
        //in case we haven't met any path segments - return just root folder
        return res.length() == 0 ? "/" : res;
    }
}