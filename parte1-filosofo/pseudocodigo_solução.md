# Pseudocódigo – Protocólo solução (Garçom).


```
Dados:
  N = 5 filósofos
  Garfos 0..N-1
  Garçom = recurso exclusivo (mutex)

Para cada filósofo p, em paralelo:

  Loop:
    pensar()
    estado[p] <- "com fome"

    adquirir(Garçom)              
    adquirir(garfo_esquerda(p))   
    adquirir(garfo_direita(p))
    liberar(Garçom)               

    estado[p] <- "comendo"
    comer()

    liberar(garfo_direita(p))
    liberar(garfo_esquerda(p))

    estado[p] <- "pensando"



```

O garçom elimina a espera circular, porque ninguém tenta pegar garfos antes de pedir permissão.


