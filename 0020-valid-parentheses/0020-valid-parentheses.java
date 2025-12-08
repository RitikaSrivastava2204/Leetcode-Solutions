class Solution {

    public boolean isValid(String s) {
        boolean flag = false;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() != true) {
                        char top = stack.pop();
                        if (top == '(' && ch == ')') {
                            flag = true;
                        } else if (top == '[' && ch == ']') {
                            flag = true;
                        } else if (top == '{' && ch == '}') {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    else{
                        flag = false;
                        
                    }
                    

                }

            }

        }
        if(stack.isEmpty() && flag){
            return true;
        }
        else{
            return false;
        }


    }
}