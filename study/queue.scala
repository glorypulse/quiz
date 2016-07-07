package study

object Queue {
  def create[T] : Queue[T] = {
    new Queue[T]()
  }

  def main(args:Array[String]) {
    val testQueue = Queue.create[String]

    while(true) {
      println("What do you want to push in queue?")
      val in = readLine
      println(s"You wrote '${in}'")
      if (in.equals("pop")) {
        println(s"pop!: ${testQueue.pop}")
      } else {
        testQueue.push(in)
      }
    }
  }
}

class Queue[T] {
  var queue: List[T] = List[T]()
  
  def push(input: T) = {
    queue = queue :+ input
  }

  def pop : Option[T] = {
    if (queue.isEmpty) {return None}
    val pop_val = queue.head
    queue = queue.tail
    Some(pop_val)
  }
}