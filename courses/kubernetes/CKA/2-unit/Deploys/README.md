### Using deployments

```bash
kubectl create deploy mondeploy --image=nginx:1.17 --replicas=3
kubectl get all --selector app=mondeploy
kubectl scale deployment mondeploy --replicas=4
```

### Running agents with DaemonSets

It runs on each node

### StatefulSets

Stateful application saves session data intoi Persistent storage
StatefulSets are guaranteed an ordering and uniqueness of Pods. Maintain a sticky pod identifier.
StatefulSet is used for applications that require:

- Stable and unique network identifier
- Stable persistent storage
- Ordered, graceful deployment and scaling
- Ordered and automated rolling update

```bash
kubectl get pods -w
kubectl get pvc,pv
```

### Scaling Application

```bash
kubectl scale deploy mondeploy --replicas=1
kubectl get deploy

kubectl autoscale -h | less
kubectl autoscale deployment mondeploy --min=5 --max=10
kubectl get hpa
kubectl get deploy mondeploy -o yaml | less
kubectl edit hpa mondeploy
```

### Configuring Autoscaling

Requirements metric-server Installation:

```bash
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```

```bash
kubectl create deploy webstress --image=nginx
kubectl autoscale deployment webstress --min=2 --max=5 --cpu='75%'
```

```yaml
spec:
  behavior:
    scaleDown:
      stabilizationWindowSeconds: 30
```

Setting downscle globally:

```bash
sudo vim /etc/kubernetes/manifests/kube-controller-manager.yaml
```

```yaml
- --horizontal-pod-autoscaler-downscale-delay=45s
or
- --horizontal-pod-autoscaler-downscale-stabilization=45s
```

### Using Sidecar container for application logging

```bash
kubectl run test --image=busybox --dry-run=client -o yaml  -- sh "echo hello > /tmp/myfile"
```
