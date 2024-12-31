class Carro:
    def __init__(self, marca,color,matricula):
        self.__marca=marca
        self.__color = color
        self.__matricula=matricula
    
    def getMatricula(self):
        return self.__matricula

    def getMarca(self):
        return self.__marca
    
    def setColor(self, NuevoColor):
        self.__color = NuevoColor
        return self.__color
    
    def acelerar(self):
        print(f"el carro de la marca {self.getMarca()} y matricula {self.getMatricula()} esta acelerando")

carro = Carro("Kia" , "Negro","XKJ-998")

print(f"El nuevo color del carro es {carro.setColor("Blanco") }")
carro.acelerar()



class Celular:
    def __init__(self, marca,color,bateria,ubicacion):
        self.__marca =marca
        self.__color=color
        self.__bateria= bateria
        self.__ubicacion =ubicacion
    
    def getMarca(self):
        return self.__marca
    def getColor(self):
        return self.__color
    def descargado(self):
        self.__bateria ="0%"
        print(f" El cleular de la marca {self.getMarca()} se encuentra en {self.__bateria}")
        return self.__bateria
    def cargando(self):
        print(f"Tu celular de la marca {self.getMarca()} se esta cargando ")
    def localizar(self):
        print(f"Tu celular de la marca {self.getMarca()} de color {self.getColor()} se encuetra en {self.__ubicacion}")

celular = Celular("Samsung","Rosado","100%","Bogota")
celular.descargado()
celular.cargando()
celular.localizar()