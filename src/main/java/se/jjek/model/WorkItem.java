package se.jjek.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public final class WorkItem extends AbstractEntity {

	private final String itemName;
	private final String description;
	private final int workStatus;
	
	@OneToMany
	private User user;
	
	@OneToOne
	private Issue issue;

	public WorkItem(String itemName, String description, int workStatus, User user) {
		this.itemName = itemName;
		this.description = description;
		this.workStatus = workStatus;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDescription() {
		return description;
	}

	public int getWorkStatus() {
		return workStatus;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return String.format("WorkItem: %s, Description: %s and Status: %s", itemName,description,workStatus);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other instanceof WorkItem) {
			WorkItem otherItem = (WorkItem) other;
			return itemName.equals(otherItem.itemName);
		}
		return false;
	}

	@Override
	public int hashCode() {

		int result = 1;
		result += 37 * itemName.hashCode();
		
		return result;
	}

}
