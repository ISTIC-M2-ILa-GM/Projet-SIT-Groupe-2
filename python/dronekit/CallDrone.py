from drone import DroneImpl

from dronekit import LocationGlobalRelative

listPoint = []
point1 = [-35.3616, 149.165, 20]
point2 = [-35.3570, 149.165, 15]
point3= [-35.3570, 148.865, 10]
listPoint = [point1,point2,point3]
DroneImpl.Goto(listPoint,"")