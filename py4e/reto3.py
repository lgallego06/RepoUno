datos_original=input('Digite seceuncia de paquetes: ')
datos_original=datos_original.upper()+",a"
datos_original=datos_original.split(",")
print(datos_original)
lista1=[]
lista2=[]
repetidos=0
comparacion=datos_original[0]
for i in range(len(datos_original)):
   #print(i)
   if datos_original[i]==comparacion:
    repetidos+=1
   else:
    lista1.append(comparacion)
    lista2.append(repetidos)
    comparacion=datos_original[i]
    repetidos=1
print(*lista1)

print(*lista2)