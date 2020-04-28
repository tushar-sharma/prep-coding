# Database

1. What's the output?

```sql
create table Person(fname varchar(20), id integer);

insert into Person values('Tom', 1);
insert into Person values('Sam', 2);
insert into Person values('Tom', 3);

select fname
from Person
where count(*) <> 1
```

```bash
The query is wrong. Can't use aggregate function with where clause
```

2. What's the difference between self join & cross join?

3. What's an index?

```bash
Index are data structure that provides quick lookup of data in a column or columns of a table.

CREATE INDEX  INDEX_NAME
ON table_name(column1, column2);

```

4. What's the difference between clusterd and non-clustered index? Which one is faster?

```bash
Clustered index are indexes whose order of rows in database correspond to the order of rows in index. It modifies the way records are stored in the database.

Non-clustered index creates a separate entity witin table which references original table.
```

5. Can more than one clustered index exist on a given table?

```bash
No
```

6. What's a view? How's different than materialized view?

View is simply a select query that is saved in database.

```bash
CREATE OR REPLACE VIEW <view_name> as
SELECT ...

```

View query is saved in database but is not run until called. Hence it does not take any space in database. It's also used for restricting access.

A materialized view does create & store result in disk. It has to be re-run when change of the data in the table.

[More Info](https://drive.google.com/open?id=1Rjs3Z38rMKLUpzfOWuc_w2DUTdbCLVmY)


7. What's a trigger?
