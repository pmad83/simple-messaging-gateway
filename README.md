# Aplikacja do kolejkowania i dystrybucji wiadomości

## Architektura rozwiązania

### Komponenty systemu

1. **Aplikacja wysyłająca wiadomości** `messages-sender`
    - Aplikacja zbudowana na Spring Boot, której zadaniem jest odbieranie wiadomości z kolejki RabbitMQ i wysyłanie ich na serwer SMTP.
    - Zawiera listener nasłuchujący kolejkę `messagesQueue`, który obsługuje wiadomości e-mail do wysłania.
    - Wysyła wiadomości e-mail przy użyciu protokołu SMTP.
    - W przyszłości może zostać rozszerzona o obsługę innych typów wiadomości, takich jak SMS lub powiadomienia push.

2. **RabbitMQ**
    - System kolejkowy RabbitMQ używany do asynchronicznego przetwarzania wiadomości.
    - Zawiera kolejkę `messagesQueue`, w której przechowywane są wiadomości do wysłania.
    - Umożliwia obsługę różnych typów wiadomości i integrację z różnymi usługami.

### Technologie

Aplikacja korzysta z następujących technologii i komponentów:

- **Java 21** - najnowsza wersja LTS, zapewniająca stabilność i długoterminowe wsparcie.
- **Spring Boot** - główny framework aplikacji.
- **Spring AMQP** - moduł Spring do integracji z RabbitMQ, używany do obsługi asynchronicznej komunikacji między usługami.
- **RabbitMQ** - broker wiadomości używany do obsługi kolejek komunikatów związanych z wiadomościami.

## Uruchomienie aplikacji

W celu uruchomienia aplikacji konieczne jest skompilowanie źródeł oraz zbudowanie aplikacji i kontenerów Docker.
Komiplacja źródeł odbywa się automatycznie z wykorzystaniem Gradle. Poniżej opisano kroki konieczne do uruchomienia aplikacji:

1. Uruchomić Docker Desktop.
2. W konsoli Windows przejść do katalogu `dev` w aplikacji np. `cd C:\git\simple-messaging-gateway\dev`.
3. Uruchomić skrypt `run-docker-containers.bat` - plik ten kompiluje źródła, buduje aplikacje, a także buduje wszystkie obrazy i uruchamia kontenery aplikacji.
4. W celu zatrzymania oraz usunięcia kontenerów i woluminów należy uruchomić skrypt `cleanup-docker-containers.bat`.

## Dostęp do aplikacji

Poniżej znajduje się lista adresów, pod jakimi dostępne są poszczególne komponenty aplikacji.

| Nazwa komponentu                     | Adres                                             |
|--------------------------------------|---------------------------------------------------|
| Interfejs webowy RabbitMQ Management | [http://localhost:15672](http://localhost:15672)  |
| RabbitMQ (połączenia AMQP)           | [http://localhost:5672](http://localhost:5672)    |

Przykładowe zapytanie REST do wyłania wiadomości:

```json
{
"senderId": 1,
"messageType": "EMAIL",
"senderEmail": "nadawca@example.com",
"recipientEmail": "odbiorca@example.com",
"subject": "Przykładowy temat",
"message": "Przykładowa treść wiadomości"
}
```
