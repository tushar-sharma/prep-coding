## Git Questions

1. How to use token authentication in git? 

```bash
$ git remote set-url origin https://<token>@github.com/<username>/<repo>
$ git config --get remote.origin.url
```

2. How to reset orign/master to a commit ? 

```bash
$ git checkout master
$ git reset --hard commit
$ git push --force origin master
```
