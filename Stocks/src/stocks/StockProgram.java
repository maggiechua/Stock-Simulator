package stocks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import stocks.controller.StocksController;
import stocks.controller.StocksControllerImpl;
import stocks.view.StocksView;
import stocks.view.StocksViewImpl;
import stocks.model.Portfolio;
import stocks.model.StocksModel;
import stocks.model.StocksModelImpl;

/**
 * This class represents the Stock Program.
 */
public class StockProgram {

  /**
   * This is the main method to run the program.
   */
  public static void main(String[] args) {
    StocksView view;
    StocksController controller;
    String init = "";
    List<Portfolio> p = new ArrayList<>();
    StocksModel model = new StocksModelImpl(init, p);
    model = model.loadPortfolios();
    Readable rd = new InputStreamReader(System.in);

    // This is commented out code for running the GUI view version. Incomplete. Requires
    // imports to properly run.
    /*
     * ReadOnlyModel rm = new ViewModel(model);
     *
     * StocksGUIView.setDefaultLookAndFeelDecorated(false);
     * StocksGUIView gui = new StocksGUIView(rm);
     *
     * gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * gui.setVisible(true);
     * view = gui;
     * controller = new StocksGUIController(model, rd, view);
     */

    // create the controller and view for text-based interface
    view = new StocksViewImpl(System.out);
    controller = new StocksControllerImpl(model, rd, view);

    controller.execute();
  }
}
