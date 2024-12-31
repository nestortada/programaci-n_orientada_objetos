while True:
    try:
        i=1
        numero=int(input("""Ingrese el numero:
                        """))
        while numero < 1:
            numero=int(input("""Ingrese un numero mayor a 1 o igual a 1: 
                            """))
        while True:
            if numero%i==0 and numero!=i and i!=1:
                print(f"El numero ({numero}) no es un numero primo ")
                break
            elif numero == i:
                print(f"El numero ({numero}) es un numero primo")
                break
            else:
                i=1+i
        break
    except ValueError:
        print(" Por favor ingrese un numero entero y valido")


