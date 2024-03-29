# SPARK Questions

## Resources

1. [How to run a spark applicatoin](https://drive.google.com/file/d/1IUwQwdMQWlSZBG9ga402sDBLSzbu3Jg5/view?usp=sharing)

## Notes

[Notes 1](https://drive.google.com/open?id=13cvqV6X41p_h9Bea-fNa0CAtcteuWr2d)

## Limitation of Hadoop MapReduce

1. Data is flushed to disk after each iteration

## Architecture of a Spark Job

1. In Memory computation
2. **Driver program**. Your application
3. **Context**. SparkContext or
sqlContext. Your handle to your
Spark cluster.
4. **Worker program**. What runs on
cluster nodes.
5. Executor**. What actually does the
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

1. **map**: It returns a new RDD by applying a function to each element of the RDD. Function in .map can return only one item.
2. **flatMap**: Similar to map, it returns a new RDD by applying a function to each element of the RDD, but the output is flattened.


## Cache vs Perist

Both caching and persisting are used to save the Spark RDD, Dataframe, and Dataset’s. But, the difference is, RDD cache() method default saves it to memory (MEMORY_ONLY) whereas persist() method is used to store it to the user-defined storage level

## repartition() vs coalesce()

The repartition algorithm does a full shuffle of the data and creates equal sized partitions of data. Change the number of partitions. 

Coalesce combines existing partitions to avoid a full shuffle. Merge partitions. 

## Groupbykey vs Reducebykey


Both produce the same results.
groupByKey shuffles the entire dataset across the network based on the key, while ReduceByKey will compute local sums for each key in each partition and combine those local sums into larger sums after shuffling.

Avoid groupbykey,  calling groupByKey - all the key-value pairs are shuffled around. This is a lot of unnessary data to being transferred over the network.

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

## Joins

```scala
// common dataframes
val df1 = Seq((0, "zero"), (1, "one"), (3, "three")).toDF("id", "df1")
val df2 = Seq((0, "zero"), (1, "two"), (3, "four")).toDF("id", "df2")
```
### Inner Join
```
df1.join(df2, "id").show

+---+----+----+
| id| df1| df2|
+---+----+----+
|  0|zero|zero|
|  1| one| two|
+---+----+----+

```
### Full Outer

```scala
df1.join(df2, Seq("id"), "fullouter").show

+---+-----+----+
| id|  df1| df2|
+---+-----+----+
|  1|  one| two|
|  3|three|null|
|  4| null|four|
|  0| zero|zero|
+---+-----+----+
```

### Left Semi join

Returns only the data from the left side that has a match on the right side based on the condition provided for the join statement. It is essentially a filter on the left table based on the join condition:


```scala
df1.join(df2, Seq("id"), "leftsemi").show

+---+----+
| id| df1|
+---+----+
|  0|zero|
|  1| one|
+---+----+
```

### Left-anti-Join

Returns only the data from the left side that doesnot have match on the right side based on the condition provided for the join statement.

```scala
df1.join(df2, Seq("id"), "leftanti").show

+---+-----+
| id|  df1|
+---+-----+
|  3|three|
+---+-----+
```

## AWS Glue

### Convert dataframe to Dynamic Frame
```scala
import com.amazonaws.services.glue.DynamicFrame

val dynamicFrame = DynamicFrame(df, glueContext)
```

### Crawler

It's used to populate metadata about the table in the AWS Glue Data Catalog.


