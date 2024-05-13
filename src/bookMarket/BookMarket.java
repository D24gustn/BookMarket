package bookMarket;

import bookMarket.controller.BookMarketController;
import bookMarket.model.BookStorage;
import bookMarket.model.Cart;
import bookMarket.view.ConsoleView;

public class BookMarket {

	public static void main(String[] args) {
		// model 생성
		BookStorage bookStorage = new BookStorage();
		Cart cart = new Cart();

		// view 생성
		ConsoleView view = new ConsoleView();

		// controller 생성(model, view)
		BookMarketController controller = new BookMarketController(bookStorage, cart, view);
		controller.start();
	}

}