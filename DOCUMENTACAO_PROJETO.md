# Documentação do Projeto — Check-in Rubro-Negro

> **Status:** projeto autoral em desenvolvimento, atualmente na etapa de aplicação console em Java.  
> **Última atualização:** 11/11/2026  
> **Repositório:** https://github.com/lohran-aoc/check-in-rubro-negro  
> **Natureza:** projeto independente, educacional e de portfólio; sem vínculo oficial com clubes ou operadores de estádio.

## 1. Visão geral

O **Check-in Rubro-Negro** é uma aplicação voltada à memória de partidas frequentadas por torcedores. A ideia surgiu da vontade de preservar digitalmente a lembrança de **“eu estava lá”**, em um contexto em que a entrada por biometria facial reduziu o uso de ingressos físicos como recordação.

A proposta combina:

- **Check-in ao vivo:** registro durante uma janela de tempo associada à partida, sujeito a verificações de elegibilidade.
- **Memória de arquibancada:** inclusão de jogos anteriores, inclusive partidas realizadas antes do lançamento da aplicação.
- **Insígnias digitais:** conquistas exclusivas associadas aos check-ins ao vivo válidos.
- **Perfil do torcedor:** histórico de partidas, registros e insígnias.
- **Possíveis funcionalidades futuras:** rankings, desafios e outras experiências de comunidade.

O projeto **não substitui** ingressos, biometria facial nem sistemas oficiais de controle de acesso.

## 2. Objetivos

### 2.1 Objetivo do produto

Permitir que o torcedor construa seu histórico de jogos e diferencie registros declarados de check-ins realizados no período da partida, com as verificações previstas pelo sistema.

### 2.2 Objetivo educacional

Desenvolver progressivamente um projeto de portfólio de **backend Java**, aplicando programação orientada a objetos, coleções, regras de negócio, testes, persistência e, futuramente, desenvolvimento de API REST.

### 2.3 Princípios de desenvolvimento

1. Evoluir em etapas pequenas, com funcionalidades demonstráveis.
2. Não introduzir tecnologias sem necessidade concreta.
3. Manter separadas funcionalidades implementadas, regras definidas e ideias futuras.
4. Registrar decisões relevantes e utilizar Git/GitHub.
5. Priorizar clareza, integridade dos registros e privacidade.

## 3. Vocabulário do domínio

| Termo | Significado |
|---|---|
| **Jogo / partida** | Evento esportivo com adversário, data, horário e estádio. |
| **Usuário / torcedor** | Pessoa que utiliza o sistema e possui um perfil. |
| **Presença** | Registro que associa um usuário a uma partida. |
| **Check-in ao vivo** | Registro solicitado dentro da janela oficial e submetido às verificações exigidas. |
| **Registro histórico** | Declaração retroativa de que o torcedor frequentou uma partida encerrada. |
| **Insígnia exclusiva** | Conquista digital elegível apenas a check-ins ao vivo válidos. |
| **Presença verificada oficialmente** | Comprovação por fonte autorizada de acesso ao estádio; **não implementada** e dependente de integração futura. |

> **Distinção essencial:** geolocalização indica proximidade, mas não comprova, isoladamente, a entrada ou permanência dentro do estádio.

## 4. Regras de negócio definidas

### RN-01 — Janela de check-in ao vivo

- A janela **abre três horas antes** do horário de início da partida.
- A janela **termina ao final da partida**.
- Exemplo: se o jogo começa às **21h30**, a abertura ocorre às **18h30**.
- A identificação do **encerramento efetivo** da partida (acréscimos, prorrogação e atualização de status) ainda precisa ser projetada. Não presumir uma duração fixa.

### RN-02 — Partida confirmada

O check-in ao vivo exige que a partida esteja confirmada e apta a receber registros. O modelo de estados da partida ainda será definido.

### RN-03 — Proximidade do estádio

