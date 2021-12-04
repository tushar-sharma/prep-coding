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

### [Retrieve the start times of members' bookings](https://pgexercises.com/questions/joins/simplejoin.html)

```sql
select t2.starttime
from cd.bookings as t2
INNER JOIN cd.members as t1
ON t1.memid = t2.memid
where t1.firstname = 'David' and  t1.surname = 'Farrell'
```

### [Work out the start times of bookings for tennis courts](https://pgexercises.com/questions/joins/simplejoin2.html)

```sql
select t1.starttime as start,
       t2.name
from cd.bookings as t1
INNER JOIN cd.facilities as t2
ON t1.facid = t2.facid
where t2.name like 'Tennis Court%'
and date(t1.starttime) =  '2012-09-21'
order by t1.starttime
```


### [Produce a list of all members who have recommended another member](https://pgexercises.com/questions/joins/self.html)

```sql
select firstname, surname
from cd.members t2
where memid IN (select distinct recommendedby
from cd.members  t1)
order by surname, firstname
```

### [Produce a list of all members, along with their recommender](https://pgexercises.com/questions/joins/self2.html)

```sql
select t1.firstname as memfname,
       t1.surname as memsname,
       t2.firstname as recfname,
       t2.surname as recsname
from cd.members t1
left outer join cd.members t2
on t1.recommendedby = t2.memid
order by memsname, memfname

```

### [Produce a list of all members who have used a tennis court](https://pgexercises.com/questions/joins/threejoin.html)

```sql
select distinct t3.firstname || ' ' || t3.surname as member,
      t4.name as facility
from cd.members t3
inner join (select t1.memid,
       t2.name
from cd.bookings t1
inner join (select facid, name
from cd.facilities
where name like 'Tennis%') t2
on t1.facid = t2.facid) t4
on t4.memid = t3.memid
order by member, facility
```
