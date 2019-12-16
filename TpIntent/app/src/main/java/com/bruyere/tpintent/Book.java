package com.bruyere.tpintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String name;
    private long createDate;
    private long releaseDate;

    public Book() {
    }

    public Book(String name, long createDate, long releaseDate) {
        this.name = name;
        this.createDate = createDate;
        this.releaseDate = releaseDate;
    }

    protected Book(Parcel in) {
        name = in.readString();
        createDate = in.readLong();
        releaseDate = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(createDate);
        dest.writeLong(releaseDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
