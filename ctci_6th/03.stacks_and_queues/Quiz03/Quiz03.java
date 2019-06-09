class Quiz03 {
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks();

        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(10);
        stack.push(123);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
