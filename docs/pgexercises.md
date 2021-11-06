# pgexercises


### [where3](https://pgexercises.com/questions/basic/where3.html) 


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


### [where4](https://pgexercises.com/questions/basic/where4.html) 


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

### [classify](https://pgexercises.com/questions/basic/classify.html)


```sql
select name,
 case when (monthlymaintenance > 100) then 
         'expensive'
      else
	     'cheap'
 end as cost
from cd.facilities;

```

### [date](https://pgexercises.com/questions/basic/date.html)

```sql
select memid,
       surname,
	   firstname, 
	   joindate
from cd.members
where (joindate) > '2012-09-01'
```

### [unique](https://pgexercises.com/questions/basic/unique.html)

```sql
select distinct surname
from cd.members
order by surname
limit 10;
```

### [union](https://pgexercises.com/questions/basic/union.html)

```sql
select name as surname
from cd.facilities
union 
select surname 
from cd.members;
``` 