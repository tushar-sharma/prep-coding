# pgexercises


## where3 

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


## where 4

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