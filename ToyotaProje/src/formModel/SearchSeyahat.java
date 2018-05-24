package formModel;

public class SearchSeyahat {
	
	private String username;
	
	private String startDate;
	
	private String finishDate;

	public SearchSeyahat() {
		super();
	}

	public SearchSeyahat(String username, String startDate, String finishDate) {
		super();
		this.username = username;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	@Override
	public String toString() {
		return "SearchSeyahat [username=" + username + ", startDate=" + startDate + ", finishDate=" + finishDate + "]";
	}
	
	
	
}
