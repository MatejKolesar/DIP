# Project Overview

This project is a Java Spring Boot application that provides a comprehensive solution for managing users, files, notifications, and billing in a cloud-based environment. The system includes features such as user authentication, role-based access control, file storage and retrieval, notification management, and billing management. Additionally, the system tracks metadata associated with files, such as creation date, modification date, and file size, to help users manage their data more effectively.

## Features

- User authentication and role-based access control
- File storage and retrieval
- Notification management
- Billing management
- File metadata tracking

## Prerequisites

- Kubectl
- Helm

### Optional - only needed if you want to compile from scratch
- Java 11 or higher
- Spring Boot framework
- Spring Data JPA


## Deployment on local
This guide will walk you through the process of setting up an a local environment. On local environment there is no security that is inherently present on AWS.

## Prerequisites

Before you can deploy a Kubernetes application, you'll need to have the following prerequisites installed on your local machine:

- Docker
- Kubernetes CLI (kubectl)
- Minikube (or a similar Kubernetes distribution)
- A containerized application (Docker image) that you want to deploy

## Step 1: Start a Kubernetes Cluster

The first step to deploying a Kubernetes application locally is to start a Kubernetes cluster. To do this, you can use a tool like Minikube, which allows you to create a single-node Kubernetes cluster on your local machine. To start a new cluster with Minikube, run the following command in your terminal:

`#minikube start`


## Step 2: Start a Kubernetes Cluster
1. Clone the sample application repository from Github.
2. Open the Kubernetes deployment YAML file and update the variables with your AmazonMQ broker and S3 bucket information.
3. Ensure that you can access the EKS cluster from the terminal.
4. Deploy the sample application to your EKS cluster using `kubectl apply`.


## Deployment on AWS

This guide will walk you through the process of setting up an Elastic Kubernetes Service (EKS) cluster with AmazonMQ and S3. 

### Prerequisites

Before you begin, make sure you have the following:

- An AWS account
- The AWS CLI installed on your local machine
- The `kubectl` command-line tool installed
- A VPC configured in an availability zones(ideally in your region)
- A security group that allows traffic between the subnets

### Step 1: Create an EKS Cluster

1. Open the Amazon EKS console and click the "Create cluster" button.
2. Choose a name for your cluster and select the Kubernetes version you want to use.
3. Under Networking, select the VPC and subnets you created earlier.
4. Choose the number of nodes and the instance type you want to use for your worker nodes.
5. Review and create your cluster.

### Step 2: Create an AmazonMQ Broker

1. Open the AmazonMQ console and click "Create a broker."
2. Choose the broker engine you want to use and the instance type you want to use for your broker nodes.
3. Configure the networking settings for your broker.
4. Choose a name for your broker and review your settings.
5. Create your broker.

### Step 3: Create an S3 Bucket

1. Open the Amazon S3 console and click "Create bucket."
2. Choose a globally unique name for your bucket.
3. Choose the region where you want to store your bucket.
4. Configure any additional settings you need for your bucket.
5. Create your bucket.

### Step 4: Deploy and Configure the Sample Application

1. Clone the sample application repository from Github.
2. Open the Kubernetes deployment YAML file and update the variables with your AmazonMQ broker and S3 bucket information.
3. Ensure that you can access the EKS cluster from the terminal.
4. Deploy the sample application to your EKS cluster using `kubectl apply`.
