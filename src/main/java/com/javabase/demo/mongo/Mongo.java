package com.javabase.demo.mongo;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * test 
 */
@Entity(value = "mongo", noClassnameStored = true)
public class Mongo implements Serializable{
    @Id
    private ObjectId _id;
	private String title;
    private String description;
    private String by;
    private String url;
    private String[] tags;
    private int likes;

    @Override
    public String toString() {
        return "Mongo{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", by='" + by + '\'' +
                ", tags='" + tags + '\'' +
                ", likes='" + likes + '\'' +
                ", url=" + url +
                '}';
    }


    public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
