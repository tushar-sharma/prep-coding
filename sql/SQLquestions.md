## SQL

### Groupby

Use groupby with aggregate column

```sql
select count(id), country
from Customers
group by country
order by country desc
```
