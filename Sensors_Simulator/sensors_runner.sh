#!/usr/bin/env bash
#chmod u+x runner.sh to be able to execute 

python3 OcuppancySender.py 0 & 
python3 OcuppancySender.py 1 & 
python3 OcuppancySender.py 2 & 
python3 OcuppancySender.py 3 & 
python3 OcuppancySender.py 4 &
python3 OcuppancySender.py 5 &
python3 OcuppancySender.py 6 &


python3 TemperatureSender.py 7 &  
python3 TemperatureSender.py 8 &
python3 TemperatureSender.py 9 & 
python3 TemperatureSender.py 10 & 
python3 TemperatureSender.py 11 &
python3 TemperatureSender.py 12 &