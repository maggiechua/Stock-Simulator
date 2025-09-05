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

## How to Run
1. Clone the repository:
```
git clone
cd stock-simulator
```
2. Configure path to access stock data according to your OS:
- Please enter either "mac" or "windows" in the return for getOSType method on line 39 of `FileParser.java`
3. Run the program:
  - **Using IDE (Recommended):**
    - Open project in IntelliJ IDEA, Eclipse, or VS Code with Java Extension Pack
    - Navigate to `StockProgram.java` and run the main method
  - **Command Line (Alternative)**
    - 
  
_Note: This project uses a text-based interface as the GUI implementation is incomplete._

## Project Structure
This application follows the Model-View-Controller (MVC) architectural pattern:

- **Model** (`StocksModel`, `StocksModelImpl`): Handles all stock data operations and API interactions
- **View** (`StocksView`, `StocksViewImpl`): Manages user interface and text output using Appendable
- **Controller** (`StocksController`, `StocksControllerImpl`): Coordinates user input processing via Scanner and delegates to Model/View interfaces
- **Main** (`StockProgram`): Entry point that initializes and connects all components

The controller strictly interfaces with Model and View abstractions rather than concrete classes, enabling easy extensibility and maintaining separation of concerns.

## Contributors
Maggie Chua and Aarushi Shankar
