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
