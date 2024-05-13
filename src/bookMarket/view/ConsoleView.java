package bookMarket.view;

import java.util.Scanner;

import bookMarket.model.BookStorage;
import bookMarket.model.Cart;

public class ConsoleView {

	public void displayWelcome() {
		String welcome = ("*****************************************\n" + "*    Welcome to YoonWu Book Market      *\n"
				+ "*****************************************");
		System.out.println(welcome);
	}

	public int selectMenu(String[] menuList) {
		displayMenu(menuList);
		Scanner input = new Scanner(System.in);
		int menu;
		do {
			System.out.print(">> 메뉴 선택 : ");
			menu = input.nextInt();
			if (menu < 0 || menu >= menuList.length) {
				System.out.println("0부터" + (menuList.length - 1) + "까지의 숫자를 입력하세요.");
			}
		} while (menu < 0 || menu >= menuList.length);

		return menu;
	}

	private void displayMenu(String[] menuList) {
		System.out.println("=========================================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("=========================================");
	}

	public void displayBookInfo(BookStorage mBookStorage) {
		for (int i = 0; i < mBookStorage.getNumBooks(); i++) {
			String bookInfo = mBookStorage.getBookInfo(i);
			System.out.println(bookInfo);
		}
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public void displayCart(Cart mCart) {
		if (mCart.isEmpty()) {
			System.out.println(">>장바구니가 비어있습니다.");
			return;
		}

		for (int i = 0; i < mCart.getNumItems(); i++) {
			System.out.println(mCart.getItemInfo(i));
		}
	}

	public boolean askConfirm(String message, String yes) {
		System.out.println(message);

		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals(yes)) {
			return true;
		} else {
			return false;
		}
	}

	public int selectBookId(BookStorage bookStorage) {
		Scanner input = new Scanner(System.in);
		boolean result;
		int bookId;
		do {
			System.out.println("추가할 도서의 ID를 입력하세요 : ");
			bookId = input.nextInt();
			result = bookStorage.isValidBook(bookId);
			if (!result) {
				System.out.println("잘못된 도서 ID입니다. ");
			}
		} while (!result);

		return bookId;
	}

}