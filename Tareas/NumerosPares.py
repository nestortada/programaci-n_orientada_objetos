cont=100
estado=0
while True:
    if cont%2==0 and cont!=100:
        print(cont)
        estado= estado+1
    if estado ==30:
        break
    cont= cont+1
