package fx_painting;

public class Painting {
	private int id;
	private String artist;
	private String name;
	private int year;	
	
	public Painting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Painting(int id, String artist, String name, int year) {
		super();
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.year = year;
	}
	public Painting( String artist, String name, int year) {  
		super();
		
		this.artist = artist;
		this.name = name;
		this.year = year;
	}   //constructor without id 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Painting [id=" + id + ", artist=" + artist + ", name=" + name + ", year=" + year + "]";
	}

		
}
