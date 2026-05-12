# ☁️ Cloud Infrastructure - Helm Charts for Kubernetes

This directory contains all cloud and Kubernetes-related infrastructure as code, including Helm charts for deploying the Real Doctors and Patients application to Kubernetes clusters (Minikube, EKS, GKE, etc.).

## 📁 Directory Structure

```
cloud/
└── helm/                           # Helm charts for Kubernetes deployment
    ├── README.md                   # Comprehensive Helm documentation
    ├── TESTING.md                  # Testing and troubleshooting guide
    ├── deploy.sh                   # Deploy to Minikube
    ├── undeploy.sh                 # Remove deployment
    ├── status.sh                   # Check deployment status
    ├── port-forward.sh             # Access services locally
    ├── values-minikube.yaml        # Example custom values
    │
    └── real-doctors-patients/      # Main Helm chart
        ├── Chart.yaml              # Chart metadata
        ├── values.yaml             # Configuration (234 lines)
        ├── README.md               # Chart-specific docs
        └── templates/              # 23 Kubernetes YAML templates
            ├── app-*.yaml          # Application
            ├── postgres-*.yaml     # Database
            ├── kafka-*.yaml        # Message broker
            ├── keycloak-*.yaml     # Identity management
            ├── zookeeper-*.yaml    # Coordination
            ├── localstack-*.yaml   # Cloud storage
            └── namespace.yaml      # Infrastructure
```

## 🚀 Quick Start

### 1. Navigate to Cloud Directory
```bash
cd cloud/helm
```

### 2. Start Minikube
```bash
minikube start --cpus=4 --memory=8192 --disk-size=30GB
```

### 3. Deploy Helm Chart
```bash
./deploy.sh
```

### 4. Access Services
```bash
./port-forward.sh
# Then open: http://localhost:9090
```

## 📚 Documentation

- **helm/README.md** - Comprehensive guide to the Helm chart
- **helm/TESTING.md** - Troubleshooting and testing procedures
- **helm/real-doctors-patients/README.md** - Chart-specific documentation

## 🛠️ Available Scripts

| Script | Purpose |
|--------|---------|
| `helm/deploy.sh` | Deploy chart to Minikube |
| `helm/undeploy.sh` | Remove deployment |
| `helm/status.sh` | Check deployment status |
| `helm/port-forward.sh` | Local service access |

## 🎯 Services Deployed

- Real Doctors Patients App (Port 9090)
- PostgreSQL Database
- Keycloak Identity Management (Port 8080)
- Kafka Message Broker
- Zookeeper Coordination
- LocalStack S3 Mock
- Kafka UI Dashboard (Port 8081)

## 🔧 Configuration

All settings are in: `helm/real-doctors-patients/values.yaml`

Customize:
- Database credentials
- Keycloak admin password
- Image tags
- Resource limits
- Replica counts

## 🎓 Requirements

- Docker Desktop or Docker Engine
- Minikube 1.20+
- kubectl
- Helm 3+

## 📖 Next Steps

1. Read: `helm/README.md`
2. Review: `helm/real-doctors-patients/values.yaml`
3. Deploy: `./helm/deploy.sh`
4. Access: `./helm/port-forward.sh`

---

**For detailed instructions, start with the main documentation at the project root:**
- `GETTING_STARTED_HELM.md`
- `HELM_QUICKSTART.md`

