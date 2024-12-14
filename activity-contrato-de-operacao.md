# **Contrato de Operação: Cadastrar Atividade**

## **Identificação**
- **Código do Caso de Uso**: ECU 004  
- **Nome da Operação**: Cadastrar Atividade  

---

## **Descrição da Operação**
Permite cadastrar uma nova atividade no sistema, como assembleias, reuniões ou capacitações.

---

## **Ator**
- Usuário autenticado no sistema.

---

## **Fluxo Básico**
1. O usuário acessa a funcionalidade **"Cadastrar nova atividade"**.  
2. O sistema exibe uma **tela de cadastro** contendo os seguintes campos:
   - **Duração**  
   - **Local**  
   - **Participantes**  
   - **Objetivo**  
   - **Resumo da atividade**  
3. O usuário preenche todos os campos obrigatórios e confirma o cadastro.  
4. O sistema **salva a atividade** e exibe uma **mensagem de sucesso**.  

---

## **Fluxos Alternativos**
- **A1**: Caso algum campo obrigatório não seja preenchido:
   - O sistema alerta o usuário sobre o erro e solicita o preenchimento.

---

## **Requisitos Especiais**
- Apenas membros previamente cadastrados no sistema podem ser selecionados como **participantes** da atividade.

---

## **Pré-Condições**
- O usuário deve estar **autenticado no sistema**.

---

## **Pós-Condições**
- A atividade é **registrada** no sistema com todas as informações fornecidas.

---

## **Pontos de Extensão**
- As horas registradas na atividade serão **atribuídas** ao membro que realizou a tarefa.
