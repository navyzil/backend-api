# Read Me First
This is the backend-api service for the Stakater Technical Task.

This contains the BACKEND_NAME environment variable which can be modified via backend-api-config.yaml.

# Getting Started
## Part I. Installing and deploying the backend-api service 

1. Execute mvn clean install to create the jar file

2. Execute the following to build the jar file as a docker image: docker build -t backend-api <path_to_project>/backend-api
    
        example: docker build -t backend-api C:/Users/User/Documents/Projects/StakaterTechnicalTask/backend-api
 
3. Apply the changes in backend-api-config.yaml: kube apply -f <path_to_project>/k8/backend-api-config.yaml

        example:kubectl apply -f C:/Users/User/Documents/Projects/StakaterTechnicalTask/backend-api/k8/backend-api-config.yaml
 

## Part II. Running The backend-api service in Kubernettes
1. execute backend-api pod: kube apply -f <path_to_project>/k8/backend-api-pod.yaml

        example:kubectl apply -f C:/Users/User/Documents/Projects/StakaterTechnicalTask/backend-api/k8/backend-api-pod.yaml
This will execute auto run on the cluster.

2. Check if the backend-api pod is running by executing: kubectl get pods -o wide
   
        C:> kubectl get pods -o wide

This will yield the following result: 
    
    NAME               READY   STATUS    RESTARTS   AGE   IP          NODE             NOMINATED NODE   READINESS GATES
    backend-api        1/1     Running   0          25s   10.1.0.26   docker-desktop   <none>           <none>

Take note of the IP address since this will change everytime you will execute the pod. 
We will use the IP Address on setting up the frontend-service

Once you see the STATUS is Running then we can view the backend-api 

3. To view the backend-api on the local browser, execute the following command: kubectl port-forward pod/backend-api port:port
The port is defined based on the containerPort located in the backend-api-pod.yaml 
The usual practice is the ports in backend-api-config.yaml and backend-api-pod.yaml are same values.
   
        example: kubectl port-forward pod/backend-api 8885:8885
From here, once you execute localhost:<port_number>/backend-api on your browser. You will expect to see the word "Hello <BACKEND_NAME>"
        
    example: Given that the BACKEND_NAME=Denzil 
            If we type localhost:8885/backend-api in the browser it will return Hello Denzil

## Part III. Restarting the pod if backend-api-config.yaml is modified
1. Once the changes is done in the backend-api-config.yaml, we need to perform a force delete of the backend-api pod:
     
        kubectl delete pods backend-api --force
This will stop and remove the outdated pod.

2. Follow the steps in Part II.

NOTE: If the frontend-service pod is running or already deployed. You need to update the frontend-service config as well and redeploy the frontend-service since the IP address of pods are changing everytime that it is redeployed in cluster
(For the Repository of frontend-service please see: https://github.com/navyzil/frontend-service)

    
