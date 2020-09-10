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

## AWS Glue

### Convert dataframe to Dynamic Frame
```scala
val dynamicFrame = DynamicFrame(df, glueContext)
```
