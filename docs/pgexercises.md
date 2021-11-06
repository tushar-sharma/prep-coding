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
