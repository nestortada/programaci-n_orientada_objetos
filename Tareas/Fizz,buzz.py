for numero in range(1,100):
    if numero%3==0 and numero%5==0:
        print("FizzBuzz")
    elif numero%3==0:
        print("Fizz")
    elif numero%5==0:
        print("Buzz")
    else:
        print(numero)
