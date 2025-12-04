class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        
        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                // Always push 'R' to track it
                stack.push('R');
            } 
            else if (c == 'S') {
                // If we hit an 'S', any 'R's currently on the stack will crash into it
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    count++;
                }
                // Push 'S' so future cars know there is a wall here
                stack.push('S');
            } 
            else if (c == 'L') {
                if (!stack.isEmpty() && stack.peek() == 'S') {
                    // L hits Wall
                    count++; 
                } else if (!stack.isEmpty() && stack.peek() == 'R') {
                    // L hits R -> becomes 2 Stationary cars
                    stack.pop();
                    count += 2; // R + L collision
                    
                    // Crucial: The collision creates a pile-up (S).
                    // We must check if previous R's now crash into this new pile.
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        stack.pop();
                        count++;
                    }
                    stack.push('S'); // Mark this spot as a wall
                }
                // If stack is empty, L drives away safely (do nothing)
            }
        }
        return count;
    }
}