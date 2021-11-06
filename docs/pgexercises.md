# pgexercises


## [where3](https://pgexercises.com/questions/basic/where3.html) 

How can you produce a list of all facilities with the word 'Tennis' in their name?


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


## [where4](https://pgexercises.com/questions/basic/where4.html) 

How can you retrieve the details of facilities with ID 1 and 5? Try to do it without using the OR operator.


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

## [classify](https://pgexercises.com/questions/basic/classify.html)

How can you produce a list of facilities, with each labelled as 'cheap' or 'expensive' depending on if their monthly maintenance cost is more than $100? Return the name and monthly maintenance of the facilities in question.


```sql
select name,
 case when (monthlymaintenance > 100) then 
         'expensive'
      else
	     'cheap'
 end as cost
from cd.facilities;

```