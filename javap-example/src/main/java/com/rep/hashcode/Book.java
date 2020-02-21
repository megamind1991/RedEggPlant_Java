package com.rep.hashcode;

class Book {
    private String title;

    private String author;

    private int pageCount;

    private boolean hardCover;

    private double price;

    /* Must implement the equals() method too. */
    public int hashCode() {
        int hash = 37;
        int code = 0;

        // Use title
        code = (title == null ? 0 : title.hashCode());
        hash = hash * 59 + code;/* from w ww .ja v a 2 s. com */

        // Use author
        code = (author == null ? 0 : author.hashCode());
        hash = hash * 59 + code;

        // Use pageCount
        code = pageCount;
        hash = hash * 59 + code;

        // Use hardCover
        code = (hardCover ? 1 : 0);
        hash = hash * 59 + code;

        // Use price
        long priceBits = Double.doubleToLongBits(price);
        code = (int) (priceBits ^ (priceBits >>> 32));
        hash = hash * 59 + code;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        }
        else if (!author.equals(other.author))
            return false;
        if (hardCover != other.hardCover)
            return false;
        if (pageCount != other.pageCount)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        return true;
    }

}