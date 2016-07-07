package study

object Stack {
  def create[T]: Stack[T] = {
    new Stack[T]()    
  }

  def main(args: Array[String]) = {
    val testStack = Stack.create[String]
    while(true) {
      println("What do you want to push in Stack?")
      val in = readLine
      if (in.equals("pop")) {
        println(testStack.pop)
      } else {
        testStack.push(in)
      }
    }
    
  }
}

class Stack[T] {
  private var stack : List[T] = List[T]()

  def push(input: T) {
    stack = input :: stack
  }

  def pop : T = {
    val pop_val = stack.head
    stack = stack.tail
    pop_val
  }

}