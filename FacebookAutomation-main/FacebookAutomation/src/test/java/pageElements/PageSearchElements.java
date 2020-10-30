package pageElements;

public class PageSearchElements {

	public String lohggedInUserName = "//span[text()='%s']";
	public String searchBox = "//input[@aria-label='Search']";
	public String searchButton = "//div[text()='See all results for fetch rewards']/parent::a";
	public String pageLink = "//div[@id='BrowseResultsContainer']/descendant::a[text()='%s']";
	public String likeButton = "//button[starts-with(@class,'likeButton')]";
	public String likedButton = "//a[starts-with(@class,'likedButton')]";
	public String unlikeThePage = "//span[text()='Unlike this Page']";
}
