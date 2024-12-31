class Perro:
    def __init__(self, raza,nombre,color): #Metodo contructor para inicializar una clase
        self.raza   =raza
        self.__nombre = nombre
        self.color=color

    def getNombre(self):
        return self.__nombre
    
    def setNombre(self,nuevoNombre):
        self.__nombre=nuevoNombre
        return self.__nombre
    
    def ladrar(self):
        print(f"{self.getNombre()} esta ladrando ")

    def camianr(self):
        print(f"{self.getNombre()} esta caminando")

perro = Perro("Bulldoge", "Luna","Negro")
print(perro.getNombre())
perro.ladrar()
perro.camianr()

perro2= Perro("Pastor aleman","Toby","Marron")
print(perro2.setNombre("Zeus"))



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


