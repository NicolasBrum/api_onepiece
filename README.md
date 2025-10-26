# 🏴‍☠️ Em busca do One Piece: API do One Piece

## 📜 Descrição do Sistema

Ahoy, futuros piratas do Código!
O lendário Rei dos Piratas, Gol D. Roger, deixou um tesouro inestimável — o One Piece — escondido em algum lugar do mundo!

Agora, os Shichibukais convocaram vocês para uma missão épica:
*⚔️ criar uma API que registre as tripulações e suas aventuras pelos mares!*

Preparem seus teclados, porque essa jornada vai exigir todo o seu Haki do Spring Boot! ⚡

---

# ⚓ Requisitos da Jornada Pirata
## 🧭 Cadastro de Piratas

Cada pirata deve possuir:

- 🆔 ID
- 🏴‍☠️ Nome
- 🧬 Raça: Humano | Ciborgue | Mink | Anão | Tritão
- ☠️ Tripulação: (ex: Chapéus de Palha, Barba Branca, Buggy, etc.)
- 🔒 Status: Ativo ou Capturado

### Endpoints obrigatórios

- ➕ Criar um novo pirata
- ✏️ Atualizar informações de um pirata
- 🔍 Buscar pirata por ID
- 📜 Listar todos os piratas
- ❌ Apagar registro de um pirata

---

## 🏴‍☠️ Missões Piratas

Cada missão é exclusiva de um único pirata 🏴‍☠️
As missões representam suas aventuras, combates e descobertas nos mares.

Cada missão possui:
- 🆔 ID
- ⚠️ Classificação (Danger Level): D | C | B | A | S
(quanto maior, mais perigosa!)
- ⚔️ Tipo de missão: Exploração | Batalha Naval | Saque
- 📊 Status: Concluída | Em andamento

### Endpoints obrigatórios

- ➕ Criar missão
- ✏️ Atualizar missão
- 🔍 Buscar missão por ID
- 📜 Listar todas as missões

#### Consultas especiais

- 🧨 GET /missao/danger/{nivel} → Buscar por nível de perigo
- 🪶 GET /missao/status/{status} → Buscar por status da missão

---

## ⚖️ Regras da Marinha (Validações)

- 🚫 Nenhuma missão pode ser criada sem preencher todos os campos obrigatórios.
- 🚫 Nenhum pirata pode ser cadastrado sem todos os dados necessários.
- 🔗 Cada missão pertence a apenas um pirata.
- 📦 Ao consultar um pirata, deve ser exibida a lista de todas as missões associadas a ele.

## 💥 Técnicas do Novo Mundo (Tecnologias Avaliadas)

### ⚙️ Uso das frutas do Spring Boot:

- Controllers
- Services
- Repositories
- Entities
- DTOs

### 🧭 Relacionamento entre entidades:

- @OneToMany / @ManyToOne

### 🛡️ Protejam seus navios com validações nos campos!

### 🏆 Dicas do Rei dos Piratas

- ⚓ Divida o tempo entre discussões e implementação prática.
- 🏴 Trabalhem em equipe, como uma verdadeira tripulação pirata.
- 💡 O objetivo não é apenas chegar ao One Piece, mas aprender com a jornada!
- 🌟 Boa sorte, jovens capitães!

Que o Haki do Spring e a vontade de se tornar o Rei dos Piratas
guiem vocês nesta aventura pelos sete mares da programação! 🌊
