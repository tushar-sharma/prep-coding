# SPARK Questions

## Resources

1. [How to run a spark applicatoin](https://drive.google.com/file/d/1IUwQwdMQWlSZBG9ga402sDBLSzbu3Jg5/view?usp=sharing)

## Notes

[Notes 1](https://drive.google.com/open?id=13cvqV6X41p_h9Bea-fNa0CAtcteuWr2d)

## Architecture of a Spark Job

1. **Driver program**. Your application 
2. **Context**. SparkContext or
sqlContext. Your handle to your
Spark cluster.
3. **Worker program**. What runs on
cluster nodes.
4. **Executor**. What actually does the
work on each cluster node.

## Three API of Spark

1. **(Resilient Distributed Datasets**):  is a collection of records with distributed computing, which are fault tolerant, immutable in nature. 
2. **DataFrames**: SQL-like structured datasets with query operations.
3. **Datasets**: mixture of RDDs and DataFrames in terms of the
operations that are available on them.

## Operations on RDD

1. **Transformation**: Return new RDDs as a result.They are lazy, their result RDD is not immediately computed.
2. **Actions**. Compute a result based on an RDD, and either returned
or saved to an external storage system (e.g., HDFS). They are eager, their result is immediately computed.

## Transformation example

1. **map** 
2. **filter**
3. **distinct**
4. **flatmap**


## Actions example

1. **reduce**
2. **take**
3. **collect**

## Broadcast variable

They are read-only shared variable which are cached on each worker nodes of Spark cluster.

## Broadast variable Use case

If we use an operation that causes a reshuffle (for example, join, groupby, or repartition), and we use the variable before and after that operation.

 When we join a huge DataFrame with a relatively tiny DataFrame,  we can speed up the join by using the broadcast join.

```scala
from pyspark.sql.functions import broadcast

data_frame.join(
    broadcast(lookup_data_frame),
    lookup_data_frame.key_column==data_frame.key_column
)
```

## Differnce between map and flatmap 

## Cache vs Perist

Both caching and persisting are used to save the Spark RDD, Dataframe, and Dataset’s. But, the difference is, RDD cache() method default saves it to memory (MEMORY_ONLY) whereas persist() method is used to store it to the user-defined storage level

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


