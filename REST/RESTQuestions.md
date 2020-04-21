# REST

1. What's the difference between GET & POST methods? Which one is usually faster? Why?

```bash
GET method is usually intended for retriving data from the server. It's idempotent (repeating query doesn't have side effects).

POST method is usually intended for changing state of the server. It's not idempotent.

GET is usally faster as it can be cached.
```

2. What are safe method?

```bash
Methods can be ignored or repeated without side effects eg GET and HEAD
```

3. What are idempotent methods?

```bash
Methods that can be repeated without side-effects eg PUT and DELETE
```

4. If I have to update a password in a database, which HTTP request would I use?

```bash
POST request
```

5. What's the difference between POST & PUT request?

6. What's the difference between SOAP and REST? Which one is stateful or stateless ? Which one is usually faster?
