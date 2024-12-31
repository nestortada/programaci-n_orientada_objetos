## Tipo de datos
Numero = 1 # Numero entero
flotante=2.4
cadena="Hola"
boolean=False
lista=[1,2,3]

saludo="Hola mundo"

mi_nombre=input("Escriba tu nombre: ")
edad=int(input("Escriba su edad "))#Recibe en datos tipo String
edad= edad +2
print(mi_nombre)
print(edad)

## operadores
num1=50
num2=5

e=num1+num2#ssuma
resta=num1-num2#Resta
multi=num1+num2#Multiplicacion
division=num1/num2#Division
modulo=num1%num2#Modulo
Divison=num1//num2#Division entera

print(sum)
print(multi)
print(resta)
print(division)
print(modulo)
print(Divison)

#Condicionales 
#Operadores logicos <,>,<=,>=,==,!=
if num1>num2:
    print(f"El numero 1 ({num1}) es mayor al numero 2 ({num2})")
elif num2>num1:
    print(f"El numero 2 ({num2}) es mayor al numero 1 ({num1})")
else:
    print("Los numero son iguales")

#Bucles
num1=5
lista=[1,2,3,4,5]
suma=sum(lista)
print(suma)

while True:
    print(num1)
    num1 = 1+num1
    if num1==15:
        break

for l in lista:
    print(l)


#Funciones 
def suma(para1,para2):
    return para1 +para2
print(suma(2,8))
