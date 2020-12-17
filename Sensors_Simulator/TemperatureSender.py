import pika  
import json  
import time 
import sys
import os
import random 


RABBIT_HOST= 'localhost' 


def main(argv):

    #Connect
    connection = pika.BlockingConnection(pika.ConnectionParameters(RABBIT_HOST))  
    channel = connection.channel() 
   

   
    id=argv[0]

    pid = os.getpid() 
    print("sensorID:" + str(id) + " PID:" + str(pid))  


    previous=22
    choice=[True,False]
    #Send Data 
    while True:
        time.sleep(random.randint(10,20)) #random() is a value from 0 to 1   => sleep entre 10 a 20 segundos

        a=random.randint(0,1)
        if choice[a]==True:
            temp=previous+a*1.5  #Aumentar temp
        else:                     
            temp=previous-a*1.5  #Diminuir temp
        
        # To avoid values getting unrealistic
        if temp>30:
            temp=30
        if temp<0:
            temp=0
        ##########
    
        previous=temp    

        data = {  
            "id": id,         
            "data": int(temp),           
        } 

        message = json.dumps(data)  
        channel.basic_publish(exchange='PYsensors', routing_key="temperature", body=message) 

        print(" [Sensor_id:+ "+str(id)+"] Sent data to RabbitMQ") 


    connection.close()  


if __name__ == "__main__":
   main(sys.argv[1:])