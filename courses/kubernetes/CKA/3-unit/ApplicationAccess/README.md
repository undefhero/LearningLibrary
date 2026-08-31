# Networking

### Network plugins

```bash
kubectl get crd
kubectl get ippools -A -o yaml | less
ps aux | grep service-cluster-ip-range
```

### Configuring Services

ClusterIP: the Service internally exposed (can be reached only within the cluster)
NodePort: the Service is exposed at each node's IP address as a port. Can be reached externally
LoadBalancer: the cloud provider offers a LB that routes traffic to NodePort or ClusterIP
ExternalName: the Service mapped to an external name (implemented as DNS CNAME record)

```bash
kubectl expose # recommended
kubectl create service
```

Example:

```bash
kubectl create deploy webshop --image=nginx --replicas=3
kubectl get pods --selector app=webshop -o wide
kubectl expose deploy webshop --type=NodePort --port=80
kubectl describe svc webshop
kubectl get svc
curl <node-ip>:<node-port>
```

### Ingress

```bash
helm upgrade --install ingress-nginx ingress-nginx --repo https://kubernetes.github.io/ingress-nginx --namespace ingress-nginx --create-namespace
kubectl get pods -n ingress-nginx
kubectl create deploy nginxsvc --image=nginx --port=80
kubectl expose deploy nginxsvc

kubectl create ingress nginxsvc --class=nginx --rule='nginxsvc.info/*=nginxsvc:80'
kubectl port-forward -n ingress-nginx svc/ingress-nginx-controller 8080:80
echo "127.0.0.1 nginxsvc.info" | sudo tee -a /etc/hosts
curl nginxsvc.info:8080
```

### Gateway API

```bash
helm list -n ingress-nginx
helm delete ingress-nginx -n ingress-nginx
```

### Using Gateway API to Provide Access to Applications

```bash
kubectl kustomize "https://github.com/nginxinc/nginx-gateway-fabric/config/crd/gateway-api/standard?ref=v1.5.1" | kubectl apply -f -
helm install ngf oci://ghcr.io/nginxinc/charts/nginx-gateway-fabric --create-namespace -n nginx-gateway
kubectl get pods,svc -n nginx-gateway
kubectl get gc
```

### TLS Access

```bash
openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout tls.key -out tls.crt -subj "/CN=whatever.com"
kubectl create secret tls gateway-tls --cert=tls.crt --key=tls.key
kubectl apply -f tls-gateway.yaml
kubectl apply -f https-routing.yaml
sudo apt install socat
sudo socat TCP4-LISTEN:80,fork TCP4:127.0.0.1:32080 &
sudo socat TCP4-LISTEN:443,fork TCP4:127.0.0.1:32443 &
curl -k https://whatever.com
```
