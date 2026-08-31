### Running static pod

```bash
kubectl run mypod --image=nginx --dry-run=client -o yaml
```

### Create a deploy from command line

```bash
kubectl create deploy before --image=nginx --replicas=3
```

`/etc/kubernetes/manifests/mypod.yaml`

### Node maintenance

```bash
kubectl cordon # marks node unschedulable
kubectl drain # marks node unschedulable and remove all running Pods from it except DaemonSet Pods
# (--ignore-daemonsets)
# --delete-emptydir-data
kubectl uncordon
```

### etcd backup

```bash
sudo etcdctl --endpoints=localhost:2379 --cacert /etc/kubernetes/pki/etcd/ca.crt --cert /etc/kubernetes/pki/etcd/server.crt  --key /etc/kubernetes/pki/etcd/server.key snapshot save /tmp/etcdbackup.db

sudo etcdctl --write-out=table snapshot status /tmp/etcdbackup.db
```

### restore etcd backup

```bash

```
