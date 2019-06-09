class Quiz02 {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.push(7);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
