## SQL

### Groupby

Use groupby with aggregate column

```sql
select count(id), country
from Customers
group by country
order by country desc
```

### Extract month and year

#### PostgreSQL 

```sql
select extract(month from starttime) , extract(year from starttime)
from table
```
