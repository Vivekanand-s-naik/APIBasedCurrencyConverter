# Currency Converter App

## Tech Stack

- **Java**: Main programming language for application logic and structure
- **Java Standard Library**: For collections, I/O, networking, and utilities
- **org.json (JSON-java)**: For parsing JSON responses from the exchange rate API
- **ExchangeRate-API**: Public API for fetching real-time currency exchange rates
- **Command Line Interface (CLI)**: User interaction via console

## Project Structure

- `model/` - Data models (e.g., ConversionRequest, CurrencyRate)
- `service/` - Business logic and API interaction (e.g., CurrencyService, ExchangeRateFetcher)
- `controller/` - Handles user requests and coordinates between view and service
- `view/` - Console-based UI (ConsoleUI)
- `config/` - Configuration (e.g., API endpoint)

## How to Run

1. Ensure Java is installed (JDK 8 or higher).
2. Download the `org.json` library and place it in the `lib` directory.
3. Compile all Java files with the classpath including the `lib/json-*.jar`.
4. Run the main class: `com.currencyconverter.Main`.

---

