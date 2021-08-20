package com.doit.day02

object DemoBinarySearch {
  def main(args: Array[String]): Unit = {
    val res = binarySearch(Array[Int](2, 4, 5, 6, 8, 9), 5)
    println(res)
    val i = f(Array[Int](2, 4, 5, 6, 8, 9), 5)
    println(i)
  }


  def binarySearch(array: Array[Int],target:Int):Int={
    var start=0
    var end = array.length-1
    while (start<=end){
      var mid = (start+end)/2
      if(array(mid)>target){
        end=mid-1
      }else if(array(mid)<target){
        start=mid+1
      }else{
          return mid
      }
    }
    -1
  }

  val f: (Array[Int], Int) => Int = binarySearch _



}
