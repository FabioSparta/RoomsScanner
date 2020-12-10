import pika  
import json  

RABBIT_HOST= 'localhost' 

#Connect
connection = pika.BlockingConnection(pika.ConnectionParameters(RABBIT_HOST))  
channel = connection.channel() 


#Declare queue
#channel.queue_declare(queue="hello99") 


#Send Data
data = {  
    "text": "blabla",         
    "priority": 23,         
    "secret": True     
} 

message = json.dumps(data)  
channel.basic_publish(exchange='PYhellos', routing_key="hello", body=message) 
channel.basic_publish(exchange='PYhellos', routing_key="hello", body=message) 
channel.basic_publish(exchange='PYhellos', routing_key="hello", body=message) 

print(" [x] Sent data to RabbitMQ") 

connection.close()  