O check-in ao vivo exige que o torcedor esteja dentro de uma área permitida nas proximidades do estádio. A distância máxima, a forma de obtenção das coordenadas e a proteção contra fraude **ainda não foram definidas**.

### RN-04 — Não duplicidade

Um usuário não pode possuir dois registros de presença para a **mesma partida**. A regra deve valer também quando houver tentativa de registrar historicamente uma partida já registrada ao vivo, ou vice-versa.

### RN-05 — Ingresso e sócio-torcedor não bastam

Possuir ingresso ou ser sócio-torcedor **não autoriza automaticamente** um check-in. As verificações de partida, horário, localização e duplicidade continuam necessárias.

### RN-06 — Registro histórico retroativo

- O usuário poderá registrar partidas **já encerradas**, inclusive jogos anteriores ao lançamento da aplicação.
- O registro histórico também atende a quem compareceu ao jogo, mas esqueceu de fazer check-in no período permitido.
- O registro histórico aparece no perfil e compõe o histórico de partidas do torcedor.
- Não exige comprovação retroativa de localização, mas deve ser identificado como **presença declarada**, não como presença validada ao vivo.

### RN-07 — Elegibilidade de insígnias

- **Check-in ao vivo válido:** elegível à insígnia exclusiva da partida.
- **Registro histórico:** **não** concede a insígnia exclusiva, mesmo que a partida tenha ocorrido após o lançamento do projeto.
- A forma exata de geração, armazenamento e exibição das insígnias será implementada futuramente.

### RN-08 — Histórico e perfil

O perfil deve reunir partidas registradas e insígnias conquistadas, distinguindo visualmente registros históricos/declarados e check-ins ao vivo.

### RN-09 — Rankings (planejamento)

Caso sejam implementados, rankings deverão diferenciar registros declarados de presenças validadas para evitar comparações enganosas. Critérios, pontuação e desempate ainda não estão definidos.

### RN-10 — Remarcação e integridade

Partidas podem ter data, horário ou estádio alterados. O sistema deverá preservar a identidade da partida e a consistência dos registros existentes. O comportamento para partidas canceladas, remarcadas após check-ins ou com estádio alterado **ainda precisa ser especificado**.

## 5. Fluxos funcionais previstos

### 5.1 Check-in ao vivo

1. O usuário seleciona uma partida.
2. O sistema verifica se a partida está confirmada.
3. Verifica se o horário atual está na janela de **3 horas antes até o encerramento**.
4. Verifica se o dispositivo está próximo ao estádio, conforme os critérios configurados.
5. Verifica se o usuário já possui presença naquela partida.
6. Se todas as condições forem atendidas, registra o check-in ao vivo e torna a insígnia exclusiva elegível.
7. Caso alguma condição falhe, informa o motivo sem criar uma nova presença.

**Estado atual:** este fluxo é uma especificação futura. O console hoje simula um check-in sem validação real de horário, localização ou status da partida.

### 5.2 Registro histórico

1. O usuário seleciona uma partida encerrada.
2. O sistema verifica se ela já consta no histórico do usuário.
3. Se ainda não houver registro, cria uma presença do tipo histórico/declarado.
4. Exibe a partida no perfil, **sem insígnia exclusiva**.

**Estado atual:** ainda não implementado.

### 5.3 Consulta do perfil

O perfil deverá mostrar o histórico completo, o tipo de cada presença e as insígnias conquistadas. Filtros por ano e indicação visual de jogos frequentados ou não são ideias de interface para etapas futuras.

## 6. Estado atual do código (verificado no GitHub em 11/11/2026)

A implementação publicada em `src/` contém quatro classes: `Main`, `Jogo`, `Usuario` e `Presenca`. O protótipo é executado no console e guarda os registros somente em memória.

### 6.1 Implementado

