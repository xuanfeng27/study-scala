package com.doit.day04.tt.demos

import java.util.Comparator
import scala.collection.mutable.ListBuffer

object C03_集合的便利API {

  def main(args: Array[String]): Unit = {

    val lst1 = List(1,3,2,8,6,10)

    val lst2 = 5 :: 6 :: 7 :: Nil

    val ints1 = lst1 :+ 20
    val ints2 = 30 +: lst1  // lst1.+:(30)


    println(lst1.max)
    println(lst1.min)
    println(lst1.sum)


    val f: Int=>Boolean = (a:Int)=>{  a % 2 != 0   }
    // 一个函数（方法），如果能接收另一个函数作为参数，则它称之为高阶函数
    // 一个函数（方法），如果是返回另一个函数作为返回值，也称之为高阶函数
    lst1.filter(f)


    lst1.filter( (a:Int) => {  a % 2 == 0   }  )
    lst1.filter( _ % 2 == 0   )


    // sorted 排序
    // Int 类型的 数据有内置的 Ordering[Int] 隐式对象

    val sorted1 = lst1.sorted(new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = x.compareTo(y)
    })

    // 单抽象方法实现的简化写法（不用去new匿名内部类）
    val sorted2 = lst1.sorted( (x: Int, y: Int) =>  y.compare(x)  )
    println(sorted1)



    // 创建一个person的list
    val p1 = new Person("a",18,180)
    val p2 = new Person("c",28,170)
    val p3 = new Person("b",16,180)
    val p4 = new Person("d",28,170)

    val lst3: List[Person] = List(p1,p2,p3,p4)

    // 对lst3中的person对象排序，排序规则：  先按身高降序，再按年龄升序，再按姓名降序


    // 这里之所以不用传Ordering[Person] ，是因为Person实现了Comparable，而Ordering.scala这个代码中有一个隐式方法 ordered[Person]:Ordering[Person]，
    // 可以根据Person类型产生一个 Ordering[Person] ，那么，编译器会帮我填充一段代码： lst3.sorted(ordered[Person])
    // implicit def ordered[A <% Comparable[A]]: Ordering[A]
    val sorted: List[Person] = lst3.sorted


    /*  隐式参数， 可以显式传入

    val sortPersonLst = lst3.sorted(new Ordering[Person] {
      override def compare(x: Person, y: Person): Int = {
        var res = 0
        // 先比身高
        res = y.height.compare(x.height)
        // 如果身高相等
        if(res == 0) {
          // 再比年龄
          res = x.age.compare(y.age)
        }
        // 如果年龄也相等，则再比姓名
        if(res ==0){
          res = x.name.compare(y.name)
        }
        res
      }
    })*/

    // 创建一个Student的list
    val s1 = new Student("a",18,180)
    val s2 = new Student("b",28,170)
    val s3 = new Student("b",16,180)
    val s4 = new Student("a",28,170)

    val lst4: List[Student] = List(s1,s2,s3,s4)

    // implicit def comparatorToOrdering[A](implicit cmp: Comparator[A]): Ordering[A]
    implicit  val cmp = new Comparator[Student] {
      override def compare(o1: Student, o2: Student): Int = o1.height.compare(o2.height)
    }

    lst4.sorted

    // sortBy  根据元素中的某些属性来比大小，排序
    println("-================sort by=====================")
    lst4.sortBy(stu=>stu.age) // 这里不用传Ordering，是因为scala中 Int 可以自动隐式转换成 RichInt，而RichInt混入了Ordered特质
    val term1 = new Term(new Student("张三", 28, 17), Map("班级名称" -> "大数据25期"))
    val term2 = new Term(new Student("郝瑞瑞", 18, 165), Map("班级名称" -> "大数据26期"))
    val term3 = new Term(new Student("郭子琪", 38, 186), Map("班级名称" -> "大数据27期"))
    List(term1,term2,term3).sortBy(term=>term.stu) // 这里不用传Ordering，是因为上文中有一个 Compartor[Student]


    // sortWith，避开了ordering那条线，显式地传入两个元素比大小的逻辑
    lst4.sortWith(  (s1:Student,s2:Student)=>{ s1.height<s2.height }   )


    println("=================== grouped 测试===========================")
    // grouped  ==> List(List(1, 3, 2), List(8, 6, 10), List(4))
    val lst5 = List(1,3,2,8,6,10,4,5)
    val iterator: Iterator[List[Int]] = lst5.grouped(3)
    println(iterator.toList)
    // 对上面的一堆数字，做3个一组的求和

    /* JAVA 风格
     val listBuffer = new ListBuffer[Int]
     for (lst <- lst5.grouped(3)) {
       listBuffer += lst.sum
     }
    */

    // scala 风格
    val sumList: Array[Int] = lst5.grouped(3).map(lst => lst.sum).toArray
    // scala 风格
    val sumIterator: Iterator[Int] = for (lst <- lst5.grouped(3)) yield {lst.sum}


    println("=================group by  测试=================")
    val groupByed: Map[String, List[Student]] = lst4.groupBy((s: Student) => {s.name})
    println(groupByed)
    // Map(
    //      b -> List({b,28,170}, {b,16,180}),
    //      a -> List({a,18,180}, {a,28,170})
    //    )


    println("=================reduce  测试=================")
    val lst6 = List(1,2,3,4,5)
    // 运算过程：  (((1+2)+3)+4)+5
    // reduce其实就是reduceLeft: 从左往右 折叠 聚合
    println(lst6.reduce( (a:Int,b:Int)=>{ a +  b  } ))
    println(lst6.reduce( (a:Int,b:Int)=>{ a - b  } ))
    println(lst6.reduce( (a:Int,b:Int)=>{ 100 } ))  // 结果是？ ？ ？


    // reduceLeft的调用示例（简化写法）   ： 传入的函数中，两个变量， 左边的变量代表折叠结果
    lst6.reduceLeft( _ + _ )


    // reduceRight   ： 传入的函数中，两个变量， 右边的变量代表折叠结果
    println( lst6.reduceRight( (a:Int,b:Int)=>{ a + b }  ) )
    //  1 - (2 - (3 - (4-5) ) )
    println( lst6.reduceRight( (a:Int,b:Int)=>{ a - b }  ) )


  }

}

class Person(val name:String,val age:Int,val height:Int) extends Comparable[Person]{

  override def toString: String = s"$name : $age : $height"

  override def compareTo(that: Person): Int = this.age.compare(that.age)
}

class Student(val name:String,val age:Int,val height:Int){
  override def toString: String = s"{$name,$age,$height}"
}

class Term(val stu:Student,val info:Map[String,String]){}