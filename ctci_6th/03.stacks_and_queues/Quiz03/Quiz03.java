class Quiz03 {
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks();

        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(8);
        stack.push(77);
        stack.push(11);
        stack.push(6);
        stack.push(9);
        stack.push(67);
        stack.push(31);
        System.out.println(stack.popAt(7));
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