| Recurso | Situação |
|---|---|
| Menu console | Consultar jogo, fazer check-in, visualizar perfil e sair |
| Classes de domínio | `Usuario`, `Jogo` e `Presenca` |
| Duas partidas | Estudiantes e Vasco, criadas como objetos `Jogo` |
| Seleção de partida | O usuário escolhe em qual das duas partidas registrar presença |
| Histórico em memória | `List<Presenca>` com `ArrayList<>` |
| Prevenção de duplicidade | Percorre a lista e compara adversário e data da partida |
| Opção de partida inválida | Interrompe o fluxo de check-in sem criar presença |
| Perfil | Mostra nome, situação de sócio-torcedor, total e todas as partidas registradas |

O autor executou testes manuais para seleção de partidas, tentativa de duplicidade, opção inválida e consulta de perfil.

### 6.2 Limitações atuais

- O programa mantém um único usuário e duas partidas fixas.
- O registro é um **check-in simulado**; não há verificação de localização, janela de horário, status confirmado da partida ou encerramento real.
- A comparação por adversário + data é didática, mas não substitui um identificador único e estável da partida.
- `Jogo` armazena data e hora como `String`.
- `checkIns` duplica uma contagem que pode ser obtida com `listaPresencas.size()`; a variável `fezCheckIn` está declarada, mas não é usada.
- `Scanner.nextInt()` ainda pode falhar quando o usuário digita letras ou outros valores não numéricos.
- Não há persistência, autenticação, insígnias, registros históricos diferenciados, testes automatizados, API REST ou banco de dados.
- O `Main` ainda concentra interação com o usuário e regras de negócio; a extração de responsabilidades será trabalhada no Desafio 8.

## 7. Modelagem inicial e decisões técnicas

### 7.1 Classes atuais

- **`Usuario`** — representa o torcedor. A implementação precisa ser conferida quando o arquivo estiver disponível.
- **`Jogo`** — representa a partida e fornece seus dados.
- **`Presenca`** — associa usuário e partida; sua implementação precisa ser conferida quando o arquivo estiver disponível.
- **`Main`** — controla a interação no console; futuramente parte das regras deverá ser extraída para classes com responsabilidades específicas.

### 7.2 Construtores, getters e alterações

- Construtores devem receber informações essenciais para criar objetos válidos.
- Getters permitem consultar atributos quando necessário.
- Setters não devem ser criados automaticamente para todos os atributos.
- Alterações com regras específicas podem utilizar métodos expressivos, como correção de dados do usuário ou remarcação de partida.
- A associação de uma presença a determinado usuário e jogo não deve ser livremente substituída após o registro.

### 7.3 Identificação de partidas

No exercício inicial, comparar **adversário + data** é suficiente para aprender a lógica de comparação. Em um sistema real, isso **não garante unicidade**; cada partida deverá ter um identificador próprio e estável, inclusive quando for remarcada.

### 7.4 Coleções e tipos de presença

- **Implementado:** `ArrayList<Presenca>` armazena várias presenças em memória.
- **Implementado:** `for-each` percorre os registros e verifica duplicidade por adversário e data.
- Um `enum` como `TipoPresenca` (`AO_VIVO`, `HISTORICA`) é uma **proposta de modelagem**, ainda não implementada.
- `instanceof` não é necessário apenas para diferenciar esses tipos de registro.

## 8. Roadmap de desenvolvimento

| Etapa | Entrega esperada | Situação |
|---|---|---|
| **0 — Fundamentos Java/POO** | Classes, construtores, getters, menu e check-in simulado | **Base existente** |
| **1 — Collections** | Duas partidas, `ArrayList<Presenca>`, histórico e prevenção de duplicidade por partida | **Concluída no protótipo (Desafio 7.6)** |
| **2 — Regras de domínio** | Tipos de presença, estados de jogo, validação de datas/horários e elegibilidade de insígnias | Planejada |
| **3 — Qualidade** | Tratamento de erros, organização de responsabilidades e testes com JUnit | Planejada |
| **4 — Persistência** | Modelagem relacional, SQL e PostgreSQL | Planejada |
| **5 — API backend** | Spring Boot, endpoints REST, JPA e documentação da API | Planejada |
| **6 — Segurança** | Autenticação, autorização e proteção de dados | Planejada |
| **7 — Interface web** | Dashboard, partida/check-in, insígnias e histórico por ano | Planejada |
| **8 — Deploy e demonstração** | Publicação, testes de integração, README atualizado e demonstração | Planejada |
| **Futuro** | Avaliar Android, geofencing, notificações e integrações oficiais | Em avaliação |

