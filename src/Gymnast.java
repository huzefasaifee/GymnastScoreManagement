import java.util.ArrayList;

public class Gymnast {
	public static void main(String[] args)
{
	
	Gymnast g1 = new Gymnast("Lauren", "Hepburn", new ArrayList<Double>() {
		{
			add(9.2);
			add(9.3);
			add(9.0);
			add(9.9);
			add(9.5);
			add(9.5);
			add(9.6);
			add(9.8);
			}
		
	});
	g1.display();
	
	Gymnast g2 = new Gymnast("Kerrie", "Quinn", new ArrayList<Double>() {
		{
			add(9.2);
			add(9.2);
			add(9.0);
			add(9.9);
			add(9.5);
			add(9.5);
			add(9.7);
			add(9.6);
			}
		
	});
	g2.display();
	
	Gymnast g3 = new Gymnast("Sherry", "Paul", new ArrayList<Double>() {
		{
			add(9.7);
			add(9.1);
			add(9.3);
			add(9.4);
			add(9.5);
			add(9.4);
			add(9.6);
			add(9.2);
			}
		
	});
	g3.display();
	
	Gymnast g4 = new Gymnast("Dixie", "Barlow", new ArrayList<Double>() {
		{
			add(9.2);
			add(9.0);
			add(9.1);
			add(9.5);
			add(9.2);
			add(9.3);
			add(9.4);
			add(9.6);
			}
		
	});
	g4.display();
	
	Gymnast g5 = new Gymnast("Sarah", "Holt", new ArrayList<Double>() {
		{
			add(9.2);
			add(9.2);
			add(9.2);
			add(9.9);
			add(9.5);
			add(9.2);
			add(9.3);
			add(9.8);
			}
		
	});
	g5.display();
	
	Gymnast g6 = new Gymnast();
			g6.setFirstName("Jamal");
			g6.setLastName("Evans");
			g6.setScores(new ArrayList<Double>() {
		{
			add(9.2);
			add(9.3);
			add(9.3);
			add(9.7);
			add(9.2);
			add(9.2);
			}
		
	});
			g6.addScore(9.6d);
			g6.addScore(9.8d);
			g6.display();
			
			ArrayList<Double> rank = new ArrayList<Double>(0);
			rank.add(g1.calculateTotalScore());
			rank.add(g2.calculateTotalScore());
			rank.add(g3.calculateTotalScore());
			rank.add(g4.calculateTotalScore());
			rank.add(g5.calculateTotalScore());
			rank.add(g6.calculateTotalScore());
			
			rank.sort(null);
			
			displayTotalScoreRank(rank);
}
	private static void displayTotalScoreRank(ArrayList<Double> rank) {
		// TODO Auto-generated method stub
		System.out.println("\nTotal Score Rank:");
		
		for(int i =rank.size()-1, j=1;i >=1;i--,j++)
		{
			System.out.println("\n\tRank " + j+ " = "+ String.format("%.2f",rank.get(i)));
		}
		System.out.println("\n\tRank " + rank.size()+ " = "+ String.format("%.2f",rank.get(0)));
	}
	private String firstName;
	private String lastName;
	private ArrayList<Double> scores;
	
	public Gymnast(String firstName, String lastName, ArrayList<Double> scores)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.scores = scores;
	}
	
	public Gymnast()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.scores = new ArrayList<Double>(0);
	}
	
	public void setFirstName(String fName)
	{
		this.firstName = fName;
	}
	
	public void setLastName(String lName)
	{
		this.lastName = lName;
	}
	
	public void setScores(ArrayList<Double> scores)
	{
		this.scores = scores;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public ArrayList<Double> getScores()
	{
		return this.scores;
	}
	
	public void addScore(Double score)
	{
		this.scores.add(score);
	}
	
	// sums up the scores
	public Double calculateTotalScore()
	{
		ArrayList<Double> score = getScoresForTotal();
		Double total =  score.stream().mapToDouble(f -> f.doubleValue()).sum();
		return total;
	}
	
	public ArrayList<Double> getScoresForTotal()
	{
		ArrayList<Double> score = new ArrayList<Double>(this.scores) ;
		score.sort(null);
		// remove lowest score
		score.remove(0);
		
		// remove highest score
		score.remove(score.size() -1);
		return score;
	}
	
	public void display()
	{
		System.out.println("\nName: " + this.firstName + " " + this.lastName);
		ArrayList<Double> score = scores;
		for(int i =0;i <score.size();i++)
		{
			System.out.println("\nScore " + (i+1)+ ": "+ score.get(i));
		}
		System.out.println("\nFinal Score: " + String.format("%.2f", this.calculateTotalScore()));
	}
	
}
