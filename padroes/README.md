# 📚 Padrões de Projeto

Este repositório contém exemplos dos padrões de projeto **Strategy**, **Observer** e **Composite**, além de suas diferenças em relação aos anti-patterns correspondentes.  
O objetivo é servir como material de estudo, com resumos, comparações e exemplos de código.

---

## 🔹 Strategy
### Resumo
O padrão **Strategy** define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.  
Ele permite que o algoritmo varie independentemente dos clientes que o utilizam.

### Diferença em relação ao anti-pattern
- **Strategy**: Encapsula a lógica em classes separadas, promovendo reutilização e flexibilidade.  
- **Anti-pattern**: Lógica de decisão embutida diretamente no código do cliente, dificultando manutenção e extensão.

### Exemplo do mundo real
Um personagem de jogo que pode atacar com espada, arco ou magia. A estratégia de ataque pode ser trocada em tempo de execução.

### UML
TODO

---

## 🔹 Observer
### Resumo
O padrão **Observer** define uma dependência um-para-muitos entre objetos, de forma que, quando um objeto muda de estado, todos os seus dependentes são notificados automaticamente.

### Diferença em relação ao anti-pattern
- **Observer**: Promove o desacoplamento entre os objetos, facilitando a escalabilidade.  
- **Anti-pattern**: Dependências diretas entre objetos, que dificultam manutenção e tornam o sistema frágil.

### Exemplo do mundo real
Um canal no YouTube notifica automaticamente os inscritos sempre que um novo vídeo é publicado.

### UML
TODO

---

## 🔹 Composite
### Resumo
O padrão **Composite** permite que objetos sejam organizados em estruturas de árvore para representar hierarquias parte-todo.  
Ele trata objetos individuais e composições de objetos de maneira uniforme.

### Diferença em relação ao anti-pattern
- **Composite**: Estruturas em árvore permitem manipular hierarquias complexas de forma uniforme.  
- **Anti-pattern**: Código redundante ao tratar objetos simples e compostos de forma separada.

### Exemplo do mundo real
Uma empresa que tem **desenvolvedores individuais** e também **times** que podem conter outros times.

### UML
TODO

---

## 📊 Resumo em Tabela

| Padrão    | Problema típico (sem usar o padrão) | Descrição                                                                 | Problema que resolve                                                   | Exemplo do mundo real |
|-----------|--------------------------------------|---------------------------------------------------------------------------|------------------------------------------------------------------------|------------------------|
| Strategy  | Duplicação de código e herança rígida| Encapsula uma família de algoritmos e os torna intercambiáveis via polimorfismo | Permite trocar algoritmos/comportamentos em tempo de execução sem alterar a classe | Personagem de jogo que pode atacar com espada, arco ou magia |
| Observer  | Acoplamento rígido entre classes     | Define uma relação **um-para-muitos**: quando um objeto muda, todos os dependentes são notificados | Evita acoplamento forte entre objetos e garante atualização automática | Canal do YouTube notifica inscritos quando há vídeo novo |
| Composite | Tratamento separado de objetos simples e compostos | Permite criar estruturas em árvore, tratando objetos individuais e composições de forma uniforme | Tratar objetos simples e grupos de objetos de maneira igual | Empresa com desenvolvedores individuais e times que podem conter outros times |

---