A ordem entre testes, banco de dados e API poderá ser ajustada conforme o aprendizado; não é necessário concluir um curso inteiro antes de aplicar cada conceito.

### Próximo desafio Java — 8

Separar gradualmente as responsabilidades de interação com o usuário e as regras de check-in, começando por identificar o que deve permanecer no `Main` e o que pode migrar para uma classe de serviço. Preservar os comportamentos já testados.

## 9. Tecnologias

| Área | Situação |
|---|---|
| Java e POO | Utilizados no protótipo console |
| Collections / `ArrayList` | Implementadas no histórico e na prevenção de duplicidades do protótipo |
| JUnit | Planejado |
| SQL / PostgreSQL | Planejado |
| Spring Boot / REST | Planejado |
| Spring Data JPA | Planejado |
| OpenAPI / Swagger | Planejado |
| Frontend web | **A definir:** o README menciona Thymeleaf/HTML/CSS; conversas posteriores também consideraram React/TypeScript. Não há escolha final registrada aqui. |
| Android / Kotlin | Possibilidade futura, não escopo inicial |

## 10. Privacidade, confiabilidade e limites

- Solicitar consentimento/permissão antes de acessar a localização, quando a funcionalidade existir.
- Coletar somente os dados necessários e definir política de retenção.
- Não tratar GPS como prova definitiva de acesso ao estádio; sinais de localização podem ser imprecisos ou manipulados.
- Não apresentar registros históricos declarados como presenças oficialmente verificadas.
- Integrações com biometria, bilheteria ou catracas exigiriam autorização dos responsáveis e análise técnica/jurídica apropriada.
- Evitar uso não autorizado de marcas, escudos e elementos oficiais de clubes em materiais públicos.

## 11. Decisões pendentes

1. Como obter o **horário real de encerramento** de cada partida.
2. Quais estados uma partida terá (agendada, confirmada, em andamento, encerrada, adiada, cancelada etc.).
3. Qual raio de proximidade será permitido e como lidar com falhas de GPS.
4. Como registrar partidas antigas no catálogo e como tratar jogos ainda não cadastrados.
5. Como cancelar/corrigir uma presença sem apagar indevidamente o histórico.
6. Como funcionará a concessão e a representação das insígnias.
7. Quais métricas poderão entrar em rankings sem misturar declarações com check-ins validados.
8. Qual tecnologia de frontend será escolhida para a primeira versão web.
9. Como autenticar usuários e proteger dados pessoais.
10. Qual será o escopo exato do MVP público e de suas simulações.

## 12. Organização da documentação e versionamento

- **`README.md`:** apresentação resumida, estado atual, instruções de execução e links.
- **`DOCUMENTACAO_PROJETO.md`:** regras de negócio, decisões, limitações e roadmap detalhado.
- **Código-fonte:** implementação; em caso de divergência, atualizar a documentação para refletir o estado real.

### Checkpoint de aprendizado

Antes do Desafio 8, explicar a diferença entre **check-in ao vivo**, **registro histórico** e **presença verificada oficialmente**, identificar as responsabilidades atuais do `Main` e confirmar que o check-in simulado para duas partidas continua funcionando.

### Commit sugerido

```bash
git add README.md DOCUMENTACAO_PROJETO.md
git commit -m "docs: atualiza documentacao com progresso do prototipo"
```

---

**Documento vivo:** atualizar sempre que uma regra for modificada, uma decisão técnica for tomada ou uma funcionalidade passar de planejada para implementada.
