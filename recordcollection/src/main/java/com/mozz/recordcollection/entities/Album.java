package com.mozz.recordcollection.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private int yearOfRelease;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public long getId() {
		return id;
	}
	
	protected Album() { }
	
	public Album(String title, int yearOfRelease) {
		setTitle(title);
		setYearOfRelease(yearOfRelease);
	}
	

    @Override
    public String toString() {
        return String.format(
                "Album[id=%d, title='%s', year='%s']",
                id, title, yearOfRelease);
    }
}
