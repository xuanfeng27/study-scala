package com.doit.doitedu.demos

object C09_科里化 {

  def main(args: Array[String]): Unit = {

    println("============= 类型推断  ===================")

    def findElement1[A](xs: List[A], predicate: A => Boolean): Option[A] = {
      xs match {
        case Nil => None
        case head :: tail => if (predicate(head)) Some(head) else findElement1(tail, predicate)
      }
    }

    val lst1 = List(1, 2, 4, 3)
    val res1 = findElement1(lst1, (n: Int) => {
      n % 2 == 0
    })
    println(res1)


    def findElement2[A](xs: List[A])(predicate: A => Boolean): Option[A] = {
      xs match {
        case Nil => None
        case head :: tail => if (predicate(head)) Some(head) else findElement2(tail)(predicate)
      }
    }


    val lst2 = List(1, 2, 4, 3)

    // findElements2 ，可以自动推断第二个参数的类型
    val res2 = findElement2(lst2)(x => x % 2 == 0)
    println(res2)


    println("============= 减少参数  ===================")
    val addSalary = (incBase: Int, salary: Int) => {
      incBase + salary
    }

    addSalary(10, 50)
    addSalary(10, 60)
    addSalary(10, 80)

    val addSalary2 = (incBase: Int) => (salary: Int) => {
      incBase + salary
    }
    val add: Int => Int = addSalary2(10)
    add(50)
    add(60)


    println("============= 更灵活  ===================")

    def sumF(f: Int => Int, x: Int, y: Int): Int = {
      f(x) + f(y)
    }

    // 求和
    val sum: Int = sumF((x: Int) => x, 10, 20)
    println(sum)

    // 求平方和
    println("==============平方和 =================")
    println(sumF(x => x * x, 10, 20))
    println(sumF(x => x * x, 2, 4))

    // method 手动 科里化
    val sumFCurrying: (Int => Int) => Int => Int => Int = (sumF _).curried

    val sum2 = sumFCurrying(identity)
    println(sum2(10)(20))
    println(sum2(5)(10))


    val squareSum = sumFCurrying(x => x * x)
    println(squareSum(10)(20))
    println(squareSum(2)(4))
    println(squareSum(5)(56))

    val inc = sum2(1)
    println(inc(6))
    println(inc(7))


  }
}
