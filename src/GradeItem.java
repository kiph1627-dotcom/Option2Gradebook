package src;

public class GradeItem 
{
    private String title;
    private double score;

    public GradeItem(String title, double score) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignment title cant be null or empty");
        }
        if (score < 0.0 || score > 100.0) {
            throw new IllegalArgumentException("Grade score must be between 0.0 and 100.0.");
        }
        this.title = title.trim();
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score < 0.0 || score > 100.0) {
            throw new IllegalArgumentException("Grade score must be between 0.0 and 100.0.");
        }
        this.score = score;
    }
    
    
    @Override
    public String toString() {
        return title + ": " + score;
    }    
}

