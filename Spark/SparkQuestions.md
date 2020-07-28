# SPARK Questions

## How to run spark application?

```bash
$ sbt compile
$ sbt package
$ spark-submit --classNames <Name> <Jar>.jar
```

## Notes

[Notes 1](https://drive.google.com/open?id=13cvqV6X41p_h9Bea-fNa0CAtcteuWr2d)

## Duplicate a column in spark dataframe & rename it (Scala)

```scala
df = df.withColumn("duplicate_column", df.col("current_column"))
```
