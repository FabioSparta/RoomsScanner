#!/usr/bin/env bash
#chmod u+x runner.sh to be able to execute 

python3 OcuppancySender.py 1 & 
python3 OcuppancySender.py 2 & 
python3 OcuppancySender.py 3 & 
python3 OcuppancySender.py 4 & 
python3 OcuppancySender.py 5 &
python3 OcuppancySender.py 6 &
python3 OcuppancySender.py 7 &
python3 OcuppancySender.py 8 &
python3 OcuppancySender.py 9 &
python3 OcuppancySender.py 10 &


python3 TemperatureSender.py 11 &  
python3 TemperatureSender.py 12 &
python3 TemperatureSender.py 13 & 
python3 TemperatureSender.py 14 & 
python3 TemperatureSender.py 15 &
python3 TemperatureSender.py 16 &
python3 TemperatureSender.py 17 &
python3 TemperatureSender.py 18 &
python3 TemperatureSender.py 19 &
python3 TemperatureSender.py 20 &