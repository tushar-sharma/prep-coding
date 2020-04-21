# Github Actions

1. How do you access files in the repo where actions is executed?

Using checkout like

```bash
- name: Checkout
  uses: actions/checkout@v2
```

2. Checkout different branch?

```bash
- name: Checkout
  uses: actions/checkout@v2
  with:
    ref: my-branch
```

3. Create an ECR repository to store your images?

```bash
aws ecr create-repository --repository-name my-ecr-repo --region us-east-2
```

4. Create an ECR repo with tags?


```bash
aws ecr create-repository --repository-name my-ecr-repo --tag Key=string,Value=string --region us-east-2
```

5. Create an ECR repository with immutable tags?

```bash
aws ecr create-repository --repository-name my-ecr-repo --image-tag-mutability IMMUTABLE --region us-east-2
```
