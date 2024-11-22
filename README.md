# Telegram OCR Bot

Este projeto implementa um bot para o Telegram que utiliza a biblioteca [Tesseract OCR](https://github.com/tesseract-ocr/tesseract) para processar imagens enviadas pelos usuários e extrair o texto contido nelas. Ele também utiliza o **Gemma** para simplificar o gerenciamento de dependências e automação de tarefas.

## 🚀 Funcionalidades

- Recebe imagens enviadas pelos usuários via Telegram.
- Realiza o download das imagens.
- Processa as imagens utilizando OCR (Tesseract) para reconhecer o texto.
- Retorna o texto extraído diretamente no chat do Telegram.

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Gemma** (gerenciamento de dependências e automação de build)
- **Tesseract OCR** via [Tess4J](https://github.com/nguyenq/tess4j)
- **Telegram Bots API** via [TelegramBots](https://github.com/rubenlagus/TelegramBots)
- **OkHttp** (cliente HTTP usado pela API do Telegram)

## 📋 Pré-requisitos

1. **Java 11 ou superior**.
2. **Tesseract OCR instalado**:
   - Baixe e instale o Tesseract OCR: [Tesseract Downloads](https://github.com/tesseract-ocr/tesseract).
   - Certifique-se de configurar o caminho para o diretório `tessdata` no código:
     ```java
     tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
     ```
   - Altere o idioma conforme necessário (exemplo: `"eng"` para inglês, `"por"` para português):
     ```java
     tesseract.setLanguage("por");
     ```

3. **Token do Bot no Telegram**:
   - Crie um bot usando o [BotFather](https://core.telegram.org/bots#botfather) e obtenha o token de autenticação.

4. **Gemma Configurado**:
   - Baixe o **Gemma** e configure no seu ambiente de desenvolvimento.
   - Certifique-se de que o Gemma esteja sincronizado com as dependências do projeto.

## 📦 Estrutura do Projeto

```plaintext
src/
├── Main.java             # Ponto de entrada do bot
├── MyAmazingBot.java     # Classe que implementa o comportamento do bot
└── resources/
    └── tessdata/         # Diretório onde ficam os dados de linguagem do Tesseract

## Como Executar

- Clone o repositório:

- Compile o projeto: Use sua IDE favorita (como IntelliJ ou Eclipse) ou compile via linha de comando:

- Execute o bot:

- Teste no Telegram:

- Envie uma imagem para o bot e ele retornará o texto extraído.
