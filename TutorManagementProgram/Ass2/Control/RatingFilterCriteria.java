package Control;
import Entity.Tutor;

public class RatingFilterCriteria implements FilterCriteriaInterface<Tutor> {
    private double minRating;

    public RatingFilterCriteria(double minRating) {
        this.minRating = minRating;
    }

    @Override
    public boolean filter(Tutor tutor) {
        return tutor.getRating() >= minRating;
    }
}
