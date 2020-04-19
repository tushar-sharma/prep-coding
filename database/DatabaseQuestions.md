# Database

## What's the output?

```sql
create table Person(fname varchar(20), id integer);

insert into Person values('Tom', 1);
insert into Person values('Sam', 2);
insert into Person values('Tom', 3);

select fname
from Person
where count(*) <> 1
```
