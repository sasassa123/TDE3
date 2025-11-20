# Pseudocódigo – Protocólo correto hierarquia de recursos sem deadlock


```
Dados:
  N = 5 filósofos
  Garfos 0..N-1

  garfo_esquerda(p) = p
  garfo_direita(p)  = (p + 1) mod N

Para cada filósofo p, em paralelo:

  Loop infinito:
    pensar()
    estado[p] <- "com fome"

    left  = min(garfo_esquerda(p), garfo_direita(p))
    right = max(garfo_esquerda(p), garfo_direita(p))

    adquirir(left)   
    adquirir(right)  

    estado[p] <- "comendo"
    comer()

    liberar(right)
    liberar(left)

    estado[p] <- "pensando"

```

Esse protocolo remove a espera circular, pois não existe ciclo no grafo de dependências entre garfos.


