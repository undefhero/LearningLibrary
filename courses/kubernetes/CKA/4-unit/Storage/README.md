# Storage

### Volume reclaim Policies

Declares what happens if it is no longer bound to PVC

persistentVolumeReclaimPolicy:

- Retain - default. volume will be left in its current phase
- Delete - will be deleted once it is released
- Recycle - PV will recycle back into the pool of unused PVs

### ConfigMap and Secrets as Volumes

```bash
kubectl create cm myconfig --from-file=config.txt
kubectl create cm mydir --from-file=/my/directory/
```
