### Helm

[https://artifacthub.io/](https://artifacthub.io/)

```bash
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo list
helm search repo bitnami
helm search repo nginx --versions
```

```bash
helm install bitnami/mysql --generate-name
kubectl get all

helm show chart bitnami/mysql
helm show all bitnami/mysql
helm list --all-namespaces
helm status mysql-1785935134
```

### Creating a template from a Helm Chart
