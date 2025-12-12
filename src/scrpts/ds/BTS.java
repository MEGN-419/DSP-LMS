package scrpts.ds;

import obj.book;

public class BTS {
    public node root;

    public BTS() {
        this.root = null;
    }

    // Insert Book sorted by ID
    public void insert(book newBook) {
        root = insertRec(root, newBook);
    }

    private node insertRec(node root, book newBook) {
        if (root == null) {
            return new node(newBook);
        }
        if (newBook.bookID < root.data.bookID)
            root.left = insertRec(root.left, newBook);
        else if (newBook.bookID > root.data.bookID)
            root.right = insertRec(root.right, newBook);
        return root;
    }

    // Search by ID
    public book search(int bookID) {
        return searchRec(root, bookID);
    }

    private book searchRec(node root, int bookID) {
        if (root == null) return null;
        if (root.data.bookID == bookID) return root.data;
        if (bookID < root.data.bookID) return searchRec(root.left, bookID);
        return searchRec(root.right, bookID);
    }
}