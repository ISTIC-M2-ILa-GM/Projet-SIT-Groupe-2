from dronekit import LocationGlobalRelative
class Util:
    @staticmethod
    def transformCoordonee(points):
        listpointTransformer = []
        for point in points:
            listpointTransformer.append(LocationGlobalRelative(point[0],point[1], point[2]))
        return listpointTransformer
    @staticmethod
    def printListlocationpoint(listpoint):
        for point in listpoint:
            print(point)