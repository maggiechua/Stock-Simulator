# Stock Simulator
Java-based stock simulation program integrated with real-time market data, enabling portfolio management and portfolio analysis. 

## Features
- **Real-time stock data** via AlphaVantage API with historical data dating back to 2000
- **Portfolio management** with buy/sell functionality and transaction tracking
- **Performance analytics** including portfolio value tracking and profit/loss calculations
- **Data Persistence** using CSV format to maintain portfolios across sessions
- **MVC architecture** for clean code separation and maintainability

## Technologies Used
- Java (JDK 11+)
- AlphaVantage API (real-time stock data)
- CSV file system (data persistence)
- JUnit for testing (unit testing with mocks)
- Git (version control)

## Limitations
- Text-based interface with incomplete GUI
- Uses AlphaVantage key free version, so has a limit of 25 requests per day
- API key is embedded in source code (suitable for development/demo purposes)
- OS-specific file path configuration required

## Known Issues
- Date validation may fail for existing stocks with outdated local data
- Application may hang if invalid operations are attempted (requires manual termination)
- For best results, use recently queried stock data or query new stocks not currently in program

## How to Run
1. Clone the repository:
```
git clone https://github.com/maggiechua/Stock-Simulator.git
```
2. Configure path to access stock data according to your OS:
  - Open `FileParser.java` (line 39)
  - Set `getOSType()` method to return either "mac" or "windows"
3. Run the program:
    - Open project in IntelliJ IDEA, Eclipse, or VS Code with Java Extension Pack
    - Navigate to `StockProgram.java` and run the main method
  
_Note: This project uses a text-based interface as the GUI implementation is incomplete._

## How to Test
All the tests are located within the `tests` folder:
**Model Tests:** All tests pass - covers core business logic
**View/Controller Tests:** Partial coverage due to interface dependencies

**To run:**
- Right-click on any test file and click on "Run Test"
- Or right-click on the `tests` folder to run all tests

_Note: Tests cover core functionality including portfolio operations, API integration, and data persistence_

## Project Structure
This application follows the Model-View-Controller (MVC) architectural pattern:

- **Model** (`StocksModel`, `StocksModelImpl`): Handles all stock data operations and API interactions
- **View** (`StocksView`, `StocksViewImpl`): Manages user interface and text output using Appendable
- **Controller** (`StocksController`, `StocksControllerImpl`): Coordinates user input processing via Scanner and delegates to Model/View interfaces
- **Main** (`StockProgram`): Entry point that initializes and connects all components

The controller strictly interfaces with Model and View abstractions rather than concrete classes, enabling easy extensibility and maintaining separation of concerns.

## Contributors
Maggie Chua and Aarushi Shankar
