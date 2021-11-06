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