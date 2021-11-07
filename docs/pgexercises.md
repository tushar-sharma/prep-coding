# pgexercises


### [Basic string searches](https://pgexercises.com/questions/basic/where3.html) 


```sql
select facid,
       name,
	   membercost,
	   guestcost,
	   initialoutlay,
	   monthlymaintenance
from cd.facilities 
where name like '%Tennis%';
```


### [Matching against multiple possible values](https://pgexercises.com/questions/basic/where4.html) 


```sql
select facid,
       name,
	   membercost,
	   guestcost,
	   initialoutlay,
	   monthlymaintenance
from cd.facilities 
where facid IN (1, 5);
```

### [Classify results into buckets](https://pgexercises.com/questions/basic/classify.html)


```sql
select name,
 case when (monthlymaintenance > 100) then 
         'expensive'
      else
	     'cheap'
 end as cost
from cd.facilities;

```

### [Working with dates](https://pgexercises.com/questions/basic/date.html)

```sql
select memid,
       surname,
	   firstname, 
	   joindate
from cd.members
where (joindate) > '2012-09-01'
```

### [Removing duplicates, and ordering results](https://pgexercises.com/questions/basic/unique.html)

```sql
select distinct surname
from cd.members
order by surname
limit 10;
```

### [Combining results from multiple queries](https://pgexercises.com/questions/basic/union.html)

```sql
select name as surname
from cd.facilities
union 
select surname 
from cd.members;
``` 

### [Simple aggregation](https://pgexercises.com/questions/basic/agg.html)

```sql 
select joindate as latest from 
cd.members 
order by  joindate desc
```

Similar query

```sql 
select max(joindate) as lateset 
from cd.members;
```

### [More Aggregation](https://pgexercises.com/questions/basic/agg2.html)

```sql
select firstname,
       surname,
	   joindate
from cd.members
where joindate = (select max(joindate) from cd.members)
```