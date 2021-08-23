package com.doit.doitedu.exercise

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}

object SparkDemo {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .appName("wordcount")
      .master("local")
      .getOrCreate()


    val rdd = spark.read.textFile("d:/word.txt").rdd

    val res: RDD[(String, Int)] = rdd.flatMap(s => s.split(" ")).map(s => (s, 1)).reduceByKey((a, b) => a + b)
    res.foreach(println)

    spark.close()


  }

}
