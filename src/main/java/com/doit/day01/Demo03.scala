package com.doit.day01

object Demo03 {
  def main(args: Array[String]): Unit = {
    for(i<- 1 to 9){
      for (j<- 1 to i){
        //print(j + "*" + i +" = "+ i*j + "\t" )
        print(s"$j * $i = ${i*j} \t")
      }
      println()
    }

    /**
     * 步进
     */
    for (s <- 1 to 10 by 2){
      println(s)
    }

    /**
     * 守卫模式
     */
    for (k <- 1 to 10 if k%2==0 && k>5){
      println(k)
    }

    var flag = true
    for (m <- 1 to 10 if flag){
      if(m>=5){
        flag=false
      }
      println(m)
    }

  }
}
