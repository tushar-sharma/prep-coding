# SPARK Questions

## Resources

1. [How to run a spark applicatoin](https://drive.google.com/file/d/1IUwQwdMQWlSZBG9ga402sDBLSzbu3Jg5/view?usp=sharing)

## Notes

[Notes 1](https://drive.google.com/open?id=13cvqV6X41p_h9Bea-fNa0CAtcteuWr2d)

## Duplicate a column in spark dataframe & rename it (Scala)

```scala
df = df.withColumn("duplicate_column", df.col("current_column"))
```
### create empty dataframe without schema

```scala
val df = spark.emptyDataFrame
```
### Add new column to dataframe

```scala
val data = Seq(("111",50000),("222",60000),("333",40000))
val df = data.toDF("EmpId","Salary")
```

## AWS Glue

### Convert dataframe to Dynamic Frame
```scala
import com.amazonaws.services.glue.DynamicFrame

val dynamicFrame = DynamicFrame(df, glueContext)
```

### Crawler

It's used to populate metadata about the table in the AWS Glue Data Catalog.

