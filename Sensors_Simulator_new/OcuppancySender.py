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


    #Send Data 
    while True:
        time.sleep(random.randint(20,70)) #random() is a value from 0 to 1   => sleep entre 10 a 20 segundos
        people=random.randint(0,25)     

        data = {  
            "id": _id,         
            "data": int(people),           
        } 

        message = json.dumps(data)  
        channel.basic_publish(exchange='PYsensors', routing_key="people_counter", body=message) 

        print(" [Sensor_id:+ "+str(_id)+"] Sent data to RabbitMQ" + ", value:" + str(int(people))) 


    connection.close()  


if __name__ == "__main__":
   main(sys.argv[1:])