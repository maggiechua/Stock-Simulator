package stocks.view;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This interface represents the View for a text-based interface of the Stocks Program where
 * the methods print out messages into the console according to user input.
 */
public interface StocksView {
  /**
   * the welcomeMessage method adds the welcome message to the appendable in the class.
   */
  void welcomeMessage();

  /**
   * the typeInstruct method adds a user instruction frame message to the appendable in the class.
   */
  void typeInstruct();

  /**
   * the undefined method returns an undefined instruction message to the appendable in the class.
   */
  void undefined();

  /**
   * the farewellMessage method adds a farewell message to the appendable in the class.
   */
  void farewellMessage();

  /**
   * the printMenu method adds the initial menu text to the appendable in the class.
   */
  void printMenu();

  /**
   * the printStockMenu method adds the stock menu text to the appendable in the class.
   */
  void printStockMenu();

  /**
   * the returnResult method adds inputted text to the appendable in the class.
   * @param input the result to append
   */
  void returnResult(String input);

  /**
   * the portfolioException method adds minor portfolio error text to the appendable in the class.
   * @param buy a boolean for if the shares are being bought or sold (true is bought)
   */
  void portfolioException(boolean buy);

  /**
   * the formattedResult method adds formatted inputted text to the appendable in the class.
   * @param inp the Double result to format and append
   */
  void formattedReturn(Double inp);

  /**
   * the portfolioCreationMessage method adds creation text to the appendable in the class.
   * @param name the name of the portfolio
   */
  void portfolioCreationMessage(String name);

  /**
   * the buySellMessage method adds buying or selling shares text to the appendable in the class.
   * @param quantity the quantity of shares being sold or bought
   * @param stock the stock symbol
   * @param name the name of the portfolio
   * @param sell a boolean for if the shares are being bought or sold (true is sold)
   */
  void buySellMessage(Integer quantity, String stock, String name, boolean sell);

  /**
   * the askBalance method asks for the specific weight for a stock.
   * @param stock the stock symbol
   */
  void askBalance(String stock);

  /**
   * the balanceInstruction method returns the instructions for inputting weights.
   */
  void balanceInstruction();

  /**
   * the listWrite method adds the list text to the appendable in the class.
   * @param input the map of stocks with their respective share counts
   * @param type the type of list: either distribution or composition
   */
  void listWrite(Map<String, Double> input, String type);

  /**
   * the barWrite method adds the bar graph to the appendable in the class.
   * @param name the name of the stock or portfolio to make a chart for
   * @param date1 the starting date
   * @param date2 the ending date
   * @param input the data input
   * @param scale the scale for the asterisks
   * @param order the chronological order of the dates
   */
  void barWrite(String name, String date1, String date2, HashMap<String, Double> input,
                       Integer scale, List<String> order);

  /**
   * the invalidDate method adds an error message for an invalid date to the appendable.
   * @param type the part of the date (ie. year, month, day) which is incorrect
   */
  void invalidDate(String type);

  /**
   * the askDate method adds a message to ask for the date to the appendable.
   * @param type the part of the date (ie. year, month, day)
   */
  void askDate(String type);

  /**
   * the askDate method adds a message to ask for the portfolio to the appendable.
   */
  void whichPortfolio();

  /**
   * the rebalanced method adds a message returning re-balancing weights to the appendable.
   * @param portfolioName the name of the portfolio being rebalanced
   */
  void rebalanced(String portfolioName);

  /**
   * the setHelpListener method adds a new listener for the help button.
   * @param listen the ActionListener to set up in controller
   */
  void setHelpListener(ActionListener listen);

  /**
   * the setStockActionListener method adds a new listener for the stock actions radio buttons.
   * @param listen the ActionListener to set up in controller
   */
  void setStockActionListener(ActionListener listen);

  /**
   * the setCreatePortfolio method adds a new listener for the create portfolio button.
   * @param listen the ActionListener to set up in controller
   */
  void setCreatePortfolioListener(ActionListener listen);

  /**
   * the setLoadListener method adds a new listener for the load button.
   * @param listen the ActionListener to set up in controller
   */
  void setLoadListener(ActionListener listen);

  /**
   * the setStockSearchListener method adds a new listener for the searching stock text field.
   * @param listen the ActionListener to set up in controller
   */
  void setStockSearchListener(ActionListener listen);

  /**
   * the enterValueListener method adds a new listener for the value text field.
   * @param listen the ActionListener to set up in controller
   */
  void setEnterValueListener(ActionListener listen);

  /**
   * the setYearsListener method adds a new listener for the years scroll.
   * @param listen the ActionListener to set up in controller
   */
  void setYearsListener(ActionListener listen);

  /**
   * the setMonthsListener method adds a new listener for the months scroll.
   * @param listen the ActionListener to set up in controller
   */
  void setMonthsListener(ActionListener listen);

  /**
   * the setDaysListener method adds a new listener for the days scroll.
   * @param listen the ActionListener to set up in controller
   */
  void setDaysListener(ActionListener listen);

  /**
   * the setSearchListener method adds a new listener for the search button.
   * @param listen the ActionListener to set up in controller
   */
  void setSearchListener(ActionListener listen);

  /**
   * the setCreateListener method adds a new listener for the create portfolio button.
   * @param listen the ActionListener to set up in controller
   */
  void setCreateListener(ActionListener listen);

  /**
   * the getYear method gets the text for year.
   */
  String getYear();

  /**
   * the getMonth method gets the text for month.
   */
  String getMonth();

  /**
   * the getDay method gets the text for day.
   */
  String getDay();

  /**
   * the getStock method gets the text for stock input.
   */
  String getStock();

  /**
   * the getPortfolio method gets the text from selection from scrolling list.
   */
  String getPortfolio();

  /**
   * the makePortfolio method gets the text for stock input.
   */
  String makePortfolio();

  /**
   * the getValue method gets the text for value input.
   */
  String getValue();

  /**
   * the setFieldBlank method gets the text to blank.
   */
  void setFieldBlank(String place);

  /**
   * the createHelpWindow method creates a new help window.
   */
  void createHelpWindow();

  /**
   * the loadFileWindow method creates a new window to load a file.
   */
  String loadFileWindow();

  /**
   * the namePortfolioWindow method creates a new window to create a portfolio.
   */
  void namePortfolioWindow();

  /**
   * the closeCreatePortfolio closes the namePortfolioWindow.
   */
  void closeCreatePortfolio();
}