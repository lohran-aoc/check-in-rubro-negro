# 🔴⚫ Check-in Rubro-Negro

> A biometria facial tornou a entrada no estádio mais prática, mas bate aquela saudade de guardar o ingresso como lembrança. Este projeto nasceu de uma vontade: devolver ao torcedor a memória de **“eu estava lá”**.

O **Check-in Rubro-Negro** é um projeto independente desenvolvido por um torcedor que está aprendendo Java e quer transformar uma ideia em um sistema real. A proposta não é substituir a biometria ou o controle oficial de acesso, mas criar uma lembrança digital das partidas frequentadas pelo torcedor.

O objetivo também é usar o desenvolvimento do projeto para praticar programação, construir um portfólio e evoluir meus conhecimentos em **Java e desenvolvimento backend**.

## 💡 A ideia

Um sistema de check-in para torcedores, inspirado em redes sociais e coleções digitais:

- 📍 **Check-in em jogos:** identificar se o torcedor está próximo ao estádio durante uma janela de horário definida.
- 🏅 **Insígnias digitais:** registrar partidas e conquistas em uma coleção pessoal.
- 👤 **Perfil do torcedor:** visualizar jogos registrados, insígnias e pontuação.
- 📅 **Memória de arquibancada:** cadastrar manualmente partidas antigas em que o torcedor esteve presente.
- 🏆 **Rankings:** comparar a participação dos torcedores e criar desafios, como chegar cedo ao estádio.

A ideia será desenvolvida por etapas, começando por uma aplicação simples executada no console e evoluindo para um sistema com API, banco de dados e interface web.

## 🚧 Status do projeto

**Em desenvolvimento — etapa inicial em Java.**

O projeto está sendo construído como parte do meu aprendizado. As funcionalidades descritas representam objetivos do roadmap e não significam que já estejam implementadas.

## 🗺️ Roadmap

- [ ] **Fase 1 — Núcleo Java:** criar as classes `Usuario`, `Jogo` e `Presenca`; implementar menu no console, cadastro em memória, check-in simulado e perfil do torcedor.
- [ ] **Fase 2 — Regras de negócio:** impedir check-ins duplicados, validar datas e horários, calcular distâncias com a fórmula de Haversine e implementar insígnias e ranking.
- [ ] **Fase 3 — Qualidade e testes:** organizar responsabilidades, tratar entradas inválidas, escrever testes automatizados e documentar decisões técnicas.
- [ ] **Fase 4 — Backend:** desenvolver uma API REST com Spring Boot, persistência em PostgreSQL e documentação com OpenAPI/Swagger.
- [ ] **Fase 5 — Interface web:** criar telas para jogos, perfil, histórico e check-in, integrando a interface ao backend.
- [ ] **Fase 6 — Publicação e portfólio:** realizar o deploy, gravar uma demonstração e documentar a arquitetura e as funcionalidades concluídas.
- [ ] **Futuro — App Android:** avaliar Kotlin, geofencing e notificações push.

O roadmap poderá mudar conforme o aprendizado e as decisões técnicas tomadas durante o desenvolvimento.

## 🛠️ Tecnologias

| Área | Tecnologia planejada |
|---|---|
| Linguagem | Java 21 |
| Orientação a objetos | Classes, encapsulamento, composição e interfaces quando fizer sentido |
| Testes | JUnit |
| Backend | Spring Boot |
| Banco de dados | PostgreSQL |
| Persistência | Spring Data JPA |
| Documentação da API | OpenAPI / Swagger |
| Interface web | Thymeleaf, HTML e CSS |
| Aplicativo futuro | Kotlin / Android |

As tecnologias serão introduzidas conforme forem necessárias, evitando complexidade antes da hora.

## 🧱 Organização do código

A estrutura inicial prevista para o núcleo Java é:

```text
checkin-nucleo/
└── src/
    └── main/
        └── java/
            └── com/
                └── rubronegro/
                    └── checkin/
                        ├── Main.java
                        ├── model/
                        │   ├── Usuario.java
                        │   ├── Jogo.java
                        │   └── Presenca.java
                        └── service/
                            └── CheckInService.java
```

Essa estrutura é uma proposta inicial e poderá evoluir à medida que novas funcionalidades forem implementadas.

## ▶️ Como executar

**Pré-requisito:** JDK 21 instalado e uma IDE Java, como IntelliJ IDEA.

1. Clone o repositório:

   ```bash
   git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
   ```

2. Abra o projeto na IDE.
3. Execute a classe `Main`.

> As instruções poderão mudar quando o projeto passar a utilizar Maven, banco de dados e Spring Boot.

## ⚠️ Limitações e decisões técnicas

A localização por GPS pode ajudar a identificar a proximidade do estádio, mas não comprova, sozinha, que o torcedor entrou ou assistiu à partida. Além disso, coordenadas podem ser falsificadas.

Por isso, o projeto pretende diferenciar:

- **Presença declarada:** partida registrada manualmente pelo usuário.
- **Check-in por localização:** registro baseado na localização e na janela de horário configurada.
- **Presença verificada:** confirmação que dependeria de uma integração confiável com sistemas de ingresso ou controle de acesso.

Esses registros não devem ser tratados como equivalentes. Uma confirmação oficial exigiria integração e autorização dos responsáveis pelos sistemas envolvidos.

## 🔒 Privacidade

Caso o projeto passe a coletar localização, essa funcionalidade deverá ser explicada com clareza e solicitar a permissão do usuário. A coleta deve ser limitada ao necessário para o check-in, com atenção à proteção dos dados pessoais.

## 📢 Aviso

Este é um projeto independente, desenvolvido por um torcedor e sem vínculo oficial com o Clube de Regatas do Flamengo. Nomes e símbolos do clube pertencem aos respectivos titulares.

## 🤝 Contribuições

Sugestões, críticas construtivas e ideias são bem-vindas. O objetivo é aprender, melhorar o código e desenvolver uma solução cada vez mais interessante.

---

**Feito com Java, café e muita fé na virada.** 🔥🔴⚫
