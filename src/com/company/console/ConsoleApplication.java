package com.company.console;

import com.company.console.action.*;
import com.company.entity.Book;
import com.company.entity.Role;

import static com.company.console.util.ConsoleReader.readInt;
import static com.company.console.util.ConsoleWriter.write;

public class ConsoleApplication {
    public static Session session;

    private final UserAction userAction = new UserAction();
    private final BookAction bookAction = new BookAction();
    private final AuthorAction authorAction = new AuthorAction();
    private final AddressAction addressAction = new AddressAction();
    private final StoreAction storeAction = new StoreAction();
    private final OrderAction orderAction = new OrderAction();

    public void run() {
        while (true) {
            if (session == null) {
                write("Welcome!");
                showGuestMenu();
                switch (readInt()) {
                    case 0:
                        return;
                    case 1:
                        userAction.registration();
                        break;
                    case 2:
                        userAction.authorization();
                        break;
                    default:
                        write("Operation not found");
                }
            } else if (session.getUser().getRole().equals(Role.USER)) {
                write("Hello " + session.getUser().getName());
                showUserMenuForUser();
                switch (readInt()) {
                    case 0:
                        userAction.logout();
                        break;
                    case 1:
                        bookAction.getByName();
                        break;
                    case 2:
                        bookAction.getAll();
                        break;
                    case 3:
                        showAccountMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                userAction.updateNameForUser();
                                break;
                            case 2:
                                userAction.updatePasswordForUser();
                                break;
                        }
                        break;
                    case 4:
                        showBasketMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                if (!ConsoleApplication.session.getBasket().isEmpty()) {
                                    orderAction.save();
                                    ConsoleApplication.session.getBasket().clearBasket();
                                }
                                break;
                        }
                        break;
                }
            } else if (session.getUser().getRole().equals(Role.ADMIN)) {
                write("Hello " + session.getUser().getName());
                showAdminMenu();
                switch (readInt()) {
                    case 0:
                        userAction.logout();
                        break;
                    case 1:
                        showAuthorMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                authorAction.save();
                                break;
                            case 2:
                                authorAction.updateName();
                                break;
                            case 3:
                                authorAction.updateDescription();
                                break;
                            case 4:
                                authorAction.delete();
                                break;
                            case 5:
                                authorAction.deleteByName();
                                break;
                            case 6:
                                authorAction.getByName();
                                break;
                            case 7:
                                authorAction.getById();
                                break;
                            case 8:
                                authorAction.getAll();
                                break;
                        }
                        break;
                    case 2:
                        showBookMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                bookAction.save();
                                break;
                            case 2:
                                bookAction.updateName();
                                break;
                            case 3:
                                bookAction.updateDescription();
                                break;
                            case 4:
                                bookAction.deleteById();
                                break;
                        }
                        break;
                    case 3:
                        showAddressMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                addressAction.save();
                                break;
                            case 2:
                                addressAction.delete();
                            case 3:
                                addressAction.update();
                                break;
                            case 4:
                                addressAction.getAll();
                                break;
                            case 5:
                                addressAction.getByID();
                                break;
                        }
                        break;
                    case 4:
                        showStoreMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                storeAction.save();
                                break;
                            case 2:
                                storeAction.updateTitle();
                                break;
                            case 3:
                                storeAction.updateAddress();
                                break;
                            case 4:
                                storeAction.deleteById();
                                break;
                            case 5:
                                storeAction.deleteTitle();
                                break;
                            case 6:
                                storeAction.getAll();
                                break;
                            case 7:
                                storeAction.getById();
                                break;
                            case 8:
                                storeAction.getByTitle();
                                break;
                        }
                        break;
                    case 5:
                        showOrderMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                orderAction.save();
                                break;
                            case 2:
                                orderAction.updateAddress();
                                break;
                            case 3:
                                orderAction.updateStore();
                                break;
                            case 4:
                                orderAction.updateStatus();
                                break;
                            case 5:
                                orderAction.updateType();
                                break;
                            case 6:
                                orderAction.updateBooks();
                                break;
                            case 7:
                                orderAction.deleteById();
                                break;
                            case 8:
                                orderAction.deleteByOrder();
                                break;
                            case 9:
                                orderAction.getAllByUser();
                                break;
                            case 10:
                                orderAction.getAllByAddress();
                                break;
                            case 11:
                                orderAction.getAllByType();
                                break;
                            case 12:
                                orderAction.getAllByStatus();
                                break;
                        }
                        break;
                    case 6:
                        showUserMenuForAdmin();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                userAction.save();
                                break;
                            case 2:
                                userAction.updateName();
                                break;
                            case 3:
                                userAction.updatePassword();
                                break;
                            case 4:
                                userAction.updateAddress();
                                break;
                            case 5:
                                userAction.updateAge();
                                break;
                            case 6:
                                userAction.deleteById();
                                break;
                            case 7:
                                userAction.deleteByLogin();
                                break;
                            case 8:
                                userAction.getAll();
                            case 9:
                                userAction.getById();
                                break;
                            case 10:
                                userAction.getByLogin();
                                break;
                            case 11:
                                userAction.getAllByName();
                                break;
                            case 12:
                                userAction.getByAddress();
                                break;
                        }
                        break;
                }
            }
        }
    }


    private void showBookMenu() {
        write("0 - Back");
        write("1 - Create Book");
        write("2 - Update name");
        write("3 - Update description");
        write("4 - Delete by id");


    }

    private void showAuthorMenu() {
        write("0 - Back");
        write("1 - Create author");
        write("2 - Update name");
        write("3 - Update description");
        write("4 - Delete");
        write("5 - Delete by name");
        write("6 - Get user by name");
        write("7 - Get user by id");
        write("8 - Get all authors");
    }

    private void showAdminMenu() {
        write("0 - Logout");
        write("1 - Author menu");
        write("2 - Book menu");
        write("3 - Address menu");
        write("4 - Store menu");
        write("5 - Order menu");
        write("6 - User menu");
    }

    private void showGuestMenu() {
        write("0 - Exit");
        write("1 - Registration");
        write("2 - Authorization");
    }

    private void showUserMenuForUser() {
        write("0 - Logout");
        write("1 - Find book");
        write("2 - Show all books");
        write("3 - Update account");
        write("4 - Basket");
    }

    private void showAccountMenu() {
        write("0 - Back");
        write("1 - Update name");
        write("1 - Update password");
    }

    private void showBasketMenu() {
        showBasketItems();
        write("0 - Back");
        if (!ConsoleApplication.session.getBasket().isEmpty()) {
            write("1 - Create order");
        }
    }

    private void showBasketItems() {
        Book[] allBooks = ConsoleApplication.session.getBasket().getAllBooks();
        for (Book allBook : allBooks) {
            write("Book: " + allBook.getName());
        }
    }

    private void showAddressMenu() {
        write("0 - Back");
        write("1 - Create new address");
        write("2 - Delete address");
        write("3 - Update address");
        write("4 - Show all addresses");
        write("5 - Show address by id");

    }

    private void showStoreMenu() {
        write("0 - Back");
        write("1- Create new Store");
        write("2 - Update Store Title");
        write("3- Update Address ");
        write("4 - Delete Store by id");
        write("5 - Delete Store by Title");
        write("6 - Show all Store");
        write("7 - Show Store by id");
        write("8 - Show Store by title");
    }

    private void showOrderMenu() {
        write("0 - Back");
        write("1- Save new order");
        write("2 - Update order address");
        write("3 - Update order store ");
        write("4 - Update order status");
        write("5 - Update order type");
        write("6 - Update order books");
        write("7 - Delete order by id");
        write("8 - Delete order");
        write("9 - Show all orders by user");
        write("10 - Show all orders by address");
        write("11 - Show all orders by type");
        write("12 - Show all orders by status");
    }

    private void showUserMenuForAdmin() {
        write("0 - Back");
        write("1 - Crete new user");
        write("2 - Update name");
        write("3 - Update password");
        write("4 - Update address");
        write("5 - Update age");
        write("6 - Delete by id");
        write("7 - Delete by login");
        write("8 - Show all users");
        write("9 - Show user by id");
        write("10 - Show user by login");
        write("11 - Show users by name");
        write("12 - Show user by address");

    }
}
