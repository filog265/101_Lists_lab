class Node(var item: String, var next: Node = null) {

}

class LinkedList(var head: Node = null) {

  def addToStart(s: String): Unit ={
    head = new Node(s, head)
  }

  def getSize(): Int ={
    if(head == null) return 0

    var count = 0
    var c = head

    while(c != null){
      c = c.next
      count += 1
    }
    count
  }

  override def toString(): String ={
    var res = s"List content (size ${getSize()}) : "
    var c = head
    while(c != null){
      res += c.item
      res += " -> "
      c = c.next
    }
    res += "null"
    res
  }

  def removeFirstElement(): Unit ={
    if (head == null) println("Your list is already empty!")
    else head = head.next
  }

  def getLastElement(): Node ={
    if (head == null) return head
    var c = head
    while(c.next != null){
      c = c.next
    }
    c
  }

  def addToEnd(s: String): Unit ={
    if (head == null) addToStart(s)
    else {
      val last = getLastElement()
      last.next = new Node(s)
    }
  }

  def isPresent(e: String): Boolean ={
    if (head == null) return false
    var c = head
    while (c != null){
      if (c.item == e) return true
      else c = c.next
    }
    false
  }

  def findElement(s: String): Node ={
    if (head == null) return null
    var c = head
    while (c != null){
      if (c.item == s) return c
      else c = c.next
    }
    null
  }

  def swapElements(e1: String, e2: String): Unit ={
    if (head == null) println("Your list is empty!")
    if (findElement(e1) == null || findElement(e2) == null) println("At least one node is missing from your list!")
    var c = head
    while (c != null){
      if (c.item == e1){
        c.item = e2
        c = c.next
      }
      else if (c.item == e2){
        c.item = e1
        c = c.next
      }
      else c = c.next
    }
  }

  def removeLastElement(): Unit ={
    if (head == null) return println("Your list is empty!")
    var c = head
    while (c != null){
      if (c == getLastElement()){
        removeFirstElement()
        c = null
      }
      else if (c.next == getLastElement()){
        c.next = null
        c = null
      }
      else c = c.next
    }
  }

  def removeElement(e: String): Unit ={
    var c = head
    if (!isPresent(e)) println("This node is not in your list!")
    else if (head.item == e) removeFirstElement()
    else if (getLastElement().item == e) removeLastElement()
    else{
      while (c != null){
        if (c.next.item == e){
          c.next = c.next.next
          c = null
        }
        else c = c.next
      }
    }
  }

  def insertAfter(before: String, after: String): Unit ={
    var c = head
    if (!isPresent(before)) println("This node is not in your list!")
    else if (getLastElement().item == before) addToEnd(after)
    else{
      while (c != null){
        if (c.item == before){
          val a = new Node(after, c.next)
          c.next = a
          c = null
        }
        else c = c.next
      }
    }
  }
}

object task3 extends App {
  var flightList:LinkedList = new LinkedList()
  println(flightList)

  flightList.addToStart("Rome")
  println(flightList)

  flightList.addToStart("Paris")
  println(flightList)

  flightList.addToStart("Tokyo")
  println(flightList)

  flightList.removeFirstElement()
  println(flightList)

  println(flightList.getLastElement().item)

  flightList.addToEnd("Milan")
  println(flightList)

  println(flightList.getLastElement().item)

  println(flightList.isPresent("Rome"))
  println(flightList.isPresent("Bern"))

  println(flightList.findElement("Paris").item)
  println(flightList.findElement("Dublin"))

  println(flightList)
  flightList.swapElements("Paris", "Milan")
  println(flightList)

  flightList.insertAfter("Milan", "Genève")
  println(flightList)
}