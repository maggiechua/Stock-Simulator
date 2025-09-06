package stocks.controller;

import java.nio.file.Path;

import stocks.model.StocksModel;
import stocks.view.StocksView;

/**
 * The following class represents a controller that delegates operations when the view is a
 * GUI.
 */
public class StocksGUIController implements StocksController {
  private Readable rd;
  private StocksModel model;
  private StocksView view;
  private String stockAction;

  /**
   * This makes a new StockControllerImpl.
   * @param model the StocksModel connection (connects to methods to enact based on user inputs)
   * @param rd something to read
   * @param view the StocksView connection (connects to methods to append words)
   */
  public StocksGUIController(StocksModel model, Readable rd, StocksView view)
          throws IllegalArgumentException {
    if ((model == null) || (rd == null)) {
      throw new IllegalArgumentException("Stock or Readable is null");
    }
    this.model = model;
    this.rd = rd;
    this.view = view;
    this.stockAction = "";
  }

  @Override
  public void execute() {
    model = model.loadPortfolios();
    this.setUpListeners();
  }

  /**
   * The following method sets up all the listeners for JComponent items located in the view.
   */
  private void setUpListeners() {
    view.setHelpListener(e -> view.createHelpWindow());
    view.setStockActionListener(e -> setStockAction(e.getActionCommand()));
    view.setCreatePortfolioListener(e -> setCreatePortfolio());
    view.setLoadListener(e -> setLoad());
    view.setStockSearchListener(e -> searchStock());
    view.setEnterValueListener(e -> valueEntered());
    view.setYearsListener(e -> date());
    view.setMonthsListener(e -> date());
    view.setDaysListener(e -> date());
    view.setSearchListener(e -> search());
  }

  /**
   * The following method determines what elements the user has interacted with and calls
   * the methods in the model and view to process them accordingly.
   */
  private void search() {
    String stockName = view.getStock();
    String portfolioName = view.getPortfolio();
    String date = date();
    double value = valueEntered();
    int valueInt = (int) value;
    String answer;
    switch (stockAction) {
      case "portfolio value":
        answer = Double.toString(model.portfolioValue(portfolioName, date));
        view.returnResult(stockAction + ":" + answer);
        break;
      case "portfolio composition":
        view.listWrite(model.composition(portfolioName, date), stockAction);
        break;
      case "buy stock":
        model = model.stockSelect(stockName);
        model.buy(value, date, portfolioName);
        answer = Double.toString(value);
        view.returnResult(stockAction + ":" + answer + ":" + portfolioName);
        break;
      case "sell stock":
        model = model.stockSelect(stockName);
        model.sell(stockName, valueInt, date, portfolioName);
        answer = Double.toString(-value);
        view.returnResult(stockAction + ":" + answer + ":" + portfolioName);
        break;
      default:
        break;
    }
  }

  /**
   * The following method retrieves the date from the view and returns it in the desired format.
   * @return the date as a String
   */
  private String date() {
    String year = view.getYear();
    String month = view.getMonth();
    String day = view.getDay();
    return year + "-" + month + "-" + day;
  }

  /**
   * The following method displays a help window when the user clicks on the button.
   */
  private void showHelp() {
    view.createHelpWindow();
  }

  /**
   * The following method sets the stock action to the current command based on the information
   * extracted from the action listener.
   * @param command represents a command called by the user represented as a String
   */
  private void setStockAction(String command) {
    this.stockAction = command;
  }

  /**
   * The following calls the view to display a window allowing the user to type in the desired
   * name for their portfolio.
   */
  private void setCreatePortfolio() {
    view.namePortfolioWindow();
    view.setCreateListener(e -> createPortfolio());
  }

  /**
   * The following method creates a new portfolio for the user in the StocksProgram.
   */
  private void createPortfolio() {
    model.createPortfolio(view.makePortfolio());
    view.closeCreatePortfolio();
    view.portfolioCreationMessage(view.makePortfolio());
    model = model.loadPortfolios();
  }

  /**
   * The following method loads a file that the user has entered.
   */
  private void setLoad() {
    Path filePath = Path.of(view.loadFileWindow());
    System.out.println("PLEASE PLEAS PLEA");
  }

  /**
   * The following method retrieves the stock that a user has entered.
   * @return the inputted stock as a String
   */
  private String searchStock() {
    return view.getStock();
  }

  /**
   * The following method converts the number of shares entered by the user into
   * a double.
   * @return the number of shares as a double
   */
  private double valueEntered() {
    Double value = 0.0;
    try {
      value = Double.parseDouble(view.getValue());
    }
    catch (NumberFormatException e) {
      view.setFieldBlank("value");
      System.out.println("Please enter a number???");
    }
    return value;
  }
}
