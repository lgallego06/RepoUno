#Dicionarios
mi_primer_dicc={46441:"Daniel Salazar",46442:"Jose Mora"}
print(mi_primer_dicc)
print(mi_primer_dicc[46441])
mi_primer_dicc[46441]="Laura Camila"
print(mi_primer_dicc[46441])
mi_primer_dicc[46444]="Daniel Salazar"
print(mi_primer_dicc)
del mi_primer_dicc[46441]
print(mi_primer_dicc)
print("\nciclo for")
for key in mi_primer_dicc:
    print(key)
    print(mi_primer_dicc[key])
    if 46444 in mi_primer_dicc:
        print("la contiene")
dicc={"04578-56":["je","ji"],"0000-01":["ja","jo"]}
print(dicc)
print(dicc["04578-56"])
dicc.update(mi_primer_dicc)
print(dicc)

#ejemplo listas
lista_tel=[46441, 46442]
lista_nombres=["Daniel Salazar","Jose Mora"]
def agregar(lista, dato):
    lista.append(dato)
    return lista
def eliminar(lista, dato):
    lista.remove(dato)
    return lista
def actualizar(lista, posicion,dato):
    lista[posicion]=dato
    return lista

nuevo_tel_1=46443
nuevo_nom_1="Lina"
agregar(lista_tel,nuevo_tel_1)
agregar(lista_nombres,nuevo_nom_1)
print(lista_tel)
print(lista_nombres)

eliminar(lista_tel,46442)
eliminar(lista_nombres,"Jose Mora")
print(lista_tel)
print(lista_nombres)

actualizar(lista_tel,1,46452)
actualizar(lista_nombres,1,"Lina")
print(lista_tel)
print(lista_nombres)





