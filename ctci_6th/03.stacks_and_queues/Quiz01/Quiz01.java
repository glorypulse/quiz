class Quiz01 {
    public static void main(String[] args) {
        MyStack stack1 = new MyStack(MyStack.StackNumber.Stack1);
        MyStack stack2 = new MyStack(MyStack.StackNumber.Stack2);
        MyStack stack3 = new MyStack(MyStack.StackNumber.Stack3);

        stack1.push("aaa");
        stack1.push("aaa2");
        stack1.push("aaa3");
        stack2.push("bbb");
        stack3.push("ccc");
        System.out.println(stack1.pop());
        System.out.println(stack2.pop());
        stack1.push("aaa4");
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }
}
