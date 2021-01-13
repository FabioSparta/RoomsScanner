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
   

   
    _id=argv[0]

    pid = os.getpid() 
    print("sensorID:" + str(_id) + " PID:" + str(pid))  


    temp = 25
    #Send Data 
    while True:
        time.sleep(random.randint(20,70)) #random() is a value from 0 to 1   => sleep entre 10 a 20 segundos

        a = random.randint(0,2)-1
        temp = temp + a
        if(temp<0):
            temp = 1
        elif(temp>30):
            temp = 30

        data = {  
            "id": _id,         
            "data": int(temp),           
        } 

        message = json.dumps(data)  
        channel.basic_publish(exchange='PYsensors', routing_key="temperature", body=message) 

        print(" [Sensor_id:+ "+str(_id)+"] Sent data to RabbitMQ"+ ", value:" + str(int(temp))) 


    connection.close()  


if __name__ == "__main__":
   main(sys.argv[1:])