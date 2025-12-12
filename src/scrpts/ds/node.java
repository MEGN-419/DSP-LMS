package scrpts.ds;

import obj.book;

public class node {
    public book data;
    public node left;
    public node right;

    public node(book data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}