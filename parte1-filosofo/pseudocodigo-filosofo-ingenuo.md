## Pseudocódigo-Protocolo ingênuo com possibilidade de deadlock

```
Dados:
  N = 5 filósofos numerados de 0 a N-1
  Garfos 0..N-1 (garfo i entre filósofo i e (i+1) mod N)

Para cada filósofo p, em paralelo:

  Loop:
    pensar()
    estado[p] <- "com fome"

    adquirir(garfo_esquerda(p))   // pode bloquear
    adquirir(garfo_direita(p))    // pode bloquear

    estado[p] <- "comendo"
    comer()

    liberar(garfo_esquerda(p))
    liberar(garfo_direita(p))

    estado[p] <- "pensando"

```

 
