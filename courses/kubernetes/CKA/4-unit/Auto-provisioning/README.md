# Auto-provisioning Storage

### StorageClass

```bash
kubectl patch storageclass mysc -p '{"metadata":{"annotations":{"storageclass.kubernetes.io/is-default-class":"true"}}}'
```

### NFS

```bash
sudo apt install nfs-server -y
sudo mkdir /nfsexport
sudo sh -c 'echo "/nfsexport *(rw,no_root_squash)" > /etc/exports'
cat /etc/exports
sudo systemctl restart nfs-server

sudo apt install nfs-client -y
showmount -e <NFS_SERVER_IP>
```

```bash
helm repo add nfs-subdir-external-provisioner https://kubernetes-sigs.github.io/nfs-subdir-external-provisioner/
helm install nfs-subdir-external-provisioner nfs-subdir-external-provisioner/nfs-subdir-external-provisioner \
    --set nfs.server=192.168.8.50 \
    --set nfs.path=/nfsexport
```

```bash
kubectl get storageclass
kubectl describe storageclasses.storage.k8s.io nfs-client
```
