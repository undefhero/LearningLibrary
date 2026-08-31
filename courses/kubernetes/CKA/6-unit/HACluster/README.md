# CKA Sample Exam 1

[Creating Highly Available Clusters with kubeadm](https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/high-availability/)

```bash
sudo vim /etc/netplan/50-cloud-init.yaml
sudo netplan generate
sudo netplan try

sudo hostnamectl set-hostname control1

hostname
hostnamectl
sudo reboot
```
