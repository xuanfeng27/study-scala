package com.doit.day05.tt.doitedu.exercise

object 函数简化 {

  def main(args: Array[String]): Unit = {

    def myf(a:String,b:String,c:String,f:(Int,Int,Int)=>Int)={
      val i1: Int = a.toInt
      val i2: Int = b.toInt
      val i3: Int = c.toInt
      f(i1,i2,i3)
    }

    val f11 = (x:Int,y:Int,z:Int)=>{
      var max = x
      if(y>max) max = y
      if(z>max) max = z
      max
    }

    val f12 = (x:Int,y:Int,z:Int) => {
      Array(x, y, z).max
    }

    val f13  : (Int,Int,Int)=>Int   =  Array(_, _, _).max


    // 调用一下上面的方法，实现对3个数求最大值
    myf("20","40","25",f11)
    myf("20","40","25",f12)
    myf("20","40","25",f13)

    myf("20","40","25",(a:Int,b:Int,c:Int)=>{ Array(a,b,c).max } )
    myf("20","40","25",(a,b,c)=>{ Array(a,b,c).max } )
    myf("20","40","25",(a,b,c)=> Array(a,b,c).max  )
    myf("20","40","25", Array(_,_,_).max )


    // 调用一下上面的方法，实现对3个数求最小值
    myf("20","40","25", Array(_,_,_).min )

    // 调用一下上面的方法，实现对3个数和
    myf("20","40","25", Array(_,_,_).sum )
    myf("20","40","25", _+_+_ )


  }

}
