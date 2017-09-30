package com.project;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

/**
 * Created by yohoos on 6/2/17.
 */
public class SparkTester {

    @Test
    public void stuff() {
        SparkSession spark = SparkSession
                .builder()
                .master("local[*]")
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        Dataset<Row> df = spark.read()
                .option("header", true)
                .csv("/home/yohoos/Downloads/FL_insurance_sample/FL_insurance_sample.csv");

        df = df.filter(new Column("hu_site_deductible").gt(0));
        df.show();

        df.printSchema();
        System.out.println();
    }
}
